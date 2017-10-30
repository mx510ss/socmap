package com.inctinctools.marathon2017.socmap.datafiller;

import com.inctinctools.marathon2017.socmap.core.entities.factories.DefaultHeatMapFactory;
import com.inctinctools.marathon2017.socmap.core.repository.POIRepository;
import com.inctinctools.marathon2017.socmap.core.services.POIService;
import com.inctinctools.marathon2017.socmap.core.services.POISourceService;
import com.inctinctools.marathon2017.socmap.core.services.servicesImpl.POISeviceImpl;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;


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
