package nick;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @这个Client由服务提供方提供，如euraka-server-provider里面的client包提供
 * @添加@FeignClient注解是为了调用方的在服务注册机器上找到服务提供方
 */
@FeignClient(value = "service-provider") //这里的name对应调用服务的spring.applicatoin.name
public interface ServiceFeignClient {
    @RequestMapping(value = "/hi")
    String hi(@RequestParam("id") String id);
}