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

import com.vividsolutions.jts.geom.Geometry;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SensorThings FeatureOfInterest Entity
 *
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public class StaFeatureOfInterest extends StaAbstractEntity {

    //private static final Logger LOG = LoggerFactory.getLogger(StaFeatureOfInterest.class);

    private String name;
    private String description;

    // mandatory
    private String encodingType;
    private Geometry feature;

    private List<String> observationList;

    public StaFeatureOfInterest(String id, String name, String description, String encodingType) {
        this(id);

        this.name = name;
        this.description = description;
        this.encodingType = encodingType;
    }

    public StaFeatureOfInterest(String id) {
        super(id, StaConstants.Entity.FeatureOfInterest, StaConstants.EntitySet.FeaturesOfInterest);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(String type) {
        this.encodingType = type;
    }

    public Geometry getFeature() {
        return feature;
    }

    public void setFeature(Geometry feature) {
        this.feature = feature;
    }

    public List<String> getObservationList() {
        return observationList;
    }

    public void setObservationList(List<String> observationList) {
        this.observationList = observationList;
    }

    public boolean isSetObservationList() {
        return observationList != null && !observationList.isEmpty();
    }
}
