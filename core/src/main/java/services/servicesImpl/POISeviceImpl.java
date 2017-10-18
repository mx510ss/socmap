package services.servicesImpl;

import entities.HeatPoint;
import entities.POI;
import repository.POIRepository;
import services.POIService;
import services.POISourceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class POISeviceImpl implements POIService{

    public static final double cityX1 = 23.7;
    public static final double cityX2 = 24.0;
    public static final double cityY1 = 53.5;
    public static final double cityY2 = 53.7;

    private final POIRepository repository;

    private final POISourceService sourceService;

    public POISeviceImpl(POIRepository repository, POISourceService sourceService) {
        this.repository = repository;
        this.sourceService = sourceService;
    }

    public void loadAndStore() {
       List<POI> list = sourceService.buildQuery(cityX1, cityY1, cityX2, cityY2);
       repository.save(list);

    }

    public void buildPoint(HeatPoint point) {
        double[] crd = point.getSquareByRadius();
        List<POI>list = repository.getByBounds(crd[0], crd[1], crd[2], crd[3]);
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("count", list.size());
       //TODO - set attributes for HeatPoint to build heatmap
        point.setAttributes(attributes);
    }
}
