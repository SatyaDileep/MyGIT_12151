package com.springhibernate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springhibernate.model.User;
import com.springhibernate.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public ModelAndView getRegisterForm(@ModelAttribute("user") User user,
			BindingResult result) {
		ArrayList<String> gender = new ArrayList<String>();
		gender.add("Male");
		gender.add("Female");
		ArrayList<String> city = new ArrayList<String>();
		city.add("Delhi");
		city.add("Kolkata");
		city.add("Chennai");
		city.add("Bangalore");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("gender", gender);
		model.put("city", city);
		System.out.println("Register Form");
		return new ModelAndView("Register", "model", model);
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public ModelAndView saveUserData(@ModelAttribute("user") User user,
			BindingResult result) {
		if(result.hasErrors())
		{
			System.out.println("Has Errors..!");
			return new ModelAndView("redirect:/register");
		}
		userService.addUser(user);
		System.out.println("Save User Data");
		return new ModelAndView("redirect:/userList.html");
	}

	@RequestMapping("/userList")
	public ModelAndView getUserList() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userService.getUser());
		return new ModelAndView("UserDetails", model);

	}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam String collegeIdNumber) {
		System.out.println("Deletion..!"+collegeIdNumber);
		userService.deleteUser(collegeIdNumber);
		return new ModelAndView("redirect:/userList.html");

	}
	
	@RequestMapping("/editUser")
	public ModelAndView editUser(@RequestParam String collegeIdNumber) {
	//	User userDetails = userService.getStudentById(collegeIdNumber);
		ArrayList<String> cityList = new ArrayList<String>();
		cityList.add("Delhi");
		cityList.add("Kolkata");
		cityList.add("Chennai");
		cityList.add("Bangalore");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("user", userService.getStudentById(collegeIdNumber));
		model.put("cityList", cityList);
		return new ModelAndView("UpdateUserDetails", "userModel", model);

	}
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("updatedUserDetails") User user) {
		System.out.println("Update...!");
		userService.updateUser(user);
		return new ModelAndView("redirect:/userList.html");
	}
}