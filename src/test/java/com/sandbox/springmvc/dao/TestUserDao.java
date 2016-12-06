/**
 * 
 */
package com.sandbox.springmvc.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.springmvc.configuration.SandBoxConfiguration;
import com.sandbox.springmvc.model.RegisteredUser;

/**
 * @author Arnaud
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SandBoxConfiguration.class })
@WebAppConfiguration
public class TestUserDao {

	@Autowired
	UserDao userDao;

	@Test
	public void testUserDao() {
		Assert.assertNotNull(userDao);
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testUpdateRegisteredUser() {
		List<RegisteredUser> findAllUsers = userDao.findAllUsers();
		if (!findAllUsers.isEmpty()) {
			RegisteredUser regUser = findAllUsers.get(0);

			long id = regUser.getId();
			String add = regUser.getAddress();

			regUser.setAddress(add + add);

			userDao.updateUser(regUser);

			RegisteredUser retrievedRegUser = userDao.findById(id);
			Assert.assertEquals(add + add, retrievedRegUser.getAddress());
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void testCreateRegisteredUser() {
		RegisteredUser user = new RegisteredUser();
		user.setAddress("address");
		user.setEmail("email@email.fr");
		user.setUsername("username");
		userDao.saveUser(user);
	}
}
