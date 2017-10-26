package services;

import com.inctinctools.marathon2017.socmap.data.entities.POI;
import enums.POITypes;

import java.util.List;

public interface POISourceService {

    List<POI> buildQuery(double x1, double y1, double x2, double y2, POITypes type);

}
