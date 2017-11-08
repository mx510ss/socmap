package com.inctinctools.marathon2017.socmap.core.services.servicesImpl;

import com.inctinctools.marathon2017.socmap.core.entities.POI;
import com.inctinctools.marathon2017.socmap.core.entities.factories.DefaultHeatMapFactory;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import com.inctinctools.marathon2017.socmap.core.repository.POIRepository;
import com.inctinctools.marathon2017.socmap.core.services.POILoadService;
import com.inctinctools.marathon2017.socmap.core.services.POISourceService;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class POILoadServiceImpl implements POILoadService {

    public double cityX1, cityX2, cityY1, cityY2;
    private final POIRepository repository;
    private final POISourceService sourceService;
    private final DefaultHeatMapFactory factory;

    public POILoadServiceImpl(POIRepository repository, POISourceService sourceService, DefaultHeatMapFactory factory) throws Exception {
        this.repository = repository;
        this.sourceService = sourceService;
        this.factory = factory;
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream(new File("socmap.properties"));
        properties.load(inputStream);
        this.cityX1 = Double.parseDouble(properties.getProperty("cityX1"));
        this.cityX2 = Double.parseDouble(properties.getProperty("cityX2"));
        this.cityY1 = Double.parseDouble(properties.getProperty("cityY1"));
        this.cityY2 = Double.parseDouble(properties.getProperty("cityY2"));
    }

    public void loadAndStore(POITypes type) {
        List<POI> list = sourceService.getPOI(cityX1, cityY1, cityX2, cityY2, type);
        repository.save(list);
    }
}
