package com.hq.test;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

/**
 *被动推送消费测试
 */
public class ConsumerPushTest02 {

    public static void main(String[] args) throws MQClientException {
        //设置组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer01");
        //指定nameServer地址
        consumer.setNamesrvAddr("14.18.72.130:9876");
        //订阅主题，指定小类（tag）
        consumer.subscribe("top01","tag01");
      /*  //设置广播模式
        consumer.setMessageModel(MessageModel.BROADCASTING);*/
        //设置监听
        consumer.registerMessageListener((MessageListenerConcurrently)(v1, v2)->{

            for (MessageExt m: v1) {

                System.out.println(new String(m.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        //启动消费者
        consumer.start();
    }

}
