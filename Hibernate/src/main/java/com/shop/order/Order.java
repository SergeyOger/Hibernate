package com.shop.order;

import com.user.User;
import com.shop.stock.product.Product;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class Order {
    private String orderNumber;
    private User user;
    private Calendar orderDate;
    private List<Product> productList = new LinkedList<Product>();
    private OrderStatus orderStatus;
}
