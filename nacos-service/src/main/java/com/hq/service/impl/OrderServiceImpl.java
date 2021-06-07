package com.hq.service.impl;

import com.hq.feignService.AccountFeignService;
import com.hq.pojo.Orders;
import com.hq.service.OrderService;
import com.hq.service.mapper.OrdersMapper;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersMapper ordersMapper;

    @Autowired
    AccountFeignService accountFeignService;

    @Override
    public List<OrderService> queryOrders() {
        return ordersMapper.queryOrders();
    }

    @Override
    @GlobalTransactional(name = "orders")
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(Orders order) {
        accountFeignService.payMoney("422446213",order.getPrice());
        ordersMapper.createOrder(order);
        if (order.getNum()==100){
            throw new RuntimeException("订单失败！");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Orders order) {
        ordersMapper.updateOrder(order);
    }
}
