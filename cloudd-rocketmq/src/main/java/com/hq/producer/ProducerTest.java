package com.hq.producer;


import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerTest {
    @Autowired
    Source source;

    @RequestMapping("/send")
     public String sendMessage(String msg){
        MessageChannel output = source.output();
        output.send(MessageBuilder.withPayload(msg).build());
        return "发送成功!";
    }
}
