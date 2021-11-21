package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simplilearn.model.User;
import com.simplilearn.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(Model theModel) {
		List<User> users = userService.findAll();
		System.out.println("\n ****************All the users :"+ users);
		theModel.addAttribute("Users", users);
		return "list-users";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("userId") int userId, Model theModel) {
		User myUser = userService.findById(userId);
		theModel.addAttribute("User", myUser);
		return "User-Form";
	}

	@PostMapping("/save")
	public String saveUser(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("email") String email) {

		System.out.println("Trying to save the user with id :" + id);
		User myUser;
		if (id != 0) {
			// Update operation
			myUser = userService.findById(id);
			myUser.setEmail(email);
			myUser.setName(name);

		} else {
			// create operation
			myUser = new User(name, email);
		}
		userService.save(myUser);
		return "redirect:/users/list";
	}

	@GetMapping("/findUser")
	public String findUser(@RequestParam("id") int userId, Model theModel) {
		User user = userService.findById(userId);
		theModel.addAttribute("User", user);
		return "list-users";
	}
}
