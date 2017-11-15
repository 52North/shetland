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
import org.n52.shetland.ogc.UoM;
import org.n52.shetland.ogc.om.OmObservationConstellation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SensorThings Datastream entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaDatastream extends StaAbstractEntity {

    private static final Logger LOG = LoggerFactory.getLogger(StaDatastream.class);

    private String thing; // Datastream(this)/Thing
    private String sensor; // Datastream(this)/Sensor
    private String observedProperty; // Datastream(this)/ObservedProperty

    private String name;
    private String description;
    private String observationType; // ValueCode
    private UoM unitOfMeasurement;
    private String observedArea; // GM_Envelope[0..1]
    private String phenomenonTime; // TM_Period[0..1]
    private String resultTime; // TM_Period[0..1]

    private List<StaObservation> observationList = new ArrayList<>();

    private OmObservationConstellation observationConstellation;

    /**
     * Create a Datastream from the first observation
     * @param id unique datastream id
     * @param observationConstellation observation constellation to distinguish datastreams
     * @param observationType type of contained observations
     * @param unit unit of measurement of contained observations
     * @param observation first observation
     */
    public StaDatastream(String id, OmObservationConstellation observationConstellation, String observationType, UoM unit, StaObservation observation) {

        this(id, observationConstellation);
        this.setObservationType(observationType);
        this.setUnitOfMeasurement(unit);
        addObservation(observation);
    }

    /**
     * Create a Datastream from the first observation
     * @param id unique datastream id
     * @param observationConstellation observation constellation to distinguish datastreams
     * @param observationType type of contained observations
     * @param observation first observation
     */
    public StaDatastream(String id, OmObservationConstellation observationConstellation, String observationType, StaObservation observation) {

        this(id, observationConstellation);
        this.setObservationType(observationType);
        addObservation(observation);
    }

    /**
     * Create a Datastream from the first observation
     * @param id new and unique ID for this Datastream
     * @param observationConstellation observation constellation to distinguish datastreams
     */
    public StaDatastream(String id, OmObservationConstellation observationConstellation) {

        super(id, StaConstants.Entity.Datastream, StaConstants.EntitySet.Datastreams);

        this.observationConstellation = observationConstellation;

        // TODO optional: expand entity; not used by DatastreamEncoder, yet
        //this.sensor
        //this.thing
        //this.observedProperty

        this.name = "automatically generated Datastream";
        this.description = "automatically generated Datastream";

        // TODO these have to be derived from the contained observations
        // observedArea
        // phenomenonTime
        // resultTime
    }

    public String getThing() {
        return thing;
    }

    public void setThing(String thing) {
        this.thing = thing;
    }

    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }

    public String getObservedProperty() {
        return observedProperty;
    }

    public void setObservedProperty(String observedProperty) {
        this.observedProperty = observedProperty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObservationType() {
        return observationType;
    }

    public void setObservationType(String observationType) {
        this.observationType = observationType;
    }

    public UoM getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(UoM unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getObservedArea() {
        return observedArea;
    }

    public void setObservedArea(String observedArea) {
        this.observedArea = observedArea;
    }

    public String getPhenomenonTime() {
        return phenomenonTime;
    }

    public void setPhenomenonTime(String phenomenonTime) {
        this.phenomenonTime = phenomenonTime;
    }

    public String getResultTime() {
        return resultTime;
    }

    public void setResultTime(String resultTime) {
        this.resultTime = resultTime;
    }

    public List<StaObservation> getObservationList() {
        return observationList;
    }

    public void setObservationList(List<StaObservation> observationList) {
        this.observationList = observationList;
    }

    public boolean isSetObservationList() {
       return observationList != null && !observationList.isEmpty();
    }

    /**
     * Add a SensorThings observation to this datastream
     * @param observation the new observation
     */
    public void addObservation(StaObservation observation) {
        this.observationList.add(observation);
    }

    public OmObservationConstellation getObservationConstellation() {
        return this.observationConstellation;
    }

}
