package com.hq.test;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;



public class Test {
    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("group01");
        producer.setNamesrvAddr("14.18.72.130:9876");

        producer.start();

        Message message = new Message("test01","pro","first message !".getBytes());

        SendResult send = producer.send(message);

        System.out.println(send.getSendStatus());

        producer.shutdown();
    }
}
