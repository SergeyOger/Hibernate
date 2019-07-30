package com.shop.stock.department;

import com.shop.stock.product.Product;

import java.util.LinkedList;
import java.util.List;

public abstract class Department {
    private long departmentId;
    private String departmentName;
    private List<Product> departmentItems = new LinkedList<Product>();
    private DepartmentType departmentType;
}
