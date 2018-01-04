package nick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ServiceFeignClient serviceFeignClient;

    @RequestMapping("/hi")
    public String hi(@RequestParam String id){
        return serviceFeignClient.hi(id);
    }
}
