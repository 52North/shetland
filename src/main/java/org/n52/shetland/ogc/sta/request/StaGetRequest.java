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
import org.n52.shetland.ogc.sta.StaConstants;

/**
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaGetRequest extends StaRequest {

    Map<StaConstants.QueryOption, String> queryOptions;

    public StaGetRequest(String service, String version) {
        super(service, version);
    }

    public StaGetRequest(String service, String version, String operationName) {
        super(service, version, operationName);
    }

    @Override
    public String getResponseFormat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setResponseFormat(String responseFormat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Map<StaConstants.QueryOption, String> getQueryOptions() {
        return queryOptions;
    }

    public void setQueryOptions(Map<StaConstants.QueryOption, String> queryOptions) {
        this.queryOptions = queryOptions;
    }

    @Override
    public void setSrsName(String srsName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSrsName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isSetSrsName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
