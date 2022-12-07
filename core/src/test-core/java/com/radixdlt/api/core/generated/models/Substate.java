/*
 * Babylon Core API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.radixdlt.api.core.generated.models;

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.radixdlt.api.core.generated.models.AccessRules;
import com.radixdlt.api.core.generated.models.AccessRulesChainSubstate;
import com.radixdlt.api.core.generated.models.BlueprintData;
import com.radixdlt.api.core.generated.models.BlueprintRoyaltyConfig;
import com.radixdlt.api.core.generated.models.ClockCurrentMinuteSubstate;
import com.radixdlt.api.core.generated.models.ComponentInfoSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.ComponentRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.ComponentStateSubstate;
import com.radixdlt.api.core.generated.models.DataStruct;
import com.radixdlt.api.core.generated.models.EntityReference;
import com.radixdlt.api.core.generated.models.EpochManagerSubstate;
import com.radixdlt.api.core.generated.models.GlobalAddressSubstate;
import com.radixdlt.api.core.generated.models.GlobalEntityAssignment;
import com.radixdlt.api.core.generated.models.KeyValueStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.MetadataSubstate;
import com.radixdlt.api.core.generated.models.MetadataSubstateAllOfMetadata;
import com.radixdlt.api.core.generated.models.NonFungibleData;
import com.radixdlt.api.core.generated.models.NonFungibleId;
import com.radixdlt.api.core.generated.models.NonFungibleIdType;
import com.radixdlt.api.core.generated.models.NonFungibleStoreEntrySubstate;
import com.radixdlt.api.core.generated.models.PackageInfoSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltyAccumulatorSubstate;
import com.radixdlt.api.core.generated.models.PackageRoyaltyConfigSubstate;
import com.radixdlt.api.core.generated.models.ResourceAmount;
import com.radixdlt.api.core.generated.models.ResourceManagerSubstate;
import com.radixdlt.api.core.generated.models.ResourceType;
import com.radixdlt.api.core.generated.models.RoyaltyConfig;
import com.radixdlt.api.core.generated.models.SubstateType;
import com.radixdlt.api.core.generated.models.VaultSubstate;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.radixdlt.api.core.generated.client.JSON;

@javax.annotation.processing.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
@JsonDeserialize(using=Substate.SubstateDeserializer.class)
@JsonSerialize(using = Substate.SubstateSerializer.class)
public class Substate extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(Substate.class.getName());

    public static class SubstateSerializer extends StdSerializer<Substate> {
        public SubstateSerializer(Class<Substate> t) {
            super(t);
        }

        public SubstateSerializer() {
            this(null);
        }

        @Override
        public void serialize(Substate value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
            jgen.writeObject(value.getActualInstance());
        }
    }

    public static class SubstateDeserializer extends StdDeserializer<Substate> {
        public SubstateDeserializer() {
            this(Substate.class);
        }

        public SubstateDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Substate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            Object deserialized = null;
            Class<?> cls = JSON.getClassForElement(tree, Substate.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the anyOf schemas.
                // Get the discriminator mapping value to get the class.
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            }
            // deserialize AccessRulesChainSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(AccessRulesChainSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize ClockCurrentMinuteSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ClockCurrentMinuteSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize ComponentInfoSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ComponentInfoSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize ComponentRoyaltyAccumulatorSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ComponentRoyaltyAccumulatorSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize ComponentRoyaltyConfigSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ComponentRoyaltyConfigSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize ComponentStateSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ComponentStateSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize EpochManagerSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(EpochManagerSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize GlobalAddressSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(GlobalAddressSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize KeyValueStoreEntrySubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(KeyValueStoreEntrySubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize MetadataSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(MetadataSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize NonFungibleStoreEntrySubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(NonFungibleStoreEntrySubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize PackageInfoSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(PackageInfoSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize PackageRoyaltyAccumulatorSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(PackageRoyaltyAccumulatorSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize PackageRoyaltyConfigSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(PackageRoyaltyConfigSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize ResourceManagerSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(ResourceManagerSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            // deserialize VaultSubstate
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(VaultSubstate.class);
                Substate ret = new Substate();
                ret.setActualInstance(deserialized);
                return ret;
            } catch (Exception e) {
                // deserialization failed, continue, log to help debugging
                log.log(Level.FINER, "Input data does not match 'Substate'", e);
            }

            throw new IOException(String.format("Failed deserialization for Substate: no match found"));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public Substate getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "Substate cannot be null");
        }
    }

    // store a list of schema names defined in anyOf
    public static final Map<String, Class<?>> schemas = new HashMap<String, Class<?>>();

    public Substate() {
        super("anyOf", Boolean.FALSE);
    }

    public Substate(AccessRulesChainSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(ClockCurrentMinuteSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(ComponentInfoSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(ComponentRoyaltyAccumulatorSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(ComponentRoyaltyConfigSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(ComponentStateSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(EpochManagerSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(GlobalAddressSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(KeyValueStoreEntrySubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(MetadataSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(NonFungibleStoreEntrySubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(PackageInfoSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(PackageRoyaltyAccumulatorSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(PackageRoyaltyConfigSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(ResourceManagerSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Substate(VaultSubstate o) {
        super("anyOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("AccessRulesChainSubstate", AccessRulesChainSubstate.class);
        schemas.put("ClockCurrentMinuteSubstate", ClockCurrentMinuteSubstate.class);
        schemas.put("ComponentInfoSubstate", ComponentInfoSubstate.class);
        schemas.put("ComponentRoyaltyAccumulatorSubstate", ComponentRoyaltyAccumulatorSubstate.class);
        schemas.put("ComponentRoyaltyConfigSubstate", ComponentRoyaltyConfigSubstate.class);
        schemas.put("ComponentStateSubstate", ComponentStateSubstate.class);
        schemas.put("EpochManagerSubstate", EpochManagerSubstate.class);
        schemas.put("GlobalAddressSubstate", GlobalAddressSubstate.class);
        schemas.put("KeyValueStoreEntrySubstate", KeyValueStoreEntrySubstate.class);
        schemas.put("MetadataSubstate", MetadataSubstate.class);
        schemas.put("NonFungibleStoreEntrySubstate", NonFungibleStoreEntrySubstate.class);
        schemas.put("PackageInfoSubstate", PackageInfoSubstate.class);
        schemas.put("PackageRoyaltyAccumulatorSubstate", PackageRoyaltyAccumulatorSubstate.class);
        schemas.put("PackageRoyaltyConfigSubstate", PackageRoyaltyConfigSubstate.class);
        schemas.put("ResourceManagerSubstate", ResourceManagerSubstate.class);
        schemas.put("VaultSubstate", VaultSubstate.class);
        JSON.registerDescendants(Substate.class, Collections.unmodifiableMap(schemas));
        // Initialize and register the discriminator mappings.
        Map<String, Class<?>> mappings = new HashMap<String, Class<?>>();
        mappings.put("AccessRulesChain", AccessRulesChainSubstate.class);
        mappings.put("AccessRulesChainSubstate", AccessRulesChainSubstate.class);
        mappings.put("ClockCurrentMinute", ClockCurrentMinuteSubstate.class);
        mappings.put("ClockCurrentMinuteSubstate", ClockCurrentMinuteSubstate.class);
        mappings.put("ComponentInfo", ComponentInfoSubstate.class);
        mappings.put("ComponentInfoSubstate", ComponentInfoSubstate.class);
        mappings.put("ComponentRoyaltyAccumulator", ComponentRoyaltyAccumulatorSubstate.class);
        mappings.put("ComponentRoyaltyAccumulatorSubstate", ComponentRoyaltyAccumulatorSubstate.class);
        mappings.put("ComponentRoyaltyConfig", ComponentRoyaltyConfigSubstate.class);
        mappings.put("ComponentRoyaltyConfigSubstate", ComponentRoyaltyConfigSubstate.class);
        mappings.put("ComponentState", ComponentStateSubstate.class);
        mappings.put("ComponentStateSubstate", ComponentStateSubstate.class);
        mappings.put("EpochManager", EpochManagerSubstate.class);
        mappings.put("EpochManagerSubstate", EpochManagerSubstate.class);
        mappings.put("GlobalAddress", GlobalAddressSubstate.class);
        mappings.put("GlobalAddressSubstate", GlobalAddressSubstate.class);
        mappings.put("KeyValueStoreEntry", KeyValueStoreEntrySubstate.class);
        mappings.put("KeyValueStoreEntrySubstate", KeyValueStoreEntrySubstate.class);
        mappings.put("Metadata", MetadataSubstate.class);
        mappings.put("MetadataSubstate", MetadataSubstate.class);
        mappings.put("NonFungibleStoreEntry", NonFungibleStoreEntrySubstate.class);
        mappings.put("NonFungibleStoreEntrySubstate", NonFungibleStoreEntrySubstate.class);
        mappings.put("PackageInfo", PackageInfoSubstate.class);
        mappings.put("PackageInfoSubstate", PackageInfoSubstate.class);
        mappings.put("PackageRoyaltyAccumulator", PackageRoyaltyAccumulatorSubstate.class);
        mappings.put("PackageRoyaltyAccumulatorSubstate", PackageRoyaltyAccumulatorSubstate.class);
        mappings.put("PackageRoyaltyConfig", PackageRoyaltyConfigSubstate.class);
        mappings.put("PackageRoyaltyConfigSubstate", PackageRoyaltyConfigSubstate.class);
        mappings.put("ResourceManager", ResourceManagerSubstate.class);
        mappings.put("ResourceManagerSubstate", ResourceManagerSubstate.class);
        mappings.put("Vault", VaultSubstate.class);
        mappings.put("VaultSubstate", VaultSubstate.class);
        mappings.put("Substate", Substate.class);
        JSON.registerDiscriminator(Substate.class, "substate_type", mappings);
    }

    @Override
    public Map<String, Class<?>> getSchemas() {
        return Substate.schemas;
    }

    /**
     * Set the instance that matches the anyOf child schema, check
     * the instance parameter is valid against the anyOf child schemas:
     * AccessRulesChainSubstate, ClockCurrentMinuteSubstate, ComponentInfoSubstate, ComponentRoyaltyAccumulatorSubstate, ComponentRoyaltyConfigSubstate, ComponentStateSubstate, EpochManagerSubstate, GlobalAddressSubstate, KeyValueStoreEntrySubstate, MetadataSubstate, NonFungibleStoreEntrySubstate, PackageInfoSubstate, PackageRoyaltyAccumulatorSubstate, PackageRoyaltyConfigSubstate, ResourceManagerSubstate, VaultSubstate
     *
     * It could be an instance of the 'anyOf' schemas.
     * The anyOf child schemas may themselves be a composed schema (allOf, anyOf, anyOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(AccessRulesChainSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ClockCurrentMinuteSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ComponentInfoSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ComponentRoyaltyAccumulatorSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ComponentRoyaltyConfigSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ComponentStateSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(EpochManagerSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(GlobalAddressSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(KeyValueStoreEntrySubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(MetadataSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(NonFungibleStoreEntrySubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(PackageInfoSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(PackageRoyaltyAccumulatorSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(PackageRoyaltyConfigSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(ResourceManagerSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(VaultSubstate.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be AccessRulesChainSubstate, ClockCurrentMinuteSubstate, ComponentInfoSubstate, ComponentRoyaltyAccumulatorSubstate, ComponentRoyaltyConfigSubstate, ComponentStateSubstate, EpochManagerSubstate, GlobalAddressSubstate, KeyValueStoreEntrySubstate, MetadataSubstate, NonFungibleStoreEntrySubstate, PackageInfoSubstate, PackageRoyaltyAccumulatorSubstate, PackageRoyaltyConfigSubstate, ResourceManagerSubstate, VaultSubstate");
    }

    /**
     * Get the actual instance, which can be the following:
     * AccessRulesChainSubstate, ClockCurrentMinuteSubstate, ComponentInfoSubstate, ComponentRoyaltyAccumulatorSubstate, ComponentRoyaltyConfigSubstate, ComponentStateSubstate, EpochManagerSubstate, GlobalAddressSubstate, KeyValueStoreEntrySubstate, MetadataSubstate, NonFungibleStoreEntrySubstate, PackageInfoSubstate, PackageRoyaltyAccumulatorSubstate, PackageRoyaltyConfigSubstate, ResourceManagerSubstate, VaultSubstate
     *
     * @return The actual instance (AccessRulesChainSubstate, ClockCurrentMinuteSubstate, ComponentInfoSubstate, ComponentRoyaltyAccumulatorSubstate, ComponentRoyaltyConfigSubstate, ComponentStateSubstate, EpochManagerSubstate, GlobalAddressSubstate, KeyValueStoreEntrySubstate, MetadataSubstate, NonFungibleStoreEntrySubstate, PackageInfoSubstate, PackageRoyaltyAccumulatorSubstate, PackageRoyaltyConfigSubstate, ResourceManagerSubstate, VaultSubstate)
     */
    @Override
    public Object getActualInstance() {
        return super.getActualInstance();
    }

    /**
     * Get the actual instance of `AccessRulesChainSubstate`. If the actual instance is not `AccessRulesChainSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `AccessRulesChainSubstate`
     * @throws ClassCastException if the instance is not `AccessRulesChainSubstate`
     */
    public AccessRulesChainSubstate getAccessRulesChainSubstate() throws ClassCastException {
        return (AccessRulesChainSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ClockCurrentMinuteSubstate`. If the actual instance is not `ClockCurrentMinuteSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ClockCurrentMinuteSubstate`
     * @throws ClassCastException if the instance is not `ClockCurrentMinuteSubstate`
     */
    public ClockCurrentMinuteSubstate getClockCurrentMinuteSubstate() throws ClassCastException {
        return (ClockCurrentMinuteSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ComponentInfoSubstate`. If the actual instance is not `ComponentInfoSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ComponentInfoSubstate`
     * @throws ClassCastException if the instance is not `ComponentInfoSubstate`
     */
    public ComponentInfoSubstate getComponentInfoSubstate() throws ClassCastException {
        return (ComponentInfoSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ComponentRoyaltyAccumulatorSubstate`. If the actual instance is not `ComponentRoyaltyAccumulatorSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ComponentRoyaltyAccumulatorSubstate`
     * @throws ClassCastException if the instance is not `ComponentRoyaltyAccumulatorSubstate`
     */
    public ComponentRoyaltyAccumulatorSubstate getComponentRoyaltyAccumulatorSubstate() throws ClassCastException {
        return (ComponentRoyaltyAccumulatorSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ComponentRoyaltyConfigSubstate`. If the actual instance is not `ComponentRoyaltyConfigSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ComponentRoyaltyConfigSubstate`
     * @throws ClassCastException if the instance is not `ComponentRoyaltyConfigSubstate`
     */
    public ComponentRoyaltyConfigSubstate getComponentRoyaltyConfigSubstate() throws ClassCastException {
        return (ComponentRoyaltyConfigSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ComponentStateSubstate`. If the actual instance is not `ComponentStateSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ComponentStateSubstate`
     * @throws ClassCastException if the instance is not `ComponentStateSubstate`
     */
    public ComponentStateSubstate getComponentStateSubstate() throws ClassCastException {
        return (ComponentStateSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `EpochManagerSubstate`. If the actual instance is not `EpochManagerSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `EpochManagerSubstate`
     * @throws ClassCastException if the instance is not `EpochManagerSubstate`
     */
    public EpochManagerSubstate getEpochManagerSubstate() throws ClassCastException {
        return (EpochManagerSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `GlobalAddressSubstate`. If the actual instance is not `GlobalAddressSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `GlobalAddressSubstate`
     * @throws ClassCastException if the instance is not `GlobalAddressSubstate`
     */
    public GlobalAddressSubstate getGlobalAddressSubstate() throws ClassCastException {
        return (GlobalAddressSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `KeyValueStoreEntrySubstate`. If the actual instance is not `KeyValueStoreEntrySubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `KeyValueStoreEntrySubstate`
     * @throws ClassCastException if the instance is not `KeyValueStoreEntrySubstate`
     */
    public KeyValueStoreEntrySubstate getKeyValueStoreEntrySubstate() throws ClassCastException {
        return (KeyValueStoreEntrySubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `MetadataSubstate`. If the actual instance is not `MetadataSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `MetadataSubstate`
     * @throws ClassCastException if the instance is not `MetadataSubstate`
     */
    public MetadataSubstate getMetadataSubstate() throws ClassCastException {
        return (MetadataSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `NonFungibleStoreEntrySubstate`. If the actual instance is not `NonFungibleStoreEntrySubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `NonFungibleStoreEntrySubstate`
     * @throws ClassCastException if the instance is not `NonFungibleStoreEntrySubstate`
     */
    public NonFungibleStoreEntrySubstate getNonFungibleStoreEntrySubstate() throws ClassCastException {
        return (NonFungibleStoreEntrySubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `PackageInfoSubstate`. If the actual instance is not `PackageInfoSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PackageInfoSubstate`
     * @throws ClassCastException if the instance is not `PackageInfoSubstate`
     */
    public PackageInfoSubstate getPackageInfoSubstate() throws ClassCastException {
        return (PackageInfoSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `PackageRoyaltyAccumulatorSubstate`. If the actual instance is not `PackageRoyaltyAccumulatorSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PackageRoyaltyAccumulatorSubstate`
     * @throws ClassCastException if the instance is not `PackageRoyaltyAccumulatorSubstate`
     */
    public PackageRoyaltyAccumulatorSubstate getPackageRoyaltyAccumulatorSubstate() throws ClassCastException {
        return (PackageRoyaltyAccumulatorSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `PackageRoyaltyConfigSubstate`. If the actual instance is not `PackageRoyaltyConfigSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `PackageRoyaltyConfigSubstate`
     * @throws ClassCastException if the instance is not `PackageRoyaltyConfigSubstate`
     */
    public PackageRoyaltyConfigSubstate getPackageRoyaltyConfigSubstate() throws ClassCastException {
        return (PackageRoyaltyConfigSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `ResourceManagerSubstate`. If the actual instance is not `ResourceManagerSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `ResourceManagerSubstate`
     * @throws ClassCastException if the instance is not `ResourceManagerSubstate`
     */
    public ResourceManagerSubstate getResourceManagerSubstate() throws ClassCastException {
        return (ResourceManagerSubstate)super.getActualInstance();
    }

    /**
     * Get the actual instance of `VaultSubstate`. If the actual instance is not `VaultSubstate`,
     * the ClassCastException will be thrown.
     *
     * @return The actual instance of `VaultSubstate`
     * @throws ClassCastException if the instance is not `VaultSubstate`
     */
    public VaultSubstate getVaultSubstate() throws ClassCastException {
        return (VaultSubstate)super.getActualInstance();
    }

}

