package entities;

import java.util.LinkedList;
import java.util.List;

public class HeatMap {

    private List<HeatPoint> map;
    private double step;

    public HeatMap(double X1, double X2, double Y1, double Y2, double step, double pointRadius){
        this.map = new LinkedList<HeatPoint>();
        this.step = step;

        for(double x = X1; x <= X2; x+= step){
            for(double y = Y1; y <= Y2; y += step){
                map.add(new HeatPoint(x, y, pointRadius));
            }
        }
    }

    public List<HeatPoint> getMap() {
        return map;
    }

}
