package com.hq.service;


import com.hq.pojo.Orders;

import java.util.List;

public interface OrderService {

    List<OrderService> queryOrders();
    void createOrder(Orders order);
    void updateOrder(Orders order);

}
