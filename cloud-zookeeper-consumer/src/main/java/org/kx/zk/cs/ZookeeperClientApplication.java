package org.kx.zk.cs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.*;

/**
 * create by sunkx on 2018/1/5
 */
//cloud中已经有几款配置组件，但感觉都不如disconf
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@EnableHystrixDashboard
@RestController
public class ZookeeperClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZookeeperClientApplication.class, args);
    }

    @Autowired
    ZkServiceProviderClient zkServiceProviderClient;
    @RequestMapping("/good")
    public String s1() {
        return zkServiceProviderClient.what();
    }
}
