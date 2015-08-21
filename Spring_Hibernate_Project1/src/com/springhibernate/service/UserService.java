package com.springhibernate.service;

import java.util.List;

import com.springhibernate.model.User;

public interface UserService {
	public void addUser(User user);

	public List<User> getUser();
	
	public void deleteUser(String collegeIdNumber);
	
	public List<User> getStudentById(String collegeIdNumber);
	
	public void updateUser(User user);
}