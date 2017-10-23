package entities.factories;

import entities.HeatMap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultHeatMapFactory {

    private final double step;
    private final double pointRadius;

    public DefaultHeatMapFactory () throws IOException {
        Properties properties = new Properties();
        InputStream inputStream;
        inputStream = getClass().getClassLoader().getResourceAsStream("data.properties");
        properties.load(inputStream);
        this.step = Double.parseDouble(properties.getProperty("step"));
        this.pointRadius = Double.parseDouble(properties.getProperty("radius"));
    }

    public HeatMap getInstance(double x1, double x2, double y1, double y2){
        return new HeatMap(x1, x2, y1, y2, this.step, this.pointRadius);
    }

}
