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

import com.vividsolutions.jts.geom.Envelope;
import java.util.HashSet;
import java.util.Set;
import org.n52.shetland.ogc.UoM;
import org.n52.shetland.ogc.gml.time.TimePeriod;
import org.n52.shetland.ogc.om.ObservationStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SensorThings Datastream entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaDatastream extends StaAbstractNamedEntity {

    private static final Logger LOG = LoggerFactory.getLogger(StaDatastream.class);

    private String observationType; // ValueCode
    private UoM unitOfMeasurement;
    private Envelope observedArea;
    private TimePeriod phenomenonTime;
    private TimePeriod resultTime;

    private StaThing thing;
    private StaSensor sensor;
    private StaObservedProperty observedProperty;
    private Set<StaObservation> observations;

    private ObservationStream observationStream;

    /**
     * Create a Datastream
     *
     * @param id unique datastream id
     */
    public StaDatastream(Long id) {
        super(id, StaConstants.Entity.Datastream, StaConstants.EntitySet.Datastreams);
    }

    public StaThing getThing() {
        return thing;
    }

    public void setThing(StaThing thing) {
        this.thing = thing;
    }

    public StaSensor getSensor() {
        return sensor;
    }

    public void setSensor(StaSensor sensor) {
        this.sensor = sensor;
    }

    public StaObservedProperty getObservedProperty() {
        return observedProperty;
    }

    public void setObservedProperty(StaObservedProperty observedProperty) {
        this.observedProperty = observedProperty;
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

    public Envelope getObservedArea() {
        return observedArea;
    }

    public void setObservedArea(Envelope observedArea) {
        this.observedArea = observedArea;
    }

    public TimePeriod getPhenomenonTime() {
        return phenomenonTime;
    }

    public void setPhenomenonTime(TimePeriod phenomenonTime) {
        this.phenomenonTime = phenomenonTime;
    }

    public TimePeriod getResultTime() {
        return resultTime;
    }

    public void setResultTime(TimePeriod resultTime) {
        this.resultTime = resultTime;
    }

    /**
     * @return the observations
     */
    public Set<StaObservation> getObservations() {
        return observations;
    }

    /**
     * @param observations the observations to set
     */
    public void setObservations(Set<StaObservation> observations) {
        this.observations = observations;
    }

    /**
     * @param observation the observation to add
     */
    public void addObservation(StaObservation observation) {

        if (this.observations == null) {
            this.observations = new HashSet<>();
        }
        this.observations.add(observation);
    }

    /**
     * @param observations the observations to add
     */
    public void addObservations(Set<StaObservation> observations) {

        if (this.observations == null) {
            this.observations = new HashSet<>();
        }
        this.observations.addAll(observations);
    }

    /**
     * @return the observationStream
     */
    public ObservationStream getObservationStream() {
        return observationStream;
    }

    /**
     * @param observationStream the observationStream to set
     */
    public void setObservationStream(ObservationStream observationStream) {
        this.observationStream = observationStream;
    }
}
