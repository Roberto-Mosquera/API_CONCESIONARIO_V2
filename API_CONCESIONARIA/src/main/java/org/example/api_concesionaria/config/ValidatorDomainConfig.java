package org.example.api_concesionaria.config;

import org.example.api_concesionaria.domain.service.CarValidator;
import org.example.api_concesionaria.domain.service.CategoryCarValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidatorDomainConfig {

    @Bean
    public CarValidator carValidator() {
        return new CarValidator();
    }

    @Bean
    public CategoryCarValidator categoryCarValidator() {
        return new CategoryCarValidator();
    }

}
