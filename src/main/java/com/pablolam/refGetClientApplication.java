package com.pablolam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablolam.service.RefGetClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.io.IOException;

@SpringBootApplication
public class RefGetClientApplication
        implements CommandLineRunner {

    @Autowired
    private RefGetClient refGetClient;

    @Autowired
    private ObjectMapper objectMapper;

    public static void main(String[] args) {
        new SpringApplicationBuilder(RefGetClientApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(String... args) {
        try {
            System.out.println(objectMapper.writeValueAsString(refGetClient.getMetadata("3050107579885e1608e6fe50fae3f8d0")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}