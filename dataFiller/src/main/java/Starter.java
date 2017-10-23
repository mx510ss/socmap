import entities.POI;
import enums.Types;
import mapping.Converter;
import services.POISourceService;
import services.SourcePOI;

import java.io.IOException;
import java.util.List;



public class Starter {
    public static void main(String[] args) throws IOException {
        //(53.6, 23.7, 53.755, 24);
        POISourceService poiSourceService = new SourcePOI();
        List<POI> poiList = poiSourceService.buildQuery( 53.6, 23.7, 53.755, 24);
        System.out.println(Types.EDUCATION);
    }
}
