package com.hq.service.impl;

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
    @Override
    public List<OrderService> queryOrders() {
        return ordersMapper.queryOrders();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(Orders order) {
        ordersMapper.createOrder(order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateOrder(Orders order) {
        ordersMapper.updateOrder(order);
    }
}
