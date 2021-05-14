package com.hq.feignService;

import com.hq.sentinel.HelleSentinelFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-service",fallback = HelleSentinelFallBack.class)
public interface HelloService {
    @GetMapping("/hello")
    public String hello();
}
