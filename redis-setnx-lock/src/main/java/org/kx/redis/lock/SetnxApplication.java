package org.kx.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by sunkx on 2018/1/4
 */
@SpringBootApplication
@RestController
public class SetnxApplication {
    public static void main(String[] args) {
        SpringApplication.run(SetnxApplication.class, args);
    }
    @Autowired
    DistributedLock distributedLock;

    @RequestMapping("/")
    public String hi(){
        Lock lock=new Lock("lock","sssssssss");

        if(distributedLock.tryLock(lock)){
            return "true";
            //distributedLock.releaseLock(lock);
        }
        return  "false";
    }
}
