package com.hq.test;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.ArrayList;
import java.util.List;


public class ProducerOrderTest01 {
    public static void main(String[] args) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        DefaultMQProducer producer = new DefaultMQProducer("group01");
        producer.setNamesrvAddr("14.18.72.130:9876");
        producer.start();
        List<Order> list = new ArrayList<>();
        list.add(new Order(102,"浏览"));
        list.add(new Order(101,"浏览"));
        list.add(new Order(101,"下单"));
        list.add(new Order(102,"下单"));
        list.add(new Order(102,"付款"));
        list.add(new Order(102,"发货"));
        list.add(new Order(101,"付款"));
        list.add(new Order(101,"发货"));

        for (int i = 0; i < list.size(); i++) {
            Message message = new Message("topic01","tag01",list.get(i).toString().getBytes());
            SendResult send = producer.send(message, (v1, v2, v3) -> {
                int index = (int) v3;
                System.out.println(index % v1.size());
                return v1.get(index % v1.size());
            }, list.get(i).getOrderId());
            System.out.println(send.getSendStatus());

        }

        producer.shutdown();
    }
}
