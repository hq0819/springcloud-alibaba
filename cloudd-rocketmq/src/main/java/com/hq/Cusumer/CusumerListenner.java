package com.hq.Cusumer;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;

@Service
public class CusumerListenner {
    @StreamListener(Sink.INPUT)
    public void reciver(String msg){
        System.out.println(msg);
    }
}
