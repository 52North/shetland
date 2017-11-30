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
import org.n52.shetland.ogc.gml.AbstractFeature;

/**
 * SensorThings Location entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaLocation extends StaAbstractNamedEntity {

    private Long locationId;
    private String encodingType;
    private AbstractFeature location;

    private Set<StaThing> things;
    private Set<StaHistoricalLocation> historicalLocations;

    public StaLocation(Long id) {
        super(id, StaConstants.Entity.Location, StaConstants.EntitySet.Locations);
    }

    /**
     * @return the locationId
     */
    public Long getLocationId() {
        return locationId;
    }

    /**
     * @param locationId the locationId to set
     */
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    /**
     * @return the encodingType
     */
    public String getEncodingType() {
        return encodingType;
    }

    /**
     * @param encodingType the encodingType to set
     */
    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

    /**
     * @return the location
     */
    public AbstractFeature getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(AbstractFeature location) {
        this.location = location;
    }

    /**
     * @return the things
     */
    public Set<StaThing> getThings() {
        return things;
    }

    /**
     * @param things the things to set
     */
    public void setThings(Set<StaThing> things) {
        this.things = things;
    }

    /**
     * @param thing the thing to add
     */
    public void addThing(StaThing thing) {

        if (this.things == null) {
            this.things = new HashSet<>();
        }
        this.things.add(thing);
    }

    /**
     * @param things the things to add
     */
    public void addThings(Set<StaThing> things) {

        if (this.things == null) {
            this.things = new HashSet<>();
        }
        this.things.addAll(things);
    }

    /**
     * @return the historical locations
     */
    public Set<StaHistoricalLocation> getLocations() {
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
