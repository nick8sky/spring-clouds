package org.kx.consul.cs;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * create by sunkx on 2018/1/7
 */
@FeignClient(value = "consul-service-provider")
public interface ConsulProvierClient {
    @GetMapping (value =   "hi/{id}" )
    public String getCustomerInfoById(@PathVariable("id") Integer customerId);

}
