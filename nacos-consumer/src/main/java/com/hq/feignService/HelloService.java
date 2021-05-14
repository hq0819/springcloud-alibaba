package com.hq.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nacos-service")
public interface HelloService {
    @GetMapping("/hello")
    public String hello();
}
