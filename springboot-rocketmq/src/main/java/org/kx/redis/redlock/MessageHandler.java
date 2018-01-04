package org.kx.redis.redlock;

import com.alibaba.rocketmq.common.message.MessageExt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 */
@Slf4j
@Component
public class MessageHandler {

    public boolean handleMessage(MessageExt messageExt) {
        String json = new String(messageExt.getBody());
        System.out.println("receive : "+json);
        return true;
    }
}
