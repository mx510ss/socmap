package com.inctinctools.marathon2017.socmap.core.services;

import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;

import java.util.List;

public interface POISourceService {

    List<POI> getPOI(double x1, double y1, double x2, double y2, POITypes type);

}
