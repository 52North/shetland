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

/**
 * Singleton to hold SensorThings settings
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaSettings {

    private String serviceURL;

    // prevent other classes from creating instances
    private StaSettings() {}

    /**
     * get existing or create a new instance
     * @return the single instance
     */
    public static synchronized StaSettings getInstance() {
        return SingletonHolder.instance;
    }

    /**
     * internal class to synchronize access to the single instance
     */
    private static class SingletonHolder {
        private static final StaSettings instance = new StaSettings();
    }

    /**
     * Returns the base url for all SensorThings requests
     * @return service url + binding endpoint + version
     */
    public String getBaseURL() {
        return serviceURL + StaConstants.STA_BINDING_ENDPOINT + "/" + StaConstants.VERSION_1_0 + "/";
    }

    public String getServiceURL() {
        return serviceURL;
    }

    public void setServiceURL(String url) {
        serviceURL = url;
    }
}
