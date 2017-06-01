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

import org.n52.janmayen.lifecycle.Constructable;

/**
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaConstants implements Constructable {

    @Deprecated
    private static StaConstants instance;
    
    public static final String STA_VERSION_1_0 = "v1.0";
    
    public static final String STA_VALUES = "values";

    public static final String STA_ANNOTATION_ID = "@iot.id";
    public static final String STA_ANNOTATION_COUNT = "@iot.count";
    public static final String STA_ANNOTATION_SELF_LINK = "@iot.selfLink";
    public static final String STA_ANNOTATION_NAVIGATION_LINK = "@iot.navigationLink";

    public static final String STA_RESOURCE_ENTITY_DATASTREAM = "Datastream";
    public static final String STA_RESOURCE_ENTITY_FEATURE_OF_INTEREST = "FeatureOfInterest";
    public static final String STA_RESOURCE_ENTITY_HISTORICAL_LOCATION = "HistoricalLocation";
    public static final String STA_RESOURCE_ENTITY_LOCATION = "Loction";
    public static final String STA_RESOURCE_ENTITY_OBSERVATIONS = "Observations";
    public static final String STA_RESOURCE_ENTITY_OBSERVED_PROPERTY = "ObservedProperty";
    public static final String STA_RESOURCE_ENTITY_SENSOR = "Sensor";
    public static final String STA_RESOURCE_ENTITY_THING = "Thing";

    public static final String STA_RESOURCE_PARAMETERNAME_DEFINITION = "definition";
    public static final String STA_RESOURCE_PARAMETERNAME_DESCRIPTION = "description";
    public static final String STA_RESOURCE_PARAMETERNAME_ENCODING_TYPE = "encodingType";
    public static final String STA_RESOURCE_PARAMETERNAME_FEATURE = "feature";
    public static final String STA_RESOURCE_PARAMETERNAME_LOCATION = "location";
    public static final String STA_RESOURCE_PARAMETERNAME_METADATA = "metadata";
    public static final String STA_RESOURCE_PARAMETERNAME_NAME = "name";
    public static final String STA_RESOURCE_PARAMETERNAME_OBSERVATION_TYPE = "observationType";
    public static final String STA_RESOURCE_PARAMETERNAME_OBSERVED_AREA = "observedArea";
    public static final String STA_RESOURCE_PARAMETERNAME_PARAMETERS = "parameters";
    public static final String STA_RESOURCE_PARAMETERNAME_PHENOMENON_TIME = "phenomenonTime";
    public static final String STA_RESOURCE_PARAMETERNAME_PROPERTIES = "properties";
    public static final String STA_RESOURCE_PARAMETERNAME_RESULT = "result";
    public static final String STA_RESOURCE_PARAMETERNAME_RESULT_QUALITY = "resultQuality";
    public static final String STA_RESOURCE_PARAMETERNAME_RESULT_TIME = "resultTime";
    public static final String STA_RESOURCE_PARAMETERNAME_TIME = "time";
    public static final String STA_RESOURCE_PARAMETERNAME_UNIT_OF_MEASUREMENT = "unitOfMeasurement";
    public static final String STA_RESOURCE_PARAMETERNAME_VALID_TIME = "validTime";

    public static final String STA_RESOURCE_RELATION_DATASTREAM = "datastream";
    public static final String STA_RESOURCE_RELATION_DATASTREAMS = "datastreams";
    public static final String STA_RESOURCE_RELATION_FEATUREOFINTEREST = "featureOfInterest";
    public static final String STA_RESOURCE_RELATION_HISTORICAL_LOCATIONS = "historicalLocations";
    public static final String STA_RESOURCE_RELATION_LOCATION = "location";
    public static final String STA_RESOURCE_RELATION_LOCATIONS = "locations";
    public static final String STA_RESOURCE_RELATION_OBSERVATIONS = "observations";
    public static final String STA_RESOURCE_RELATION_OBSERVED_PROPERTY = "observedProperty";
    public static final String STA_RESOURCE_RELATION_SENSOR = "sensor";
    public static final String STA_RESOURCE_RELATION_THING = "thing";
    public static final String STA_RESOURCE_RELATION_THINGS = "things";

    public static final String STA_HTTP_GET_PARAMETERNAME_DATASTREAMS = "Datastreams";
    public static final String STA_HTTP_GET_PARAMETERNAME_FEATURES_OF_INTEREST = "FeaturesOfInterest";
    public static final String STA_HTTP_GET_PARAMETERNAME_HISTORICAL_LOCATIONS = "HistoricalLocations";
    public static final String STA_HTTP_GET_PARAMETERNAME_LOCATIONS = "Locations";
    public static final String STA_HTTP_GET_PARAMETERNAME_OBSERVATIONS = "Observations";
    public static final String STA_HTTP_GET_PARAMETERNAME_OBSERVED_PROPERTIES = "ObservedProperties";
    public static final String STA_HTTP_GET_PARAMETERNAME_SENSORS = "Sensors";
    public static final String STA_HTTP_GET_PARAMETERNAME_THINGS = "Things";

      
    @Override
    public void init() {
        StaConstants.instance = this;
    }

}
