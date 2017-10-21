package entities;

import services.servicesImpl.POISeviceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HeatMap {

    private List<HeatPoint> map;
    private static double step = 0.0001;

    private HeatMap(List<HeatPoint> list){
        map = list;
    }

    public List<HeatPoint> getMap() {
        return map;
    }

    public void setMap(List<HeatPoint> map) {
        this.map = map;
    }

    public static HeatMap coreBuild(double X1, double X2, double Y1, double Y2){
        List<HeatPoint> list = new LinkedList<HeatPoint>();
        for(double x = X1; x <= X2; x+= step){
            for(double y = Y1; y <= Y2; y += step){
                list.add(new HeatPoint(x, y));
            }
        }
        return new HeatMap(list);
    }
}
