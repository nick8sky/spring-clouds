package org.kx.consul.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class Application {

    @Autowired
    ConsulProvierClient consulProvierClient;

    @RequestMapping("/")
    public String home() {
        return consulProvierClient.getCustomerInfoById(21);
    }




    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}

