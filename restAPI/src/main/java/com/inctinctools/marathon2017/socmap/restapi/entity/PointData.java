package com.inctinctools.marathon2017.socmap.restapi.entity;

public class PointData {

    private double x;
    private double y;
    private double value;

    public PointData(double x, double y, double value) {
        this.x = x;
        this.y = y;
        this.value = value;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
