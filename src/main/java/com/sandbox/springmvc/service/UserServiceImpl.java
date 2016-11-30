package com.sandbox.springmvc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.springmvc.dao.UserDao;
import com.sandbox.springmvc.model.RegisteredUser;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<RegisteredUser> users;
	
	static{
		users= populateDummyUsers();
	}

	public List<RegisteredUser> findAllUsers() {
		return userDao.findAllUsers();
	}
	
	public RegisteredUser findById(Long id) {
		return userDao.findById(id);
	}
	
	public RegisteredUser findByName(String name) {
		return userDao.findByName(name);
	}
	
	public void saveUser(RegisteredUser user) {
		userDao.saveUser(user);
	}

	public void updateUser(RegisteredUser user) {
		userDao.updateUser(user);
	}

	public void deleteUserById(Long id) {
		userDao.deleteUserById(id);
	}

	public boolean isUserExist(RegisteredUser user) {
		return userDao.isUserExist(user);
	}
	
	public void deleteAllUsers(){
		userDao.deleteAllUsers();
	}

	private static List<RegisteredUser> populateDummyUsers(){
		List<RegisteredUser> users = new ArrayList<RegisteredUser>();
		users.add(new RegisteredUser(counter.incrementAndGet(),"Sam", "NY", "sam@abc.com"));
		users.add(new RegisteredUser(counter.incrementAndGet(),"Tomy", "ALBAMA", "tomy@abc.com"));
		users.add(new RegisteredUser(counter.incrementAndGet(),"Kelly", "NEBRASKA", "kelly@abc.com"));
		return users;
	}

}
