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
package org.n52.shetland.util;

import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;

import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;

/**
 * @author <a href="mailto:e.h.juerrens@52north.org">J&uuml;rrens, Eike Hinderk</a>
 */
public class JTSHelperTest {

    private double longitude = 7.5;
    private double latitude = 52.502;
    private double altitude = 60;

    // JTS: x,y,z
    // WGS84: lat (y), long(x), alt(z)

    @Test
    public void testCreatePoint3DWGS84() throws ParseException, NoSuchAuthorityCodeException, FactoryException {
        int epsgCode = 4979;
        Point jtsPoint = JTSHelper.createPoint(longitude, latitude, altitude, epsgCode);

        assertThat(jtsPoint, notNullValue());
        assertThat(jtsPoint.getX(), is(latitude));
        assertThat(jtsPoint.getY(), is(longitude));
        assertThat(jtsPoint.getCoordinates()[0].z, is(altitude));
        assertThat(jtsPoint.getSRID(), is(epsgCode));
    }

    @Test
    public void testCreatePoint2DWGS84() throws ParseException, NoSuchAuthorityCodeException, FactoryException {
        int epsgCode = 4326;
        Point jtsPoint = JTSHelper.createPoint(longitude, latitude, epsgCode);

        assertThat(jtsPoint, notNullValue());
        assertThat(jtsPoint.getX(), is(latitude));
        assertThat(jtsPoint.getY(), is(longitude));
        assertThat(jtsPoint.getCoordinates()[0].z, is(Double.NaN));
        assertThat(jtsPoint.getSRID(), is(epsgCode));
    }

}
