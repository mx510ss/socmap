package com.inctinctools.marathon2017.socmap.datafiller.model;

import com.inctinctools.marathon2017.socmap.core.entities.POI;

import java.util.ArrayList;
import java.util.List;

public class ElementsList {
    private List<Element> list;

    public ElementsList(){
        list = new ArrayList<Element>();
    }

    public List<Element> getList() {
        return list;
    }

    public boolean concatList(List<Element> list){
        return this.list.addAll(list);
    }

    public List<POI> getListPOI(){
        List<POI> poiList = new ArrayList<POI>();
        for (Element el: list) {
            poiList.add(el.toModel());
        }
        return poiList;
    }
}
