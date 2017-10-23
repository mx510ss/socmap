package services;

import entities.POI;

import java.util.List;

public interface POISourceService {

    List<POI> buildQuery(double x1, double y1, double x2, double y2);

}
