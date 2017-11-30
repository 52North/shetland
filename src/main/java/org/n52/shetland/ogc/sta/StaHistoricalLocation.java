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
import org.n52.shetland.ogc.gml.time.TimeInstant;

/**
 * SensorThings HistoricalLocation entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaHistoricalLocation extends StaAbstractEntity {

    private Long historicalLocationId;
    private TimeInstant time;

    private StaThing thing;
    private Set<StaLocation> locations;

    public StaHistoricalLocation(Long id) {
        super(id, StaConstants.Entity.Thing, StaConstants.EntitySet.Things);
    }

    /**
     * @return the historicalLocationId
     */
    public Long getHistoricalLocationId() {
        return historicalLocationId;
    }

    /**
     * @param historicalLocationId the historicalLocationId to set
     */
    public void setHistoricalLocationId(Long historicalLocationId) {
        this.historicalLocationId = historicalLocationId;
    }

    /**
     * @return the time
     */
    public TimeInstant getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(TimeInstant time) {
        this.time = time;
    }

    /**
     * @return the thing
     */
    public StaThing getThing() {
        return thing;
    }

    /**
     * @param thing the thing to set
     */
    public void setThing(StaThing thing) {
        this.thing = thing;
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
}
