package model;

import entities.POI;

import java.util.LinkedList;
import java.util.List;

public class ElementsList {
    private List<Element> list;

    public ElementsList(){
        list = new LinkedList<Element>();
    }

    public List<Element> getList() {
        return list;
    }

    public boolean concatList(List<Element> list){
        return this.list.addAll(list);
    }

    public List<POI> getListPOI(){
        List<POI> poiList = new LinkedList<POI>();
        for (Element el: list) {
            poiList.add(el.toModel());
        }
        return poiList;
    }
}
