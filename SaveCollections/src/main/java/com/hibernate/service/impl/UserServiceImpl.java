package com.hibernate.service.impl;

import com.hibernate.DAO.impl.UserDAOImpl;
import com.hibernate.entities.User;
import com.hibernate.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void saveUser(User user) {
		new UserDAOImpl().createUser(user);
	}

	@Override
	public void deleteUser(int id) {
		new UserDAOImpl().deleteUserById(id);
	}

	@Override
	public User fetchUserBuID(int id) {

		return new UserServiceImpl().fetchUserBuID(id);
	}

	@Override
	public void updateUserName(String name, int userId) {
		new UserServiceImpl().updateUserName(name, userId);
	}

}
