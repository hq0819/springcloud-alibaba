package com.hq.test;

public class Order {
    int orderId;
    String oper;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public Order() {
    }

    public Order(int orderId, String oper) {
        this.orderId = orderId;
        this.oper = oper;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", oper='" + oper + '\'' +
                '}';
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOper() {
        return oper;
    }
}
