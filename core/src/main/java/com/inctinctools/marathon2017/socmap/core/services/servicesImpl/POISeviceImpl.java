package com.inctinctools.marathon2017.socmap.core.services.servicesImpl;

import com.inctinctools.marathon2017.socmap.core.entities.HeatMap;
import com.inctinctools.marathon2017.socmap.core.entities.HeatPoint;
import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.entities.factories.DefaultHeatMapFactory;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import com.inctinctools.marathon2017.socmap.core.repository.POIRepository;
import com.inctinctools.marathon2017.socmap.core.services.POISourceService;
import com.inctinctools.marathon2017.socmap.core.services.POIService;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class POISeviceImpl implements POIService{

    public double cityX1, cityX2, cityY1, cityY2;
    private final POIRepository repository;
    private final POISourceService sourceService;
    private final DefaultHeatMapFactory factory;

    public POISeviceImpl(POIRepository repository, POISourceService sourceService, DefaultHeatMapFactory factory) throws Exception {
        this.repository = repository;
        this.sourceService = sourceService;
        this.factory = factory;
        Properties properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("data.properties");;
        properties.load(inputStream);
        this.cityX1 = Double.parseDouble(properties.getProperty("cityX1"));
        this.cityX2 = Double.parseDouble(properties.getProperty("cityX2"));
        this.cityY1 = Double.parseDouble(properties.getProperty("cityY1"));
        this.cityY2 = Double.parseDouble(properties.getProperty("cityY2"));
    }

    public void loadAndStore(POITypes type) {
       List<POI> list = sourceService.getPOI(cityX1, cityY1, cityX2, cityY2, type);
       repository.save(list);
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
