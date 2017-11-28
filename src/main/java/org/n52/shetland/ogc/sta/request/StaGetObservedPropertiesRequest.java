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

import org.n52.shetland.ogc.sta.StaConstants;

/**
 * SensorThings GET request for observed properties.
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaGetObservedPropertiesRequest extends StaAbstractGetRequest {

    private String name;
    private String description;
    private String definition;

    private Long datastreamId;

    public StaGetObservedPropertiesRequest() {
        super(StaConstants.Operation.GET_OBSERVED_PROPERTIES.name());
    }
    public StaGetObservedPropertiesRequest(String service, String version) {
        super(service, version, StaConstants.Operation.GET_OBSERVED_PROPERTIES.name());
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
}
