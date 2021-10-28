package com.pablolam;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class refGetClientApplication
        implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplicationBuilder(refGetClientApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

    @Override
    public void run(String... args) {
    }
}