package services.servicesImpl;

import entities.HeatMap;
import entities.HeatPoint;
import entities.POI;
import repository.POIRepository;
import services.POIService;
import services.POISourceService;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class POISeviceImpl implements POIService{

    public static double cityX1, cityX2, cityY1, cityY2;
    private final POIRepository repository;

    private final POISourceService sourceService;

    public POISeviceImpl(POIRepository repository, POISourceService sourceService) {
        this.repository = repository;
        this.sourceService = sourceService;
        Properties properties = new Properties();
        InputStream inputStream = null;
        inputStream = getClass().getClassLoader().getResourceAsStream("data.properties");
        try {
            properties.load(inputStream);
            cityX1 = Double.parseDouble(properties.getProperty("cityX1"));
            cityX2 = Double.parseDouble(properties.getProperty("cityX2"));
            cityY1 = Double.parseDouble(properties.getProperty("cityY1"));
            cityY2 = Double.parseDouble(properties.getProperty("cityY2"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAndStore() {
       List<POI> list = sourceService.buildQuery(cityX1, cityY1, cityX2, cityY2);
       repository.save(list);

    }

    public HeatMap build(double X1, double X2, double Y1, double Y2) {
        HeatMap map = HeatMap.coreBuild(X1, X2, Y1, Y2);
        for (HeatPoint point : map.getMap()){
            double[] crd = point.getSquareByRadius();
            List<POI> list = repository.getByBounds(crd[0], crd[1], crd[2], crd[3]);
            point.addAttributes("count", list.size());
        }
        return map;
    }
}
