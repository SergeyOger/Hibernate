package com.projectDao;

import com.entities.Customer;
import com.entities.Project;

public interface ProjectDAO {

    void saveProject(Project project);

    void deleteProjectById(long projectId);

    Project getProjectById(long projectId);

    Customer getprojectCustomerById(long projectId);
}
