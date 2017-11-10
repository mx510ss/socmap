package com.inctinctools.marathon2017.socmap.datafiller.services;

import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.datafiller.api.Api;
import com.inctinctools.marathon2017.socmap.datafiller.mapping.TagResolver;
import com.inctinctools.marathon2017.socmap.datafiller.model.Element;
import com.inctinctools.marathon2017.socmap.datafiller.model.ElementsList;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import com.inctinctools.marathon2017.socmap.datafiller.model.OSMResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.inctinctools.marathon2017.socmap.core.services.POISourceService;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.util.List;


@Component
public class OSMSourceService implements POISourceService {

    private RestTemplate rest;

    public OSMSourceService() {
        this.rest = new RestTemplate();
    }

    public List<POI> getPOI(double x1, double y1, double x2, double y2, POITypes type) {
        final ElementsList elementsList = new ElementsList();
        for (String tag : TagResolver.getListTags(type))
            try {
                List<Element> elements = get(Api.buildRequestNode(tag, x1, y1, x2, y2)).getElements();
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

    private OSMResponse get(String query) throws UnsupportedEncodingException {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(Api.OVERPASS_API)
                .queryParam("data", query);
        HttpEntity<OSMResponse> response = rest.exchange(
                builder.build().encode("UTF-8").toUri(),
                HttpMethod.GET,
                null,
                OSMResponse.class);
        return response.getBody();
    }

}
