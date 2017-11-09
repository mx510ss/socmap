package com.inctinctools.marathon2017.socmap.core.services.servicesImpl;

import com.inctinctools.marathon2017.socmap.core.entities.HeatMap;
import com.inctinctools.marathon2017.socmap.core.entities.HeatPoint;
import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.entities.factories.DefaultHeatMapFactory;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import com.inctinctools.marathon2017.socmap.core.repository.POIRepository;
import com.inctinctools.marathon2017.socmap.core.services.POISourceService;
import com.inctinctools.marathon2017.socmap.core.services.POIMapService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class POIMapServiceImpl implements POIMapService {

    private final POIRepository repository;
    private final DefaultHeatMapFactory factory;

    public POIMapServiceImpl(POIRepository repository, DefaultHeatMapFactory factory ){
        this.repository = repository;
        this.factory = factory;
    }

    public HeatMap build(double x1, double x2, double y1, double y2, POITypes type) {
        HeatMap map = this.factory.getInstance(x1, x2, y1, y2);
        for (HeatPoint point : map.getMap()){
            double[] crd = point.getSquareByRadius();
            List<POI> list = repository.getByBounds(crd[0], crd[1], crd[2], crd[3], type);
            point.addAttributes("count", list.size());
        }
        return map;
    }
}
