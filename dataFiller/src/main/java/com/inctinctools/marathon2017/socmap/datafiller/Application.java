package com.inctinctools.marathon2017.socmap.datafiller;

import com.inctinctools.marathon2017.socmap.data.entities.factories.DefaultHeatMapFactory;
import com.inctinctools.marathon2017.socmap.data.repository.POIRepository;
import enums.POITypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import services.POIService;
import services.POISourceService;
import services.servicesImpl.POISeviceImpl;


@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.inctinctools.marathon2017.socmap")
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        POIService poiService = context.getBean(POIService.class);
        for (POITypes poi : POITypes.values())
            poiService.loadAndStore(poi);

    }

    @Bean
    public POIService getPOIService(POIRepository repository, POISourceService sourceService) throws Exception {
        return new POISeviceImpl(repository, sourceService, new DefaultHeatMapFactory());
    }

}
