package com.springhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springhibernate.model.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void saveUserDetails(User user) {
		sessionfactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public List<User> getUsers() {
		@SuppressWarnings("unchecked")
		List<User> userlist = sessionfactory.getCurrentSession()
				.createCriteria(User.class).list();
		return userlist;
	}

	@Override
	public void deleteUserDetails(String collegeIdNumber) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();  
		Transaction tx = session.beginTransaction();  
	//	session.delete(user);  
		session.createQuery("DELETE FROM User WHERE collegeIdNumber = '"+collegeIdNumber+"'").executeUpdate();
		tx.commit(); 
		
	//	sessionFactory.getCurrentSession().createQuery("DELETE FROM Employee WHERE empid = "+employee.getEmpId()).executeUpdate(); 
	}

	@Override
	public List<User> getStudentDetailsById(String collegeIdNumber) {
		// TODO Auto-generated method stub
		Session session = sessionfactory.openSession();
		@SuppressWarnings("unchecked")
		List<User> studentData = (List<User>) session.createQuery("from User where collegeIdNumber = '"+collegeIdNumber+"'").list();

		return studentData;
		
	}

	@Override
	public void updateUserDetails(User user) {
		// TODO Auto-generated method stub
		System.out.println("in dao.."+user.getFirstName());
		Session session = sessionfactory.openSession();  
		Transaction tx = session.beginTransaction();
		session.update(user);
		tx.commit();
		System.out.println("inss dao.."+user.getFirstName());
	}

}
