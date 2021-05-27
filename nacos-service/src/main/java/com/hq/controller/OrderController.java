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

    @Autowired
    AccountFeignService accountFeignService;


    @RequestMapping("/queryOrders")
    public List queryOrders(){
        return orderService.queryOrders();
    }

    @RequestMapping("/doOrders")
    @GlobalTransactional(rollbackFor = Exception.class)
    public List doOrders(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Orders orders = new Orders();
        orders.setComments("尽快发货");
        orders.setGoodsName("苹果");
        orders.setNum(20);
        orders.setPrice(100);
        orders.setTimestamp(timestamp);
        orders.setGoodStatus("待付款");
        orderService.createOrder(orders);
        double price = orders.getPrice();
        accountFeignService.payMoney("422446213",orders.getPrice());
        orders.setGoodStatus("已付款");
        orderService.updateOrder(orders);
        return orderService.queryOrders();

    }
}
