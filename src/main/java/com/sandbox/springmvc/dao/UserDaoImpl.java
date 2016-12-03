/**
 * 
 */
package com.sandbox.springmvc.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sandbox.springmvc.model.RegisteredUser;

/**
 * @author Arnaud
 *
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	@Override
	public RegisteredUser findById(Long id) {
		Criteria criteria = getSession().createCriteria(RegisteredUser.class);
		criteria.add(Restrictions.eq("id", id));
		return (RegisteredUser) criteria.uniqueResult();
	}

	@Override
	public RegisteredUser findByName(String name) {
		Criteria criteria = getSession().createCriteria(RegisteredUser.class);
		criteria.add(Restrictions.eq("username", name));
		return (RegisteredUser) criteria.uniqueResult();
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
		Query query = getSession().createSQLQuery("delete from RegisteredUser where id = :id");
		query.setBigInteger("id", BigInteger.valueOf(id));
		query.executeUpdate();
	}

	@Override
	public List<RegisteredUser> findAllUsers() {
		Criteria criteria = getSession().createCriteria(RegisteredUser.class);
		return (List<RegisteredUser>) criteria.list();
	}

	@Override
	public void deleteAllUsers() {
		Query query = getSession().createSQLQuery("delete from RegisteredUser");
		query.executeUpdate();
	}

	@Override
	public boolean isUserExist(RegisteredUser user) {
		// TODO Auto-generated method stub
		return user.getId() != null && findById(user.getId()) != null;
	}

}
