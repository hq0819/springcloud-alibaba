package com.hq.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hq.sentinelHandlers.SentinelFlowHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlowController {

    @SentinelResource(value ="demo01",blockHandler = "limitFlow")
    @RequestMapping("/demo01")
    public String demo01(){
        return "demo01";
    }

    @SentinelResource(value = "demo02",fallback = "fallBack01")
    @RequestMapping("/demo02")
    public String demo02(){
        return "demo02";
    }

    @SentinelResource(value = "demo03",blockHandlerClass = SentinelFlowHandler.class,blockHandler = "flowhander" )
    @RequestMapping("/demo03")
    public String demo03(){
        return "demo03";
    }
    public String limitFlow(BlockException e){
        System.out.println(e.fillInStackTrace());
        return "当前访问的人数过多，请稍后再试！";
    }

    @SentinelResource(value = "demo04",fallback = "fallback",fallbackClass = SentinelFlowHandler.class)
    @RequestMapping("/demo04")
    public String demo04(){
        return "demo04";
    }

    public String fallBack01(){
        return "网络异常!";
    }




}
