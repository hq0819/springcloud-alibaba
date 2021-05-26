package com.hq.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hq.feignService.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/test")
    @SentinelResource(value = "/test")
    public String testFeign(){
        return helloService.hello();
    }

}

