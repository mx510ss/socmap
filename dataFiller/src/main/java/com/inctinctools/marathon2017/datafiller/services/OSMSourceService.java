package com.inctinctools.marathon2017.datafiller.services;

import com.inctinctools.marathon2017.datafiller.api.Api;
import com.inctinctools.marathon2017.datafiller.configs.TagsConfig;
import com.inctinctools.marathon2017.datafiller.httpClient.HttpClient;
import com.inctinctools.marathon2017.datafiller.model.ElementsList;
import com.inctinctools.marathon2017.datafiller.parser.ListElementsParser;
import entities.POI;
import enums.POITypes;
import services.POISourceService;

import java.io.*;
import java.util.List;


public class OSMSourceService implements POISourceService {

    private HttpClient httpClient;

    public OSMSourceService() {
        httpClient = new HttpClient();
    }

    public List<POI> buildQuery(double x1, double y1, double x2, double y2) {
        final ElementsList elementsList = new ElementsList();
       // try {
       //     for (String tag : tagsConfig.getTags())
       //     httpClient.request(Api.buildRequestNode(tag, x1, y1, x2, y2), new HttpClient.ResponseListner() {
       //         public void onResponse(InputStream stream) {
       //             elementsList.concatList(new ListElementsParser(stream).parse());
       //         }
       //     });
       // } catch (IOException e) {
       //     e.printStackTrace();
       // }
        return elementsList.getListPOI();
    }

    public List<POI> buildQuery(double x1, double y1, double x2, double y2, POITypes type) {
        return null;
    }
}
