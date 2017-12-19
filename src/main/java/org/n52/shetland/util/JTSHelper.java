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

import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.cs.CoordinateSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.CoordinateFilter;
import com.vividsolutions.jts.geom.Envelope;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;

/**
 * Utility class for the Java Topology Suite.
 *
 * @since 1.0.0
 *
 */
public class JTSHelper {

    public static final CoordinateFilter COORDINATE_SWITCHING_FILTER = coord -> {
        double tmp = coord.x;
        coord.x = coord.y;
        coord.y = tmp;
    };

    public static final String WKT_POLYGON = "Polygon";
    public static final String WKT_POINT = "Point";

    /**
     * WKT format String template for 3D points: <code>Point(%s %s %s)</code>.
     */
    public static final String FORMAT_POINT_3D = WKT_POINT + "(%s %s %s)";

    /**
     * WKT format String template for 2D points: <code>Point(%s %s)</code>.
     */
    public static final String FORMAT_POINT_2D = WKT_POINT + "(%s %s)";

    private static final Logger LOGGER = LoggerFactory.getLogger(JTSHelper.class);

    protected JTSHelper() {
    }

    /**
     * Creates a JTS Geometry from an WKT representation. Switches the
     * coordinate order if needed.
     *
     * @param wkt
     *            WKT representation of the geometry
     * @param srid
     *            the SRID of the newly created geometry
     *
     * @return JTS Geometry object
     *
     * @throws ParseException
     *             If an error occurs
     */
    public static Geometry createGeometryFromWKT(String wkt, int srid)
            throws ParseException {
        WKTReader wktReader = getWKTReaderForSRID(srid);
        LOGGER.debug("FOI Geometry: {}", wkt);
        return wktReader.read(wkt);
    }

    public static WKTReader getWKTReaderForSRID(int srid) {
        if (srid <= 0) {
            return new WKTReader(new GeometryFactory());
        }
        return new WKTReader(getGeometryFactoryForSRID(srid));
    }

    /**
     * Get the coordinates of a Geometry as String.
     *
     * @param geom
     *            Geometry to get coordinates
     * @return Coordinates as String
     */
    public static String getCoordinatesString(Geometry geom) {
        StringBuilder builder = new StringBuilder();
        Coordinate[] sourceCoords = geom.getCoordinates();
        if (sourceCoords.length > 0) {
            getCoordinateString(builder, sourceCoords[0]);
            for (int i = 1; i < sourceCoords.length; ++i) {
                getCoordinateString(builder.append(' '), sourceCoords[i]);
            }
        }
        return builder.toString();
    }

    protected static StringBuilder getCoordinateString(StringBuilder builder, Coordinate coordinate) {
        builder.append(coordinate.x);
        builder.append(' ');
        builder.append(coordinate.y);
        if (!Double.isNaN(coordinate.z)) {
            builder.append(' ');
            builder.append(coordinate.z);
        }
        return builder;
    }

    /**
     * Creates a WKT Polygon representation from lower and upper corner values.
     *
     * @param lowerCorner
     *            Lower corner coordinates
     * @param upperCorner
     *            Upper corner coordinates
     * @return WKT Polygon
     */
    public static String createWKTPolygonFromEnvelope(String lowerCorner, String upperCorner) {
        final String[] splittedLowerCorner = lowerCorner.split(" ");
        final String[] splittedUpperCorner = upperCorner.split(" ");
        String minx = splittedLowerCorner[0];
        String miny = splittedLowerCorner[1];
        String maxx = splittedUpperCorner[0];
        String maxy = splittedUpperCorner[1];

        return createWKTPolygonFromEnvelope(minx, miny, maxx, maxy);
    }

    private static String createWKTPolygonFromEnvelope(String minx, String miny, String maxx, String maxy) {
        StringBuilder sb = new StringBuilder();
        sb.append(WKT_POLYGON).append(" ((");
        sb.append(minx).append(' ').append(miny).append(',');
        sb.append(minx).append(' ').append(maxy).append(',');
        sb.append(maxx).append(' ').append(maxy).append(',');
        sb.append(maxx).append(' ').append(miny).append(',');
        sb.append(minx).append(' ').append(miny).append("))");
        return sb.toString();
    }

    public static Envelope createEnvelopeFromLowerUpperCorner(String lowerCorner, String upperCorner) {
        final String[] splittedLowerCorner = lowerCorner.split(" ");
        final String[] splittedUpperCorner = upperCorner.split(" ");
        double minx = Double.parseDouble(splittedLowerCorner[0]);
        double miny = Double.parseDouble(splittedLowerCorner[1]);
        double maxx = Double.parseDouble(splittedUpperCorner[0]);
        double maxy = Double.parseDouble(splittedUpperCorner[1]);
        return new Envelope(minx, maxx, miny, maxy);
    }

