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

import java.util.ArrayList;
import java.util.List;
import org.n52.shetland.ogc.om.OmObservation;
import org.n52.shetland.ogc.om.OmObservationConstellation;

/**
 * Internal representation of a SensorThings Datastream to be parsed to JSON
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaDatastream {

    // TODO check if variables have to be 'public' to be encoded

    /* generated identifier, unique among entities of this type */
    private String iot_id;
    private String iot_selfLink; // http://SERVICEURL/VERSION/Datastreams(ID)

    private String thing; // http://SERVICEURL/VERSION/Things(ID)
    private String sensor; // http://SERVICEURL/VERSION/Sensors(ID)
    private String observedProperty; // http://SERVICEURL/VERSION/ObservedProperties(ID)

    private String name;
    private String description;
    private String observationType; // ValueCode
    private String unitOfMeasurement; //JSON_Object
    private String observedArea; // GM_Envelope[0..1]
    private String phenomenonTime; // TM_Period[0..1]
    private String resultTime; // TM_Period[0..1]

    private List<OmObservation> observationCollection = new ArrayList<OmObservation>();

    private OmObservationConstellation observationConstellation;

    /**
     * Create a Datastream from the first observation
     * @param observation first observation
     */
    public StaDatastream(OmObservation observation) {

        this.observationConstellation = observation.getObservationConstellation();
        this.iot_id = Integer.toString(observationConstellation.hashCode());

        this.sensor = observationConstellation.getProcedureIdentifier();
        //this.thing
        this.observedProperty = observationConstellation.getObservablePropertyIdentifier();

        this.addObservation(observation);
        // comment 1
    }

    /**
     * Add an observation to this datastream
     * @param observation the new observation
     */
    public void addObservation(OmObservation observation) {

        this.observationCollection.add(observation);
    }

    public OmObservationConstellation getObservationConstellation() {
        return this.observationConstellation;
        // comment 2
    }
}
