package org.kx.session;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.CookieHttpSessionStrategy;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * create by sunkx on ${date}
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 7200,redisNamespace="nick")
public class RedisHttpSessionConfig {

    @Bean
    public RedisConnectionFactory connectionFactory() {

        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setPort(6379);
        connectionFactory.setHostName("**");
        connectionFactory.setPassword("**");
        return connectionFactory;
    }

    /*@Bean
    不要使用这个
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy();
    }*/

    @Bean
    public CookieHttpSessionStrategy cookieHttpSessionStrategy(){
        CookieHttpSessionStrategy strategy=new CookieHttpSessionStrategy();
        DefaultCookieSerializer cookieSerializer=new DefaultCookieSerializer();
        cookieSerializer.setCookieName("NICKSESSIONID");//cookies名称
        cookieSerializer.setCookieMaxAge(1800);//过期时间(秒)
        strategy.setCookieSerializer(cookieSerializer);
        return strategy;
    }

}
