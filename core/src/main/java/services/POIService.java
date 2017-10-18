package services;

import entities.HeatPoint;
import entities.POI;

public interface POIService {

    void loadAndStore();

    void buildPoint(HeatPoint point);
}
