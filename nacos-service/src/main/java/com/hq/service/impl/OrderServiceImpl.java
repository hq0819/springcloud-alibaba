package com.hq.service.impl;

import com.hq.pojo.Orders;
import com.hq.service.OrderService;
import com.hq.service.mapper.OrdersMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrdersMapper ordersMapper;
    @Override
    public List<OrderService> queryOrders() {
        return ordersMapper.queryOrders();
    }

    @Override
    public void createOrder(Orders order) {
        ordersMapper.createOrder(order);
    }

    @Override
    public void updateOrder(Orders order) {
        ordersMapper.updateOrder(order);
    }
}
