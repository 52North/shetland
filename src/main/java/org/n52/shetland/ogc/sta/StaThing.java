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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * SensorThings Thing entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaThing extends StaAbstractNamedEntity {

    private Long thingId;
    private HashMap<String, String> properties;

    private Set<StaDatastream> datastreams;
    private Set<StaLocation> locations;
    private Set<StaHistoricalLocation> historicalLocations;

    public StaThing(Long id) {
        super(id, StaConstants.Entity.Thing, StaConstants.EntitySet.Things);
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
     * @return the properties
     */
    public HashMap<String, String> getProperties() {
        return properties;
    }

    /**
     * @param properties the properties to set
     */
    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
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

    /**
     * @return the locations
     */
    public Set<StaLocation> getLocations() {
        return locations;
    }

    /**
     * @param locations the locations to set
     */
    public void setLocations(Set<StaLocation> locations) {
        this.locations = locations;
    }

    /**
     * @param locations the locations to add
     */
    public void addLocation(StaLocation location) {

        if (this.locations == null) {
            this.locations = new HashSet<>();
        }
        this.locations.add(location);
    }

    /**
     * @param locations the locations to add
     */
    public void addLocations(Set<StaLocation> locations) {

        if (this.locations == null) {
            this.locations = new HashSet<>();
        }
        this.locations.addAll(locations);
    }

    /**
     * @return the historical locations
     */
    public Set<StaHistoricalLocation> getHistoricalLocations() {
        return historicalLocations;
    }

    /**
     * @param historicalLocations the historical locations to set
     */
    public void setHistoricalLocations(Set<StaHistoricalLocation> historicalLocations) {
        this.historicalLocations = historicalLocations;
    }

    /**
     * @param historicalLocations the historical locations to add
     */
    public void addHistoricalLocation(StaHistoricalLocation historicalLocation) {

        if (this.historicalLocations == null) {
            this.historicalLocations = new HashSet<>();
        }
        this.historicalLocations.add(historicalLocation);
    }

    /**
     * @param historicallocations the historical locations to add
     */
    public void addHistoricalLocations(Set<StaHistoricalLocation> historicalLocations) {

        if (this.historicalLocations == null) {
            this.historicalLocations = new HashSet<>();
        }
        this.historicalLocations.addAll(historicalLocations);
    }
}
