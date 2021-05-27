package com.hq.feignService;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "nacos-consumer")
public interface AccountFeignService {

    @RequestMapping("/payMoney")
    public String payMoney(@RequestParam String accountid, @RequestParam double amount);
}
