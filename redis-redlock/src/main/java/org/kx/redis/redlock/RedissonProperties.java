package org.kx.redis.redlock;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * create by sunkx on 2018/1/4
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonProperties {

    private int timeout = 3000;

    private String host;

    private  String port;

    private String password;

    private int connectionPoolSize = 64;

    private int connectionMinimumIdleSize = 10;

    private int slaveConnectionPoolSize = 250;

    private int masterConnectionPoolSize = 250;

    private String[] sentinelAddresses;

    private String masterName;
}
