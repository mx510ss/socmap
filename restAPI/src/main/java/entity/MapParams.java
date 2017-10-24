package entity;

import java.util.List;

public class MapParams {

    private int maxVal;

    private List<PointData> data;

    public MapParams(int maxVal, List<PointData> data) {
        this.maxVal = maxVal;
        this.data = data;
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
