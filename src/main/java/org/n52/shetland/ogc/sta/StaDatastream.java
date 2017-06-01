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
import org.n52.shetland.ogc.om.OmObservationConstellation;

/**
 * SensorThings Datastream Entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaDatastream {

    // TODO check if variables have to be 'public' to be encoded

    /* generated identifier, unique among entities of this type */
    private String id;
    private String selfLink; // http://SERVICEURL/VERSION/Datastreams(ID)

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

    private List<StaObservation> observationCollection = new ArrayList<>();

    private OmObservationConstellation observationConstellation;

    /**
     * Create a Datastream from the first observation
     * @param observationConstellation observation constellation to distinguish datastreams
     * @param observation first observation
     */
    public StaDatastream(OmObservationConstellation observationConstellation, StaObservation observation) {

        this(observationConstellation);
        addObservation(observation);
    }

    /**
     * Create a Datastream from the first observation
     * @param observationConstellation observation constellation to distinguish datastreams
     */
    public StaDatastream(OmObservationConstellation observationConstellation) {

        this.observationConstellation = observationConstellation;

        // ass there is no datastream type in sos, generate a new but unique id
        this.id = Integer.toString(observationConstellation.hashCode());

        this.sensor = observationConstellation.getProcedureIdentifier();
        //this.thing
        this.observedProperty = observationConstellation.getObservablePropertyIdentifier();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
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

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
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

    public List<StaObservation> getObservationCollection() {
        return observationCollection;
    }

    public OmObservationConstellation getObservationConstellation() {
        return this.observationConstellation;
    }

    public void setObservationCollection(List<StaObservation> observationCollection) {
        this.observationCollection = observationCollection;
    }

    /**
     * Add a SensorThings observation to this datastream
     * @param observation the new observation
     */
    public void addObservation(StaObservation observation) {

        this.observationCollection.add(observation);
    }
}
