package com.simplilearn.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.User;
import com.simplilearn.service.UserService;

@Repository
public class UserServiceImpl implements UserService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	UserServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	public List<User> findAll() {
		List<User> users = session.createQuery("from User").list();
		return users;
	}

	public User findById(int userId) {
		User myUser = session.get(User.class, userId);
		return myUser;
	}

	@Transactional
	public void save(User newUser) {
		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(newUser);
		transaction.commit();
	}

	@Transactional
	public void delete(int userId) {
		Transaction transaction = session.beginTransaction();
		User myUser = session.get(User.class, userId);
		session.delete(myUser);
		transaction.commit();
	}

	public List<User> searchBy(String firstName, String email) {
		return null;
	}
}
