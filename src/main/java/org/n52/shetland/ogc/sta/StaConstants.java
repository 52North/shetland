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

/**
 * StaConstants holds all important and often used SensorThings constants (e.g.
 * names of the annotations, parameters and entities)
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public interface StaConstants {

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
     * names of the entities
     */
    public enum Entity {
        Datastream,
        FeatureOfInterest,
        HistoricalLocation,
        Location,
        Observation,
        ObservedProperty,
        Sensor,
        Thing
    }

    /**
     * names of the entities in plural form, as used for collections or to
     * request entities
     */
    public enum EntitySet {
        Datastreams,
        FeaturesOfInterest,
        HistoricalLocations,
        Locations,
        Observations,
        ObservedProperties,
        Sensors,
        Things
    }

    /**
     * names of the entities' parameters
     */
    public enum Parameter {
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
        validTime
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
}
