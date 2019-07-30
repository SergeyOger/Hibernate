package com.project.service.impl;

import com.entities.Customer;
import com.entities.Project;
import com.project.service.ProjectService;
import com.projectDao.impl.ProjectDaoImpl;

public class ProjectServiceImpl implements ProjectService {

    @Override
    public void saveNewProject(Project project) {
	new ProjectDaoImpl().saveProject(project);
    }

    @Override
    public void deleteProjectById(long projectId) {
	new ProjectDaoImpl().deleteProjectById(projectId);
    }

    @Override
    public Project getProjectById(long projectId) {
	return new ProjectDaoImpl().getProjectById(projectId);
    }

    @Override
    public Customer getProjectCustomer(long projectId) {
	return new ProjectDaoImpl().getprojectCustomerById(projectId);
    }

}
