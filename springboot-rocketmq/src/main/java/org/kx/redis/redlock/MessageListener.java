package org.kx.redis.redlock;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 */
@Slf4j
public class MessageListener implements MessageListenerConcurrently {

	private MessageHandler msgConsumeComponent;

	public void setMsgConsumeComponent(MessageHandler msgConsumeComponent) {
		this.msgConsumeComponent = msgConsumeComponent;
	}


	@Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
	    ConsumeConcurrentlyContext context) {
    	for (MessageExt messageExt : msgs) {
    	    log.info(messageExt.toString());
			log.info(new String(messageExt.getBody()));
			boolean result = msgConsumeComponent.handleMessage(messageExt);
			if (!result){
				return ConsumeConcurrentlyStatus.RECONSUME_LATER;
			}
    	}
    	return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
}