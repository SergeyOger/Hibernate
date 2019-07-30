package com.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employee_table")
@DiscriminatorValue(value = "employee_type")
public class Employee extends Person {

    @Column(name = "salary", columnDefinition = "DECIMAL(7,2)")
    private Double salary;

    @Column(name = "company")
    private String company;

    public Double getSalary() {
	return salary;
    }

    public void setSalary(Double salary) {
	this.salary = salary;
    }

    public String getCompany() {
	return company;
    }

    public void setCompany(String company) {
	this.company = company;
    }

    @Override
    public String toString() {
	return "Employee + " + super.toString() + " salary=" + salary + ", company=" + company;
    }
    
    

}
