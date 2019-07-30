package com.shop.order;

public enum OrderStatus {
    FORMED("Formed"), PROCESSED("Processed"), SENT("Sent"), COMPLETED("Completed");

    private String orderStatus;
    OrderStatus (String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
