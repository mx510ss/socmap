package com.inctinctools.marathon2017.socmap.data.repository;

import com.inctinctools.marathon2017.socmap.data.entities.POI;
import enums.POITypes;

import java.util.Collection;
import java.util.List;

public interface POIRepository{
    List<POI> getByBounds(double x1, double y1, double x2, double y2, POITypes type);
    void save(Collection<POI> poi);
}
