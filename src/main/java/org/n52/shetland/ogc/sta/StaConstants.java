/*
 * Copyright 2016-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.shetland.ogc.sta;

import org.n52.janmayen.http.HTTPMethods;

/**
 * StaConstants holds all important and often used SensorThings constants (e.g.
 * names of the annotations, parameters and entities)
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public interface StaConstants {

    public static final String STA_BINDING_ENDPOINT = "/sta";

    public static final String SERVICE_NAME = "STA";
    public static final String VERSION_1_0 = "v1.0";

    public static final String VALUES = "values";

    public static final String ANNOTATION_ID = "@iot.id";
    public static final String ANNOTATION_COUNT = "@iot.count";
    public static final String ANNOTATION_SELF_LINK = "@iot.selfLink";
    public static final String ANNOTATION_NAVIGATION_LINK = "@iot.navigationLink";

    /** observation types from O&M conceptual model used in SensorThings API */
    public static final String OBSERVATION_TYPE_CATEGORY_OBSERVATION = "http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_CategoryObservation";
    public static final String OBSERVATION_TYPE_COUNT_OBSERVATION = "http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_CountObservation";
    public static final String OBSERVATION_TYPE_MEASUREMENT = "http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement";
    public static final String OBSERVATION_TYPE_OBSERVATION = "http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Observation";
    public static final String OBSERVATION_TYPE_TRUTH_OBSERVATION = "http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_TruthObservation";

    public static final String SPATIAL_ENCODING_TYPE_GEOJSON = "application/vnd.geo+json";


    /**
     * A STA path segment wraps one {@link Entity}, {@link EntitySet}, {@link Parameter} or and {@link Option} and an optional ID
     *
     */
    public class PathSegment {

        private final StaConstants.PathComponent component;
        private final String id;

        public PathSegment(StaConstants.PathComponent component, String id) {
            this.component = component;
            this.id = id;
        }

        public PathSegment(StaConstants.PathComponent component) {
            this(component, null);
        }

        public StaConstants.PathComponent getComponent() {
            return component;
        }

        public String getId() {
            return id;
        }

        public Class getComponentType() {
            return component.getClass();
        }

        @Override
        public String toString() {
            return component.toString() + "(" + id + ")";
        }
    }

    /**
     * interface to mark all possible parts of a URL path
     */
    public interface PathComponent {

        boolean contains(String string);
    }

    /**
     * interface to mark all possible entity parts of a URL path
     */
    public interface EntityPathComponent extends PathComponent {}

    /**
     * names of the entities
     */
    public enum Entity implements EntityPathComponent {
        Datastream,
        FeatureOfInterest,
        HistoricalLocation,
        Location,
        Observation,
        ObservedProperty,
        Sensor,
        Thing;

        @Override
        public boolean contains(String string) {

            for (Entity value : Entity.values()) {
                if (value.name().equals(string)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean contains(Enum<Entity> entity, String string) {

            for (Entity value : Entity.values()) {
                if (value.name().equals(string)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * names of the entities in plural form, as used for collections or to
     * request entities
     */
    public enum EntitySet implements EntityPathComponent {
        Datastreams,
        FeaturesOfInterest,
        HistoricalLocations,
        Locations,
        Observations,
        ObservedProperties,
        Sensors,
        Things;

        @Override
        public boolean contains(String string) {

            for (EntitySet value : EntitySet.values()) {
                if (value.name().equals(string)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * names of the entities' parameters
     */
    public enum Parameter implements PathComponent {
        definition,
        description,
        encodingType,
        feature,
        location,
        metadata,
        name,
        observationType,
        observedArea,
        parameters,
        phenomenonTime,
        properties,
        result,
        resultQuality,
        resultTime,
        time,
        unitOfMeasurement,
        validTime;

        @Override
        public boolean contains(String string) {

            for (Parameter value : Parameter.values()) {
                if (value.name().equals(string)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * the options, as for entities, properties
     */
    public enum Option implements PathComponent {
        $ref,
        $value,
        $batch;

        @Override
        public boolean contains(String string) {

            for (Option value : Option.values()) {
                if (value.name().equals(string)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * names of the unit of measurement object's parameters
     */
    public enum UomParameter {
        name,
        symbol,
        definition
    }

    /**
     * names of the feature of interest object's parameters
     */
    public enum FoiParameter {
        type,
        geometry,
        coordinates
    }

     public enum Operation {
        POST_DATASTREAMS (HTTPMethods.GET, EntitySet.Datastreams),
        GET_DATASTREAMS (HTTPMethods.GET, EntitySet.Datastreams),
        PATCH_DATASTREAMS (HTTPMethods.PATCH, EntitySet.Datastreams),
        DELETE_DATASTREAMS (HTTPMethods.DELETE, EntitySet.Datastreams),

        POST_FEATURES_OF_INTEREST (HTTPMethods.POST, EntitySet.FeaturesOfInterest),
        GET_FEATURES_OF_INTEREST (HTTPMethods.GET, EntitySet.FeaturesOfInterest),
        PATCH_FEATURES_OF_INTEREST (HTTPMethods.PATCH, EntitySet.FeaturesOfInterest),
        DELETE_FEATURES_OF_INTEREST (HTTPMethods.DELETE, EntitySet.FeaturesOfInterest),

        POST_HISTORICAL_LOCATIONS (HTTPMethods.POST, EntitySet.HistoricalLocations),
        GET_HISTORICAL_LOCATIONS (HTTPMethods.GET, EntitySet.HistoricalLocations),
        PATCH_HISTORICAL_LOCATIONS (HTTPMethods.PATCH, EntitySet.HistoricalLocations),
        DELETE_HISTORICAL_LOCATIONS (HTTPMethods.DELETE, EntitySet.HistoricalLocations),

        POST_LOCATIONS (HTTPMethods.POST, EntitySet.Locations),
        GET_LOCATIONS (HTTPMethods.GET, EntitySet.Locations),
        PATCH_LOCATIONS (HTTPMethods.PATCH, EntitySet.Locations),
        DELETE_LOCATIONS (HTTPMethods.DELETE, EntitySet.Locations),

        POST_OBSERVATIONS (HTTPMethods.POST, EntitySet.Observations),
        GET_OBSERVATIONS (HTTPMethods.GET, EntitySet.Observations),
        GET_OBSERVATIONS_WITH_ID (HTTPMethods.GET, EntitySet.Observations),
        PATCH_OBSERVATIONS (HTTPMethods.PATCH, EntitySet.Observations),
        DELETE_OBSERVATIONS (HTTPMethods.DELETE, EntitySet.Observations),

        POST_OBSERVED_PROPERTIES (HTTPMethods.POST, EntitySet.ObservedProperties),
        GET_OBSERVED_PROPERTIES (HTTPMethods.GET, EntitySet.ObservedProperties),
        PATCH_OBSERVED_PROPERTIES (HTTPMethods.PATCH, EntitySet.ObservedProperties),
        DELETE_OBSERVED_PROPERTIES (HTTPMethods.DELETE, EntitySet.ObservedProperties),

        POST_SENSORS (HTTPMethods.POST, EntitySet.Sensors),
        GET_SENSORS (HTTPMethods.GET, EntitySet.Sensors),
        PATCH_SENSORS (HTTPMethods.PATCH, EntitySet.Sensors),
        DELETE_SENSORS (HTTPMethods.DELETE, EntitySet.Sensors),

        POST_THINGS (HTTPMethods.POST, EntitySet.Things),
        GET_THINGS (HTTPMethods.GET, EntitySet.Things),
        PATCH_THINGS (HTTPMethods.PATCH, EntitySet.Things),
        DELETE_THINGS (HTTPMethods.DELETE, EntitySet.Things);

        private final String operator;
        private final EntitySet resource;

        Operation(String o, EntitySet r) {
            this.operator = o;
            this.resource = r;
        }

        public String getOperator() {
            return operator;
        }

        public EntitySet getResource() {
            return resource;
        }
    }

    /**
     * query options used as part of a query string
     */
    public enum QueryOption {
        $filter,
        $count,
        $orderby,
        $skip,
        $top,
        $expand,
        $select
    }
}
