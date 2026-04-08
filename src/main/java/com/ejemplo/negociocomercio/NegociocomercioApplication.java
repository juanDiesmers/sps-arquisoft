package com.ejemplo.negociocomercio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class NegociocomercioApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NegociocomercioApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(NegociocomercioApplication.class, args);
    }
}