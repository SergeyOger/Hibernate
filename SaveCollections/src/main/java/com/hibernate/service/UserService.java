package com.hibernate.service;

import com.hibernate.entities.User;

public interface UserService {

	void saveUser(User user);

	void deleteUser(int id);

	User fetchUserBuID(int id);

	void updateUserName(String name, int userId);

}
