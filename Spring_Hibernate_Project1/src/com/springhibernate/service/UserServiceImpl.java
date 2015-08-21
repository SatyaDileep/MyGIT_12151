package com.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernate.dao.UserDao;
import com.springhibernate.model.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public void addUser(User user) {
		userDao.saveUserDetails(user);
	}

	@Override
	public List<User> getUser() {
		return userDao.getUsers();
	}

	@Override
	public void deleteUser(String collegeIdNumber) {
		// TODO Auto-generated method stub
		userDao.deleteUserDetails(collegeIdNumber);
	}

	@Override
	public List<User> getStudentById(String collegeIdNumber) {
		return userDao.getStudentDetailsById(collegeIdNumber);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updateUserDetails(user);
	}

}