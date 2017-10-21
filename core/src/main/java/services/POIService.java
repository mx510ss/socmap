package services;

import entities.HeatMap;
import entities.HeatPoint;
import entities.POI;

public interface POIService {

    void loadAndStore();

    HeatMap build(double X1, double X2, double Y1, double Y2);
}
