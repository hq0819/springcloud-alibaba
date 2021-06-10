package com.hq.test;

import org.apache.rocketmq.client.consumer.DefaultMQPullConsumer;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

/**
 *被动推送消费测试
 */
public class ConsumerOrderPullTest01 {

    public static void main(String[] args) throws MQClientException {
        //设置组名
        DefaultMQPullConsumer consumer = new DefaultMQPullConsumer("consumer01");
        //指定nameServer地址
        consumer.setNamesrvAddr("14.18.72.130:9876");
        //订阅主题，指定小类（tag）
        //consumer.subscribe("topic01","*");
        consumer.fetchSubscribeMessageQueues("topic01");


        //启动消费者
        consumer.start();
    }

}
