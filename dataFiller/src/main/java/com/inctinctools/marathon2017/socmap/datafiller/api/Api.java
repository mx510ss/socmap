package com.inctinctools.marathon2017.socmap.datafiller.api;

public class Api {
    //private static final String GRODNO_COORDINATES = "(53.5,23.7,53.7,24)";
    private static final String OVERPASS_API = "http://www.overpass-api.de/api/interpreter?data=";
    private static final String TYPE_JSON = "[out:json];";
    private static final String OUT = "out%20body;";
    private static final String NODES_FORMAT = "node[~\".\"~\"%s\"]%s;";

    private static String getNodeQuery(String tag, String coordinates)  {
        return String.format(NODES_FORMAT, tag, coordinates);
    }
    private static String coordinate(double x1, double y1, double x2, double y2){
        return String.format("(%s,%s,%s,%s)", x1,y1,x2,y2);
    }
    public static String buildRequestNode(String tag, double x1, double y1, double x2, double y2){
        return OVERPASS_API + TYPE_JSON  +getNodeQuery(tag, coordinate(x1,y1,x2,y2))+ OUT;
    }
}
