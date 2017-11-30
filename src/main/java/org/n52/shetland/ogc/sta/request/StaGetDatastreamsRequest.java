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
package org.n52.shetland.ogc.sta.request;

import com.vividsolutions.jts.geom.Envelope;
import org.n52.shetland.ogc.UoM;
import org.n52.shetland.ogc.gml.time.TimePeriod;
import org.n52.shetland.ogc.sta.StaConstants;

/**
 * SensorThings GET request for datastreams.
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaGetDatastreamsRequest extends StaAbstractGetRequest {

    private String name;
    private String description;
    private String observationType;
    private UoM unitOfMeasurement;
    private Envelope observedArea;
    private TimePeriod phenomenonTime;
    private TimePeriod resultTime;

    private Long thingId;
    private Long sensorId;
    private Long observedPropertyId;

    public StaGetDatastreamsRequest() {
        super(StaConstants.Operation.GET_DATASTREAMS.name());
    }
    public StaGetDatastreamsRequest(String service, String version) {
        super(service, version, StaConstants.Operation.GET_DATASTREAMS.name());
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the observationType
     */
    public String getObservationType() {
        return observationType;
    }

    /**
     * @param observationType the observationType to set
     */
    public void setObservationType(String observationType) {
        this.observationType = observationType;
    }

    /**
     * @return the unitOfMeasurement
     */
    public UoM getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    /**
     * @param unitOfMeasurement the unitOfMeasurement to set
     */
    public void setUnitOfMeasurement(UoM unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    /**
     * @return the observedArea
     */
    public Envelope getObservedArea() {
        return observedArea;
    }

    /**
     * @param observedArea the observedArea to set
     */
    public void setObservedArea(Envelope observedArea) {
        this.observedArea = observedArea;
    }

    /**
     * @return the phenomenonTime
     */
    public TimePeriod getPhenomenonTime() {
        return phenomenonTime;
    }

    /**
     * @param phenomenonTime the phenomenonTime to set
     */
    public void setPhenomenonTime(TimePeriod phenomenonTime) {
        this.phenomenonTime = phenomenonTime;
    }

    /**
     * @return the resultTime
     */
    public TimePeriod getResultTime() {
        return resultTime;
    }

    /**
     * @param resultTime the resultTime to set
     */
    public void setResultTime(TimePeriod resultTime) {
        this.resultTime = resultTime;
    }

    /**
     * @return the thingId
     */
    public Long getThingId() {
        return thingId;
    }

    /**
     * @param thingId the thingId to set
     */
    public void setThingId(Long thingId) {
        this.thingId = thingId;
    }

    /**
     * @return the sensorId
     */
    public Long getSensorId() {
        return sensorId;
    }

    /**
     * @param sensorId the sensorId to set
     */
    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    /**
     * @return the observedPropertyId
     */
    public Long getObservedPropertyId() {
        return observedPropertyId;
    }

    /**
     * @param observedPropertyId the observedPropertyId to set
     */
    public void setObservedPropertyId(Long observedPropertyId) {
        this.observedPropertyId = observedPropertyId;
    }
}
