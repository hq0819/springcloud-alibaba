package com.hq.pojo;

import java.sql.Timestamp;

public class Orders {
    long orderId;
    String goodsName;
    double price;
    int nums;
    String comments;
    Timestamp timestamp;
    String goodStatus;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        orderId = orderId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return nums;
    }

    public void setNum(int num) {
        this.nums = num;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(String goodStatus) {
        this.goodStatus = goodStatus;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                ", num=" + nums +
                ", comments='" + comments + '\'' +
                ", timestamp=" + timestamp +
                ", goodStatus='" + goodStatus + '\'' +
                '}';
    }
}
