package com.hibernate.entities.customer;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Embeddable
public class Address {
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "street", nullable = false)
    private String street;
    @Column(name = "house_number")
    private String houseNuber;
    @Column(name = "postal_code")
    private Integer postalCode;
    @Column(name = "flat_number")
    private String flatNumber;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
    private Customer customer;

    public Address() {
    
    }

    public Address(String country, String city, String street, String houseNuber, Integer postalCode, String flatNumber,
	    Customer customer) {
	super();
	this.country = country;
	this.city = city;
	this.street = street;
	this.houseNuber = houseNuber;
	this.postalCode = postalCode;
	this.flatNumber = flatNumber;
	this.customer = customer;
    }

    public String getCountry() {
	return country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getStreet() {
	return street;
    }

    public void setStreet(String street) {
	this.street = street;
    }

    public String getHouseNuber() {
	return houseNuber;
    }

    public void setHouseNuber(String houseNuber) {
	this.houseNuber = houseNuber;
    }

    public Integer getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
	this.postalCode = postalCode;
    }

    public String getFlatNumber() {
	return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
	this.flatNumber = flatNumber;
    }

    public Customer getCustomer() {
	return customer;
    }

    public void setCustomer(Customer customer) {
	this.customer = customer;
    }

}
