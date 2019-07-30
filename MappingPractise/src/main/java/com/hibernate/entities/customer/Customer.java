package com.hibernate.entities.customer;

import com.hibernate.entities.payment.Card;

public class Customer {

    private Long customerId;
    private String customerName;
    private String email;
    private Card card;
    private Address address;

}
