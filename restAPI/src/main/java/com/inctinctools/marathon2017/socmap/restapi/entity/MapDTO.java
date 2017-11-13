package com.inctinctools.marathon2017.socmap.restapi.entity;


import com.inctinctools.marathon2017.socmap.core.entities.HeatMap;
import com.inctinctools.marathon2017.socmap.core.entities.HeatPoint;

import java.util.ArrayList;
import java.util.List;

public class MapDTO {

    private int max;

    private List<PointData> data;

    public MapDTO(HeatMap map) {
        this.max = map.getMaxValue();
        List<PointData> list = new ArrayList<PointData>(map.getMap().size());
        for(HeatPoint i : map.getMap()){
            int objectCount = Integer.parseInt(i.getAttributes().get("count").toString());
            list.add(new PointData(i.getX(), i.getY(), objectCount));
        }
        this.data = list;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<PointData> getData() {
        return data;
    }

    public void setData(List<PointData> data) {
        this.data = data;
    }
}
