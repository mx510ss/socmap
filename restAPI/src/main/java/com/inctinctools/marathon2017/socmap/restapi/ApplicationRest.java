package com.inctinctools.marathon2017.socmap.restapi;

import com.inctinctools.marathon2017.socmap.core.entities.factories.DefaultHeatMapFactory;
import com.inctinctools.marathon2017.socmap.core.repository.POIRepository;
import com.inctinctools.marathon2017.socmap.core.services.POIMapService;
import com.inctinctools.marathon2017.socmap.core.services.servicesImpl.POIMapServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.inctinctools.marathon2017.socmap.data.entities")
@EnableJpaRepositories(basePackages = "com.inctinctools.marathon2017.socmap.data.repository")
@SpringBootApplication(scanBasePackages = "com.inctinctools.marathon2017.socmap")
@Configuration
public class ApplicationRest {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApplicationRest.class, args);
    }

    @Bean
    public static POIMapService getPOIService(POIRepository repository) throws Exception {
        return new POIMapServiceImpl(repository, new DefaultHeatMapFactory());
    }
}


