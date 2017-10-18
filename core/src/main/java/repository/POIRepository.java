package repository;

import entities.POI;

import java.util.List;

public interface POIRepository{
    List<POI> getByBounds(double X1, double Y1, double X2, double Y2);
    void save(Iterable<POI> poi);
}
