package com.example.bukmekerskaya_kontora.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.example.bukmekerskaya_kontora")
@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper(){return new ModelMapper();}

}
