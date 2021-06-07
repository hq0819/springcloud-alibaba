package com.hq.controller;

import com.hq.feignService.AccountFeignService;
import com.hq.pojo.Orders;
import com.hq.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;




    @RequestMapping("/queryOrders")
    public List queryOrders(){
        return orderService.queryOrders();
    }

    @RequestMapping("/doOrders")
    public List doOrders(int num){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Orders orders = new Orders();
        orders.setComments("尽快发货");
        orders.setGoodsName("苹果");
        orders.setNum(num);
        orders.setPrice(100);
        orders.setTimestamp(timestamp);
        orders.setGoodStatus("已付款");
        orderService.createOrder(orders);
        return orderService.queryOrders();

    }
}
