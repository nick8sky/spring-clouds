package org.kx.zk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * create by sunkx on 2018/1/5
 */
@RestController
@RefreshScope
public class ServiceController {
    @Value("${spring.application.name}")
    private String instanceName;

    private final DiscoveryClient discoveryClient;

    //@Value("${name}")
    private String name;

    @Autowired
    private  Myconf myconf;
    @Autowired
    private  Myconf2 myconf2;

    @Autowired
    public ServiceController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }


    @GetMapping("/list")
    public List<String> serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances(instanceName);
        List<String> services = new ArrayList<>();
        if (list != null && list.size() > 0 ) {
            list.forEach(serviceInstance -> {
                services.add(serviceInstance.getUri().toString());
            });
        }
        return services;
    }

    @GetMapping("/hi")
    public String sayHi() {
        return "Hello,Zookeeper. this is " + instanceName +"1";
    }

    @GetMapping("/name")
    public String test() {
        return "Hello," + myconf.getName()+myconf2.getUrl();
    }

}
