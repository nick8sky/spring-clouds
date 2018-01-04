package org.kx.redis.redlock;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by sunkx on 2018/1/4
 */
@Slf4j
@Data
@Configuration
@ConfigurationProperties(prefix = "app.rocketmq.producer")
public class ProducerMqConfig {
    private String groupName;
    private String namesrvAddr;
    /** 4M */
    private int maxMessageSize;
    private int sendMsgTimeout;

    @Bean("appProducer")
    public DefaultMQProducer getRocketMQProducer(){
        if (StringUtils.isBlank(groupName)){
            throw new RuntimeException("groupName is null !!!");
        }
        if (StringUtils.isBlank(namesrvAddr)){
            throw new RuntimeException("namesrvAddr is null !!!");
        }
        DefaultMQProducer producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(this.namesrvAddr);
        producer.setMaxMessageSize(this.maxMessageSize);
        producer.setSendMsgTimeout(this.sendMsgTimeout);
        try {
            producer.start();
            log.info("app producer is start ! groupName:[{}],namesrvAddr:[{}]" , this.groupName, this.namesrvAddr);
        } catch (MQClientException e) {
            log.error("factory producer is error {}", e);
            throw new RuntimeException("app ");
        }
        return producer;
    }
}
