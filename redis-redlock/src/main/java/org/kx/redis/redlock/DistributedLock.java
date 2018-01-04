package org.kx.redis.redlock;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * create by sunkx on 2018/1/4
 */
@Component
public class DistributedLock {
    private final static String LOCKER_PREFIX = "lock:";

    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private RedissonProperties redssionProperties;

    RedissonClient redisson;
    @PostConstruct
    public void init(){
        Config config = new Config();
        config.useSingleServer().setAddress(redssionProperties.getHost()+":"+redssionProperties.getPort());
        if(StringUtils.isNotBlank(redssionProperties.getPassword())) {
            config.useSingleServer().setPassword(redssionProperties.getPassword());
        }

        redisson = Redisson.create(config);
    }

    public boolean tryLock(String key,  int lockTime) {
        try{
            RLock lock = redisson.getLock(LOCKER_PREFIX + key);
            //long waitTime, long lockTime, TimeUnit unit
            //lockTime >= waitTime,else always true
            return lock.tryLock(5, lockTime, TimeUnit.SECONDS);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
