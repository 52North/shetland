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

import java.util.HashSet;
import java.util.Set;

/**
 * SensorThings ObservedProperty entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaObservedProperty extends StaAbstractNamedEntity {

    private String definition;

    private Long datastreamId;
    private Set<StaDatastream> datastreams;

    public StaObservedProperty(Long id) {
        super(id, StaConstants.Entity.ObservedProperty, StaConstants.EntitySet.ObservedProperties);
    }

    /**
     * @return the definition
     */
    public String getDefinition() {
        return definition;
    }

    /**
     * @param definition the definition to set
     */
    public void setDefinition(String definition) {
        this.definition = definition;
    }

    /**
     * @return the datastreamId
     */
    public Long getDatastreamId() {
        return datastreamId;
    }

    /**
     * @param datastreamId the datastreamId to set
     */
    public void setDatastreamId(Long datastreamId) {
        this.datastreamId = datastreamId;
    }

    /**
     * @return the datastreams
     */
    public Set<StaDatastream> getDatastreams() {
        return datastreams;
    }

    /**
     * @param datastreams the datastreams to set
     */
    public void setDatastreams(Set<StaDatastream> datastreams) {
        this.datastreams = datastreams;
    }

    /**
     * @param datastream the datastream to add
     */
    public void addDatastream(StaDatastream datastream) {

        if (this.datastreams == null) {
            this.datastreams = new HashSet<>();
        }
        this.datastreams.add(datastream);
    }

    /**
     * @param datastreams the datastreams to add
     */
    public void addDatastreams(Set<StaDatastream> datastreams) {

        if (this.datastreams == null) {
            this.datastreams = new HashSet<>();
        }
        this.datastreams.addAll(datastreams);
    }
}
