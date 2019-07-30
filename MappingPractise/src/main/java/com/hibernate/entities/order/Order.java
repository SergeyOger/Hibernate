package com.hibernate.entities.order;

import java.util.ArrayList;
import java.util.List;

import com.hibernate.entities.customer.Customer;
import com.hibernate.entities.manager.Manager;
import com.hibernate.entities.product.Product;

public class Order {

    private Long orderId;
    private Customer customer;
    private Manager manager;
    private List<Product> productList = new ArrayList();

}
