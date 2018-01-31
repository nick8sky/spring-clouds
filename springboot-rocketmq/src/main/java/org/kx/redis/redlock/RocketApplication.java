package org.kx.redis.redlock;

import com.alibaba.rocketmq.client.exception.MQBrokerException;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.remoting.exception.RemotingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by @author changsheng on 2017/12/16.
 */
@Slf4j
@SpringBootApplication
@RestController
public class RocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(RocketApplication.class , args);
    }

    @Autowired
    DefaultMQProducer appProducer;




    @RequestMapping("/send")
    public String send() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        Message msg = new Message("TEST",// topic
                "TEST",// tag
                "KKK",//key用于标识业务的唯一性
                ("Hello RocketMQ !!!!!!!!!!" ).getBytes()// body 二进制字节数组
        );
        SendResult result = appProducer.send(msg);
        System.out.println(result);
        return "true" ;

    }


}
