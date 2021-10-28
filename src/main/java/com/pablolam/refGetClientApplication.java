package com.pablolam;

import com.pablolam.service.RefGetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class RefGetClientApplication
        implements CommandLineRunner {

    @Autowired
    private RefGetService refGetService;

    public static void main(String[] args) {
        new SpringApplicationBuilder(RefGetClientApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .logStartupInfo(false)
                .run(args);
    }

    @Override
    public void run(String... args) {
        refGetService.getMetaData(args);
    }
}