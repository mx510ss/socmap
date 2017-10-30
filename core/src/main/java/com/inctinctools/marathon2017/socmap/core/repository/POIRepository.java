package com.inctinctools.marathon2017.socmap.core.repository;

import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;

import java.util.Collection;
import java.util.List;

public interface POIRepository{
    List<POI> getByBounds(double x1, double y1, double x2, double y2, POITypes type);
    void save(Collection<POI> poi);
}
