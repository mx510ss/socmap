package entities;

import services.servicesImpl.POISeviceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HeatMap {

    private List<HeatPoint> map;


    private HeatMap(List<HeatPoint> list){
        map = list;
    }

    public List<HeatPoint> getMap() {
        return map;
    }

    public void setMap(List<HeatPoint> map) {
        this.map = map;
    }

    public static HeatMap coreBuild(){
        List<HeatPoint> list = new LinkedList<HeatPoint>();
        for(double x = POISeviceImpl.cityX1; x <= POISeviceImpl.cityX2; x+= 0.0001){
            for(double y = POISeviceImpl.cityY1; y <= POISeviceImpl.cityY2; y += 0.0001){
                list.add(new HeatPoint(x, y));
            }
        }
        return new HeatMap(list);
    }
}
