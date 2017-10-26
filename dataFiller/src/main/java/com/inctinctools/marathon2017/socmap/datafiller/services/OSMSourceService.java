package com.inctinctools.marathon2017.socmap.datafiller.services;

import com.inctinctools.marathon2017.socmap.datafiller.api.Api;
import com.inctinctools.marathon2017.socmap.datafiller.httpClient.RestClient;
import com.inctinctools.marathon2017.socmap.datafiller.mapping.Converter;
import com.inctinctools.marathon2017.socmap.datafiller.model.Element;
import com.inctinctools.marathon2017.socmap.datafiller.model.ElementsList;
import com.inctinctools.marathon2017.socmap.data.entities.POI;
import com.inctinctools.marathon2017.socmap.datafiller.model.ResponseServer;
import enums.POITypes;
import org.springframework.stereotype.Service;
import services.POISourceService;

import java.io.UnsupportedEncodingException;
import java.util.List;


@Service
public class OSMSourceService implements POISourceService {

    private RestClient restClient;

    public OSMSourceService() {
        restClient = new RestClient();
    }

    public List<POI> buildQuery(double x1, double y1, double x2, double y2, POITypes type) {
        final ElementsList elementsList = new ElementsList();
        for (String tag : Converter.getListTags(type))
            try {
                List<Element> elements = restClient.get(Api.buildRequestNode(tag, x1, y1, x2, y2)).getElements();
                for (Element el : elements
                        ) {
                    el.setPoiTypes(type);
                }
                elementsList.concatList(elements);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        return elementsList.getListPOI();
    }


}
