package org.kx.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * create by sunkx on 2018/1/5
 */
//cloud中已经有几款配置组件，但感觉都不如disconf
@SpringBootApplication
@EnableDiscoveryClient
//@EnableConfigServer
@EnableAutoConfiguration
@EnableConfigurationProperties({Myconf.class,Myconf2.class})
//支持多个配置类 @EnableConfigurationProperties({xxx.class,abc.class})
public class ZookeeperApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperApplication.class, args);
    }
}
