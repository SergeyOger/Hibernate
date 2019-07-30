package com.project.service;

import com.entities.Customer;
import com.entities.Project;

public interface ProjectService {

    void saveNewProject(Project project);

    void deleteProjectById(long projectId);

    Project getProjectById(long projectId);

    Customer getProjectCustomer(long projectId);

}
