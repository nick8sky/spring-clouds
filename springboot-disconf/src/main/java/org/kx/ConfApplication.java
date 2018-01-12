package org.kx;

import org.kx.conf.SystemConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by sunkx on 2018/1/11
 */

@SpringBootApplication
@ComponentScan(basePackages = {"org.kx.conf"})
@ImportResource({"classpath:spring-disconf.xml"})
@RestController
public class ConfApplication {

    @Autowired
    SystemConf systemConf;
    public static void main(String[] args) {
        SpringApplication.run(ConfApplication.class, args);
    }

    @RequestMapping("/")
    public String home() {
        return systemConf.getName();
    }
}