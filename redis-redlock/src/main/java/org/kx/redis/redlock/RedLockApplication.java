package org.kx.redis.redlock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * create by sunkx on 2018/1/4
 */
@SpringBootApplication
@RestController
public class RedLockApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedLockApplication.class, args);
    }
    @Autowired
    DistributedLock distributedLock;

    @RequestMapping("/")
    public String hi(){
        if(distributedLock.tryLock("100000000",50)){
            return "true";
            //distributedLock.releaseLock(lock);
        }
        return  "false";
    }
}
