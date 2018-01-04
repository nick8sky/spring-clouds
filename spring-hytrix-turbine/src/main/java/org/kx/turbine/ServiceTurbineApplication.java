package org.kx.turbine;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * create by sunkx on 2018/1/4
 */
@SpringBootApplication
@EnableTurbine
public class ServiceTurbineApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder(ServiceTurbineApplication.class).web(true).run(args);
    }
}
