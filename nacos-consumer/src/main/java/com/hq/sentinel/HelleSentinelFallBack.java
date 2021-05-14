package com.hq.sentinel;

import com.hq.feignService.HelloService;
import org.springframework.stereotype.Component;

@Component
public class HelleSentinelFallBack implements HelloService {
    @Override
    public String hello() {
        return "访问的人数过多，请刷新！";
    }
}
