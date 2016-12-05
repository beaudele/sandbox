/**
 * 
 */
package com.sandbox.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sandbox.springmvc.model.RegisteredUser;

/**
 * @author Arnaud
 *
 */
@Repository("userDao")
@Transactional
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public RegisteredUser findById(Long id) {
		return getEntityManager().find(RegisteredUser.class, id);
	}

	@Override
	public RegisteredUser findByName(String name) {
		return getEntityManager().find(RegisteredUser.class, name);
	}

	@Override
	public void saveUser(RegisteredUser user) {
		persist(user);
	}

	@Override
	public void updateUser(RegisteredUser user) {
		update(user);
	}

	@Override
	public void deleteUserById(Long id) {
		javax.persistence.Query query = getEntityManager()
				.createNativeQuery("delete from RegisteredUser where id =" + id);
		query.executeUpdate();
	}

	@Override
	public List<RegisteredUser> findAllUsers() {
		return getEntityManager().createQuery("select a from RegisteredUser a", RegisteredUser.class).getResultList();
	}

	@Override
	public void deleteAllUsers() {
		javax.persistence.Query query = getEntityManager().createNativeQuery("delete from RegisteredUser");
		query.executeUpdate();
	}

	@Override
	public boolean isUserExist(RegisteredUser user) {
		// TODO Auto-generated method stub
		return user.getId() != null && findById(user.getId()) != null;
	}

}
