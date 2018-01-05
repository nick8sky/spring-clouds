package org.kx.zk.cs;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * create by sunkx on 2018/1/5
 */
@Component
@FeignClient(value="service-app",fallback=ZkServiceHystrix.class)
public interface ZkServiceProviderClient {

    //等同于service-app/hi
    @RequestMapping(method = RequestMethod.GET, value = "/hi")
    public String what();

}
