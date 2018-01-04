package org.kx.nick;

import org.kx.nick.conf.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableAutoConfiguration
@EnableConfigurationProperties({UserInfo.class})
public class Application {



    @RequestMapping("/")
    public String home() {
        return "Hello world";
    }

    @RequestMapping("/refresh")
    public String hi() {

        System.out.println("-refresh--->");
        return "Hello ";
    }



    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}

