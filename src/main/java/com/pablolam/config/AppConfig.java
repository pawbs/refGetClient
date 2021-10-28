package com.pablolam.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablolam.service.ENACramClient;
import com.pablolam.service.RefGetService;
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
    public RefGetService refGetService() {
        return new RefGetService();
    }
    @Bean
    public ENACramClient enaCramClient() {
        return new ENACramClient();
    }
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
