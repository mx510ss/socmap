package com.inctinctools.marathon2017.socmap.restapi.entity;

import com.inctinctools.marathon2017.socmap.data.entities.HeatMap;
import com.inctinctools.marathon2017.socmap.data.entities.HeatPoint;

import java.util.ArrayList;
import java.util.List;

public class MapDTO {

    private int maxVal;

    private List<PointData> data;

    public MapDTO(HeatMap map) {
        this.maxVal = map.getMaxValue();
        List<PointData> list = new ArrayList<PointData>(map.getMap().size());
        for(HeatPoint i : map.getMap()){
            int objectCount = Integer.parseInt(i.getAttributes().get("count").toString());
            list.add(new PointData(i.getX(), i.getY(), objectCount));
        }
        this.data = list;
    }

    public int getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(int maxVal) {
        this.maxVal = maxVal;
    }

    public List<PointData> getData() {
        return data;
    }

    public void setData(List<PointData> data) {
        this.data = data;
    }
}
