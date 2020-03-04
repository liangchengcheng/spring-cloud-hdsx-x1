package com.hdsx.webservice.common.util;

import com.vividsolutions.jts.geom.Geometry;
import org.geotools.geojson.geom.GeometryJSON;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

public class GeojsonUtil {

    public static String geometryToJson(Geometry geometry){
        String json = null;
        try{
            StringWriter writer = new StringWriter();
            GeometryJSON g = new GeometryJSON();
            g.write(geometry,writer);
            json = writer.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return json;
    }

    public static Geometry jsonToGeometry(String geoJson){
        GeometryJSON gjson = new GeometryJSON();
        Reader reader = new StringReader(geoJson);
        try{
            Geometry geometry = gjson.read(reader);
            return geometry;
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
