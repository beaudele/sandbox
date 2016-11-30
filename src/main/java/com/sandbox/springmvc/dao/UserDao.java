package com.sandbox.springmvc.dao;

import java.util.List;

import com.sandbox.springmvc.model.RegisteredUser;

public interface UserDao {
	
	RegisteredUser findById(Long id);
	
	RegisteredUser findByName(String name);
	
	void saveUser(RegisteredUser user);
	
	void updateUser(RegisteredUser user);
	
	void deleteUserById(Long id);

	List<RegisteredUser> findAllUsers(); 
	
	void deleteAllUsers();
	
	public boolean isUserExist(RegisteredUser user);

}
