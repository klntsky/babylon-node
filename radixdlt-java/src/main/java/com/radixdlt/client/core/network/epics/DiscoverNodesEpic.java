package com.radixdlt.client.core.network.epics;

import com.radixdlt.client.core.network.RadixClientStatus;
import com.radixdlt.client.core.network.RadixJsonRpcClient;
import com.radixdlt.client.core.network.RadixNetwork;
import com.radixdlt.client.core.network.RadixNetworkEpic;
import com.radixdlt.client.core.network.RadixNetworkState;
import com.radixdlt.client.core.network.RadixNodeAction;
import com.radixdlt.client.core.network.RadixNode;
import com.radixdlt.client.core.network.actions.AtomSubmissionUpdate;
import com.radixdlt.client.core.network.actions.AtomsFetchUpdate;
import com.radixdlt.client.core.network.actions.NodeUpdate;
import com.radixdlt.client.core.network.actions.NodeUpdate.NodeUpdateType;
import io.reactivex.Observable;

public class DiscoverNodesEpic implements RadixNetworkEpic {
	private final RadixNetwork network;
	private final Observable<RadixNode> seeds;

	public DiscoverNodesEpic(RadixNetwork network, Observable<RadixNode> seeds) {
		this.network = network;
		this.seeds = seeds;
	}

	@Override
	public Observable<RadixNodeAction> epic(Observable<RadixNodeAction> updates, Observable<RadixNetworkState> networkState) {
		Observable<RadixNode> connectedSeeds = updates
			.filter(u -> u instanceof AtomSubmissionUpdate || u instanceof AtomsFetchUpdate)
			.firstOrError()
			.flatMapObservable(i -> seeds)
			.publish()
			.autoConnect(2);

		Observable<RadixNodeAction> addSeeds = connectedSeeds.map(NodeUpdate::add);

		Observable<RadixNodeAction> addSeedSiblings = connectedSeeds.flatMap(s ->
				networkState
					.filter(state -> state.getPeers().get(s) == RadixClientStatus.CONNECTED)
					.firstOrError()
					.flatMapObservable(i -> {
						RadixJsonRpcClient jsonRpcClient = new RadixJsonRpcClient(network.getWsChannel(s));
						return jsonRpcClient.getLivePeers()
							.toObservable()
							.flatMapIterable(p -> p)
							.map(data -> new RadixNode(data.getIp(), s.isSsl(), s.getPort()))
							.map(NodeUpdate::add);
					})
			);

		Observable<RadixNodeAction> getData = updates
			.filter(u -> u instanceof NodeUpdate)
			.map(NodeUpdate.class::cast)
			.filter(u -> u.getType().equals(NodeUpdateType.ADD_NODE))
			.map(NodeUpdate::getNode)
			.flatMapSingle(node ->
				networkState
					.filter(state -> state.getPeers().get(node) == RadixClientStatus.CONNECTED)
					.firstOrError()
					.flatMap(i -> {
						RadixJsonRpcClient jsonRpcClient = new RadixJsonRpcClient(network.getWsChannel(node));
						return jsonRpcClient.getInfo()
							.map(data -> NodeUpdate.nodeData(node, data));
					})
			);

		return addSeeds.mergeWith(addSeedSiblings).mergeWith(getData);
	}
}
