package com.pablolam.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablolam.service.ENACramClient;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
    @Bean
    public ENACramClient refGetClient() {
        return new ENACramClient();
    }
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
