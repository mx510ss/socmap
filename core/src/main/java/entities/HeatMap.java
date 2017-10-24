package entities;

import java.util.LinkedList;
import java.util.List;

public class HeatMap {

    private List<HeatPoint> map;
    private double step;

    public HeatMap(double x1, double x2, double y1, double y2, double step, double pointRadius){
        this.map = new LinkedList<HeatPoint>();
        this.step = step;

        for(double x = x1; x <= x2; x+= step){
            for(double y = y1; y <= y2; y += step){
                map.add(new HeatPoint(x, y, pointRadius));
            }
        }
    }

    public List<HeatPoint> getMap() {
        return map;
    }

}
