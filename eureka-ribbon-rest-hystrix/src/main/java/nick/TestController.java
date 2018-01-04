package nick;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiFallback")
    public String hi(@RequestParam String id){
        return restTemplate.getForObject("http://service-provider/hi?id="+id, String.class);
        //这里写 服务提供的服务名称，可能是多个
    }

    public String hiFallback(String id) {
        return "hi, " + id + ", error!";
    }
}
