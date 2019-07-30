package com.infotech.model;

public class EmployeeStatistics {

	private Long employeeCount;
	private Double avgSalary;
	private Double minSalary;
	private Double sumOfSalary;

	public EmployeeStatistics(Long employeeCount, Double avgSalary, Double minSalary, Double sumOfSalary) {
		super();
		this.employeeCount = employeeCount;
		this.avgSalary = avgSalary;
		this.minSalary = minSalary;
		this.sumOfSalary = sumOfSalary;
	}

	public Long getEmployeeCount() {
		return employeeCount;
	}

	public void setEmployeeCount(Long employeeCount) {
		this.employeeCount = employeeCount;
	}

	public Double getAvgSalary() {
		return avgSalary;
	}

	public void setAvgSalary(Double avgSalary) {
		this.avgSalary = avgSalary;
	}

	public Double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Double minSalary) {
		this.minSalary = minSalary;
	}

	public Double getSumOfSalary() {
		return sumOfSalary;
	}

	public void setSumOfSalary(Double sumOfSalary) {
		this.sumOfSalary = sumOfSalary;
	}

	@Override
	public String toString() {
		return "EmployeeStatistics [employeeCount=" + employeeCount + ", avgSalary=" + avgSalary + ", minSalary="
				+ minSalary + ", sumOfSalary=" + sumOfSalary + "]";
	}

}
