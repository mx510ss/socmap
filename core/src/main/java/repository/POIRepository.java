package repository;

import entities.POI;
import enums.POITypes;

import java.util.List;

public interface POIRepository{
    List<POI> getByBounds(double x1, double y1, double x2, double y2, POITypes type);
    void save(Iterable<POI> poi);
}
