package entities;

import java.util.Map;

public class HeatPoint {

    private static double radius = 0.0013;

    private double x;

    private double y;

    private Map<String, Object> attributes;

    public HeatPoint(){}

    public HeatPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public double[] getSquareByRadius(){
        double x1, x2, y1, y2;
        x1 = x - radius;
        x2 =x + radius;
        y1 = y - radius;
        y2 = y + radius;
        double[] ans = {x1, y1, x2, y2};
        return  ans;
    }
}
