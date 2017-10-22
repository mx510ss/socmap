import api.Api;
import configs.TagsConfig;
import entities.POI;
import enums.Types;
import services.POISourceService;
import services.SourcePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
// "(53.5,23.7,53.7,24)"
public class Starter {
    public static void main(String[] args) throws IOException {
        POISourceService poiSourceService = new SourcePOI();
        List<POI> poiList = poiSourceService.buildQuery( 53.5, 23.7, 53.7, 24);
        System.out.println(Types.EDUCATION);

    }
}
