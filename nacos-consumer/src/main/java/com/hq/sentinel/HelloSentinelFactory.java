package com.hq.sentinel;

import com.hq.feignService.HelloService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloSentinelFactory implements FallbackFactory<HelloService> {
    @Override
    public HelloService create(Throwable throwable) {
        HelloService helloService = ()->
           "sentinel异常！";;
        return helloService;
    }
}
