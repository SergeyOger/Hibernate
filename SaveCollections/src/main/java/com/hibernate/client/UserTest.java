package com.hibernate.client;

import com.hibernate.entities.User;
import com.hibernate.model.Account;
import com.hibernate.service.impl.UserServiceImpl;

public class UserTest {

	public static void main(String[] args) {

		Account account = new Account();
		account.setLogin("login 1");
		account.setPassword("password 1");

		Account account1 = new Account();
		account1.setLogin("login 2");
		account1.setPassword("password 2");

		User user = new User();
		user.setUserName("first user");
		user.getUserAccounts().add(account);
		user.getUserAccounts().add(account1);

		new UserServiceImpl().saveUser(user);

		//new UserServiceImpl().deleteUser(1);

	}

}
