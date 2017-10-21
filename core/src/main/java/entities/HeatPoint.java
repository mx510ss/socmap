package entities;

import java.util.HashMap;
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
        attributes = new HashMap<String, Object>();
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

    public void addAttributes(String key, Object value) {
       attributes.put(key, value);
    }

    public double[] getSquareByRadius() {
        double[] ans = new double[4];
        ans[0] = x - radius;
        ans[2] = x + radius;
        ans[1] = y - radius;
        ans[3] = y + radius;
        return ans;
    }
}
