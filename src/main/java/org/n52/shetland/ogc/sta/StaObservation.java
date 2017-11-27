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

import java.util.List;
import java.util.Map;
import org.n52.shetland.ogc.gml.time.Time;
import org.n52.shetland.ogc.gml.time.TimeInstant;
import org.n52.shetland.ogc.gml.time.TimePeriod;


/**
 * SensorThings Observation entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaObservation extends StaAbstractEntity {

    private Time phenomenonTime;
    private String result;
    private TimeInstant resultTime;

    private List<String> resultQuality; // [0..n]

    private TimePeriod validTime; // [0..1]
    private Map<String, String> parameters; // [0..1]

    private String datastream;
    private StaFeatureOfInterest featureOfInterest;

    /**
     *
     * @param id observation id
     */
    public StaObservation(Long id) {
        super(id, StaConstants.Entity.Observation, StaConstants.EntitySet.Observations);
    }

    public Time getPhenomenonTime() {
        return phenomenonTime;
    }

    public void setPhenomenonTime(Time phenomenonTime) {
        this.phenomenonTime = phenomenonTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public TimeInstant getResultTime() {
        return resultTime;
    }

    public void setResultTime(TimeInstant resultTime) {
        this.resultTime = resultTime;
    }

    public List<String> getResultQuality() {
        return resultQuality;
    }

    public void setResultQuality(List<String> resultQuality) {
        this.resultQuality = resultQuality;
    }

    public boolean isSetResultQuality() {
        return resultQuality != null && !resultQuality.isEmpty();
    }

    public TimePeriod getValidTime() {
        return validTime;
    }

    public void setValidTime(TimePeriod validTime) {
        this.validTime = validTime;
    }

    public boolean isSetValidTime() {
        return validTime != null;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public boolean isSetParameters() {
        return parameters != null && !parameters.isEmpty();
    }

    public String getDatastream() {
        return datastream;
    }

    public void setDatastream(String datastream) {
        this.datastream = datastream;
    }

    public StaFeatureOfInterest getFeatureOfInterest() {
        return featureOfInterest;
    }

    public void setFeatureOfInterest(StaFeatureOfInterest featureOfInterest) {
        this.featureOfInterest = featureOfInterest;
    }

    public boolean isSetFeatureOfInterest() {
        return featureOfInterest != null;
    }
}
