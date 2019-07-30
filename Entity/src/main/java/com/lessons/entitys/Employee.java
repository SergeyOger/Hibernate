package com.lessons.entitys;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

/*
 * @DynamicUpdate - update only changed values 
 */

@Entity
@Table(name = "employee_table")
@DynamicUpdate
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "employee_name", nullable = false, length = 100)
    private String employeeName;

    @Column(name = "employee_email", unique = true)
    private String employeeEmail;

    @Column(name = "date_of_employ")
    private Date dateOfEmploy;

    @Column(name = "employee_salary")
    private Double salary;
    
    public Employee() {

	}
	
	public Employee(String employeeName, String employeeEmail, Date dateOfEmploy, Double salary) {
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.dateOfEmploy = dateOfEmploy;
		this.salary = salary;
	
	}

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public Date getDateOfEmploy() {
        return dateOfEmploy;
    }

    public void setDateOfEmploy(Date dateOfEmploy) {
        this.dateOfEmploy = dateOfEmploy;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    
    @Override
    public String toString() {
    	return "Employee name " + employeeName + " employee email " + employeeEmail +
    			" employee salary " + salary;
    }
}
