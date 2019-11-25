package com.exercise.cantinajava.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class appConfig {
    @Bean
    public ObjectMapper getMapper() {
        return new ObjectMapper();
    }
}
