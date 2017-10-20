package services;

import entities.HeatMap;
import entities.HeatPoint;
import entities.POI;

public interface POIService {

    void loadAndStore();

    HeatMap build();
}
