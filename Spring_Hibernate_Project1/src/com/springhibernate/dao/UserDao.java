package com.springhibernate.dao;

import java.util.List;

import com.springhibernate.model.User;

public interface UserDao {
	public void saveUserDetails(User user);
	
	public List<User> getUsers();
	
	public void deleteUserDetails(String collegeIdNumber);
	
	public List<User> getStudentDetailsById(String collegeIdNumber);
	
	public void updateUserDetails(User user);
}