    public static Geometry createPolygonFromEnvelope(double[] envelope, int srid) {
        if (envelope.length != 4) {
            throw new IllegalArgumentException();
        }
        return createPolygonFromEnvelope(envelope[0], envelope[1], envelope[2], envelope[3], srid);
    }

    public static Geometry createPolygonFromEnvelope(double minx, double miny, double maxx, double maxy, int srid) {
        GeometryFactory fac = getGeometryFactoryForSRID(srid);
        return fac.createPolygon(new Coordinate[] {
            new Coordinate(minx, miny),
            new Coordinate(minx, maxy),
            new Coordinate(maxx, maxy),
            new Coordinate(maxx, miny),
            new Coordinate(minx, miny) });
    }

    /**
     * Switches the coordinates of a JTS Geometry.
     *
     * @param <G>
     *            the geometry type
     * @param geometry
     *            Geometry to switch coordinates.
     * @return Geometry with switched coordinates
     */
    public static <G extends Geometry> G switchCoordinateAxisOrder(G geometry) {
        if (geometry == null) {
            return null;
        }
        @SuppressWarnings("unchecked")
        G geom = (G) geometry.clone();
        geom.apply(COORDINATE_SWITCHING_FILTER);
        geom.geometryChanged();
        return geom;
    }

    public static GeometryFactory getGeometryFactory(Geometry geometry) {
        if (geometry.getFactory().getSRID() > 0 || geometry.getSRID() == 0) {
            return geometry.getFactory();
        } else {
            return getGeometryFactoryForSRID(geometry.getSRID());
        }
    }

    public static GeometryFactory getGeometryFactoryForSRID(int srid) {
        return new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), srid);
    }

    /**
     * Creates a WKT Point string form coordinate string.
     *
     * @param coordinates
     *            Coordinate string
     * @return WKT Point string
     */
    public static String createWKTPointFromCoordinateString(String coordinates) {
        return WKT_POINT + "(" + coordinates + ")";
    }

    public static boolean isNotEmpty(Geometry geometry) {
        return geometry != null && !geometry.isEmpty();
    }

    /**
     * Creates a JTS Point from given coordinate values in the order defined by the EPSG code. Hence,
     * ensure the EPSG code is correct and latitude is latitude and longitude is longitude.
     * @param longitude longitude to set
     * @param latitude latitude to set
     * @param altitude altitude to set
     * @param epsgCode EPSG code of the CRS to use
     * @return a JTS Point with the coordinates in the order extracted from EPSG database.
     * @throws ParseException if the WKT could not be created.
     * @throws FactoryException if the creation of an internal object fails
     * @throws NoSuchAuthorityCodeException if the epsgCode could not be matched to any entry in the EPSG database
     *
     * @see #createGeometryFromWKT(String, int)
     * @see #FORMAT_POINT_3D
     */
    public static Point createPoint(double longitude, double latitude, double altitude, int epsgCode)
            throws ParseException, NoSuchAuthorityCodeException, FactoryException {
        CoordinateSystem cs = CRS.decode("EPSG:" + epsgCode).getCoordinateSystem();
        double[] coordinateValues = new double[cs.getDimension()];
        for (int i = 0; i < cs.getDimension(); i++) {
            switch (cs.getAxis(i).getAbbreviation()) {
                case "Lat":
                    coordinateValues[i] = latitude;
                    break;
                case "Long":
                    coordinateValues[i] = longitude;
                    break;
                case "h":
                    coordinateValues[i] = altitude;
                    break;
                default:
                    throw new IllegalArgumentException("Axis abbreviation '" +
                            cs.getAxis(i).getAbbreviation() +
                            "' not supported.");
            }

        }
        String wkt = "";
        if (Double.isNaN(altitude)) {
            wkt = String.format(FORMAT_POINT_2D, coordinateValues[0], coordinateValues[1]);
        } else if (cs.getDimension() > 2) {
            wkt = String.format(FORMAT_POINT_3D, coordinateValues[0], coordinateValues[1] , coordinateValues[2]);
        }
        return (Point) JTSHelper.createGeometryFromWKT(wkt, epsgCode);
    }

    /**
     * Creates a JTS Point from given coordinate values in the order defined by the EPSG code. Hence,
     * ensure the EPSG code is correct and latitude is latitude and longitude is longitude.
     * @param longitude longitude to set
     * @param latitude latitude to set
     * @param epsgCode EPSG code of the CRS to use
     * @return a JTS Point with the coordinates in the order extracted from EPSG database.
     * @throws ParseException if the WKT could not be created.
     * @throws FactoryException if the creation of an internal object fails
     * @throws NoSuchAuthorityCodeException if the epsgCode could not be matched to any entry in the EPSG database
     *
     * @see #createGeometryFromWKT(String, int)
     * @see #FORMAT_POINT_2D
     */
    public static Point createPoint(double longitude, double latitude, int epsgCode)
            throws ParseException, NoSuchAuthorityCodeException, FactoryException {
        return createPoint(longitude, latitude, Double.NaN, epsgCode);
    }

}
