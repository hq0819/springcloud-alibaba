package com.hq.feignService;

import com.hq.config.FeignConfiguration;
import com.hq.sentinel.HelleSentinelFallBack;
import com.hq.sentinel.HelloSentinelFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-service",configuration= FeignConfiguration.class,fallbackFactory = HelloSentinelFactory.class)
public interface HelloService {
    @GetMapping("/hello")
    public String hello();
}
