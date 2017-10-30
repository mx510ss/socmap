package com.inctinctools.marathon2017.socmap.datafiller.api;

public class Api {
    //TODO adjust
    public static final String OVERPASS_API = "http://www.overpass-api.de/api/interpreter";
    private static final String TYPE_JSON = "[out:json];";
    private static final String OUT_CENTER = "out center;";
    private static final String OUT_BODY = "out body;";
    private static final String NODES_FORMAT = "node[\"name\"][~\".\"~\"%s\"]%s;";
    private static final String WAY_FORMAT = "way[\"name\"][~\".\"~\"%s\"]%s;";

    private static String getNodeQuery(String tag, String coordinates)  {
        return String.format(NODES_FORMAT, tag, coordinates);
    }

    private static String getWayQuery(String tag, String coordinates)  {
        return String.format(WAY_FORMAT, tag, coordinates);
    }

    private static String coordinate(double x1, double y1, double x2, double y2){
        return String.format("(%s,%s,%s,%s)", x1,y1,x2,y2);
    }
    public static String buildRequestNode(String tag, double x1, double y1, double x2, double y2){
        return TYPE_JSON  +getNodeQuery(tag, coordinate(x1,y1,x2,y2))+ OUT_BODY + getWayQuery(tag, coordinate(x1,y1,x2,y2)) + OUT_CENTER;
    }
}
