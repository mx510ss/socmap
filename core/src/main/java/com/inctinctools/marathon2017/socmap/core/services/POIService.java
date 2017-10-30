package com.inctinctools.marathon2017.socmap.core.services;

import com.inctinctools.marathon2017.socmap.core.entities.HeatMap;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;

public interface POIService {

    void loadAndStore(POITypes type);

    HeatMap build(double x1, double x2, double y1, double y2, POITypes type);
}
