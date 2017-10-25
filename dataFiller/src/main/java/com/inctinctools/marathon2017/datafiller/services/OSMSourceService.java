package com.inctinctools.marathon2017.datafiller.services;

import com.inctinctools.marathon2017.datafiller.api.Api;
import com.inctinctools.marathon2017.datafiller.configs.TagsConfig;
import com.inctinctools.marathon2017.datafiller.httpClient.HttpClient;
import com.inctinctools.marathon2017.datafiller.model.ElementsList;
import com.inctinctools.marathon2017.datafiller.parser.ListElementsParser;
import com.inctinctools.marathon2017.datafiller.parser.TagsConfigParser;
import entities.POI;
import services.POISourceService;

import java.io.*;
import java.util.List;


public class OSMSourceService implements POISourceService {

    private HttpClient httpClient;
    private TagsConfig tagsConfig;

    public OSMSourceService() {
        httpClient = new HttpClient();
        buildTagsConfig();
    }

    private void buildTagsConfig(){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File(OSMSourceService.class.getResource(TagsConfig.URL_TAGS_JSON).getPath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            tagsConfig = new TagsConfigParser(fileInputStream).parse();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<POI> buildQuery(double x1, double y1, double x2, double y2) {
        final ElementsList elementsList = new ElementsList();
        try {
            for (String tag : tagsConfig.getTags())
            httpClient.request(Api.buildRequestNode(tag, x1, y1, x2, y2), new HttpClient.ResponseListner() {
                public void onResponse(InputStream stream) {
                    elementsList.concatList(new ListElementsParser(stream).parse());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return elementsList.getListPOI();
    }
}
