package com.project.client;

import com.entities.Customer;
import com.entities.Developer;
import com.entities.Project;
import com.project.service.impl.ProjectServiceImpl;

public class ProjectClient {

    public static void main(String[] args) {

	createNewProjects(10);

    }

    public static void createNewProjects(int numberOfProjects) {
	for (int i = 1; i <= numberOfProjects; i++) {
	    createNewProject();
	}
    }

    public static void clearAllTables() {

	for (int i = 0; i < 100; i++) {
	    try {
		new ProjectServiceImpl().deleteProjectById(i);
	    } catch (NullPointerException e) {
		continue;
	    }

	}
    }

    public static void createNewProject() {

	Customer customer = new Customer();
	customer.setCustomerName("Jon Smit");
	customer.setCustomerData("First company customer");

	Developer developer1 = new Developer();
	developer1.setDeveloperName("Java developer");
	developer1.setDeveloperSalary(10000);

	Developer developer2 = new Developer();
	developer2.setDeveloperName("Pyton developer");
	developer2.setDeveloperSalary(9000);

	Project project = new Project();
	project.setProjectName("First company project");
	project.setCustomer(customer);
	project.getProjectDevelopers().add(developer1);
	project.getProjectDevelopers().add(developer2);

	developer1.setProject(project);
	developer2.setProject(project);

	new ProjectServiceImpl().saveNewProject(project);
    }

}
