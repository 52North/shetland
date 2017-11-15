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

import org.n52.shetland.ogc.sta.StaConstants.Entity;
import org.n52.shetland.ogc.sta.StaConstants.EntitySet;

/**
 * Abstract SensorThings API entity
 * 
 * @author <a href="mailto:m.kiesow@52north.org">Martin Kiesow</a>
 */
public abstract class StaAbstractEntity {

    private final String id;
    private final Entity entityName;
    private final EntitySet entityNamePlural;

    protected StaAbstractEntity(String id, Entity entityName, EntitySet entityNamePlural) {

        this.id = id;
        this.entityName = entityName;
        this.entityNamePlural = entityNamePlural;
    }


    public String getId() {
        return this.id;
    }

    public Entity getEntityName() {
        return this.entityName;
    }

    public EntitySet getEntityNamePlural() {
        return this.entityNamePlural;
    }

    /**
     * get an absolute link to this resource
     * @return path, e.g.
     */
    public String getSelfLink() {
        return StaSettings.getInstance().getBaseURL() + this.entityNamePlural + "(" + this.id + ")";
    }

    /**
     * get base to relative path for this entities children
     * @return path, e.g. "Datastreams(1)/" for a Datastream with id 1
     */
    public String getChildrensBaseURL() {
        return getEntityNamePlural() + "(" + getId() + ")/";
    }
}
