package com.inctinctools.marathon2017.socmap.datafiller;

import com.inctinctools.marathon2017.socmap.core.entities.factories.DefaultHeatMapFactory;
import com.inctinctools.marathon2017.socmap.core.enums.POITypes;
import com.inctinctools.marathon2017.socmap.core.repository.POIRepository;
import com.inctinctools.marathon2017.socmap.core.services.POILoadService;
import com.inctinctools.marathon2017.socmap.core.services.POISourceService;
import com.inctinctools.marathon2017.socmap.core.services.servicesImpl.POILoadServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(scanBasePackages = "com.inctinctools.marathon2017.socmap")
@EntityScan(basePackages = "com.inctinctools.marathon2017.socmap.data.entities")
@EnableJpaRepositories(basePackages = "com.inctinctools.marathon2017.socmap.data.repository")
@Configuration
public class Application {

    public static void main(String[] args) throws Exception {
         ApplicationContext context = SpringApplication.run(Application.class, args);
         POILoadService poiService = context.getBean(POILoadService.class);

         for (POITypes poi : POITypes.values())
             poiService.loadAndStore(poi);

        System.out.printf("");
    }

    @Bean
    public POILoadService getPOIService(POIRepository repository, POISourceService sourceService) throws Exception {
        return new POILoadServiceImpl(repository, sourceService, new DefaultHeatMapFactory());
    }

}
