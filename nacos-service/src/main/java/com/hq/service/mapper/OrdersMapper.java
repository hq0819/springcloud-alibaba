package com.hq.service.mapper;


import com.hq.pojo.Orders;
import com.hq.service.OrderService;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {

    List<OrderService> queryOrders();
    void createOrder(Orders order);
    void updateOrder(Orders order);
}
