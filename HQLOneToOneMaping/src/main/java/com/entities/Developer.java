package com.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "developers_table")
public class Developer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "developer_id")
	private long developerId;

	@Column(name = "developer_name")
	private String developerName;

	@Column(name = "developer_salary")
	private double developerSalary;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;

	public long getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(long developerId) {
		this.developerId = developerId;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public double getDeveloperSalary() {
		return developerSalary;
	}

	public void setDeveloperSalary(double developerSalary) {
		this.developerSalary = developerSalary;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
