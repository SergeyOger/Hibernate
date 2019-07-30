package com.hibernate.DAO;

import com.hibernate.entities.User;

public interface UserDao {

	void createUser(User user);

	User fetchUserById(int userId);

	void updateUserName(String name, int userId);

	void deleteUserById(int id);

}
