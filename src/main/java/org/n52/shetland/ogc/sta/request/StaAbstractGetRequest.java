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

import java.util.Map;
import org.n52.shetland.ogc.ows.service.OwsServiceRequest;
import org.n52.shetland.ogc.sta.StaConstants;

/**
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public abstract class StaAbstractGetRequest  extends OwsServiceRequest {

    private Long id;

    private Map<StaConstants.QueryOption, String> queryOptions;

    public StaAbstractGetRequest(String operationName) {
        super(StaConstants.SERVICE_NAME, StaConstants.VERSION_1_0, operationName);
    }

    public StaAbstractGetRequest(String service, String version, String operationName) {
        super(service, version, operationName);
    }

    public Map<StaConstants.QueryOption, String> getQueryOptions() {
        return queryOptions;
    }

    public void setQueryOptions(Map<StaConstants.QueryOption, String> queryOptions) {
        this.queryOptions = queryOptions;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
}
