package org.kx.consul.cs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {
    @Value("${server.port}")
    private String port;


    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    @RequestMapping("/hi/{id}")
    public String home1(@PathVariable("id") Integer customerId) {
        return "Hello world "+port+"  " +customerId;
    }



    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}

