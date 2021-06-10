package com.hq.test;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 *被动推送消费测试
 */
public class ConsumerOrderPushTest01 {

    public static void main(String[] args) throws MQClientException {
        //设置组名
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("consumer01");
        //指定nameServer地址
        consumer.setNamesrvAddr("14.18.72.130:9876");
        //订阅主题，指定小类（tag）
        consumer.subscribe("topic01","*");
       /* //设置广播模式(默认是集群模式)
        consumer.setMessageModel(MessageModel.BROADCASTING);*/
        //设置监听
        consumer.registerMessageListener((MessageListenerOrderly) (list, consumeOrderlyContext) -> {
            for (MessageExt msg : list){
                System.out.println(new String(msg.getBody())+"----------"+Thread.currentThread().getName());
            }
            return ConsumeOrderlyStatus.SUCCESS;
        });
        //启动消费者
        consumer.start();
    }

}
