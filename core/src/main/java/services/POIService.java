package services;

import entities.HeatMap;
import enums.POITypes;

public interface POIService {

    void loadAndStore(POITypes type);

    HeatMap build(double x1, double x2, double y1, double y2, POITypes type);
}
