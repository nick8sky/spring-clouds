package org.kx.redis.redlock;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 */
@Slf4j
@Configuration
@Data
@ConfigurationProperties(prefix = "app.rocketmq.consumer")
public class ConsumerMqConfig {
    private String namesrvAddr;
    private String groupName;
    private String topic;
    private String tag;
    private int consumeThreadMin;
    private int consumeThreadMax;

    @Autowired
    private MessageHandler msgConsumeComponent;

    @Bean("bizGatewayConsumer")
    public DefaultMQPushConsumer getRocketMQConsumer(){
        if (StringUtils.isBlank(groupName)){
            throw new RuntimeException("groupName is null !!!");
        }
        if (StringUtils.isBlank(namesrvAddr)){
            throw new RuntimeException("namesrvAddr is null !!!");
        }
        if (StringUtils.isBlank(topic)){
            throw new RuntimeException("topic is null !!!");
        }
        if (StringUtils.isBlank(tag)){
            throw new RuntimeException("tag is null !!!");
        }
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(namesrvAddr);
        consumer.setConsumeThreadMin(consumeThreadMin);
        consumer.setConsumeThreadMax(consumeThreadMax);
        MessageListener messageListener = new MessageListener();
        messageListener.setMsgConsumeComponent(msgConsumeComponent);
        consumer.registerMessageListener(messageListener);
        try {
            consumer.subscribe(topic,this.tag);
            consumer.start();
            log.info("application consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupName,topic,namesrvAddr);
        } catch (MQClientException e){
            log.error("application consumer is start !!! groupName:{},topic:{},namesrvAddr:{}",groupName,topic,namesrvAddr,e);
            throw new RuntimeException("application consumer is start");
        }
        return consumer;
    }

}
