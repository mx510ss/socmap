package com.inctinctools.marathon2017.socmap.core.services;

import com.inctinctools.marathon2017.socmap.core.entities.HeatMap;
import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;

import java.util.List;

public interface POIMapService {
    HeatMap build(double x1, double x2, double y1, double y2, POITypes type);
    List<POI> getListOfPOI(double x1, double x2, double y1, double y2, POITypes type);
}
