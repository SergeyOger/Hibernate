package com.hibernate.entities;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;

import com.hibernate.model.Address;

import java.util.Date;

/*
 * @DynamicUpdate - update only changed values 
 */

@Entity
@Table(name = "employee_table")
@DynamicUpdate
public class Employee {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	/*
	 * Optional
	 * 
	 * @GeneratedValue(strategy = GenerationType.AUTO, generator =
	 * "empid_generator")
	 * 
	 * @SequenceGenerator(name = "empid_generator", initialValue = 1, allocationSize
	 * = 1, sequenceName = "emp_seq")
	 */

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

	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "home_street_name"), name = "street"),
			@AttributeOverride(column = @Column(name = "home_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name = "home_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name = "home_pin_code"), name = "pincode")
	})
	private Address homeAddress;

	@Embedded
	@AttributeOverrides(value = {
			@AttributeOverride(column = @Column(name = "office_street_name"), name = "street"),
			@AttributeOverride(column = @Column(name = "office_city_name"), name = "city"),
			@AttributeOverride(column = @Column(name = "office_state_name"), name = "state"),
			@AttributeOverride(column = @Column(name = "office_pin_code"), name = "pincode")
	})
	private Address officeAddress;

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

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}

	@Override
	public String toString() {
		return "Employee name " + employeeName + " employee email " + employeeEmail + " employee salary " + salary;
	}

}
