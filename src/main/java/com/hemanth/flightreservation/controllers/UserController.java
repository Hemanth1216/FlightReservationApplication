package com.hemanth.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hemanth.flightreservation.entities.User;
import com.hemanth.flightreservation.repositories.UserRepository;
import com.hemanth.flightreservation.services.SecurityService;

@Controller
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
//	@Autowired
//	SecurityService securityService;
	
//	@Autowired
//	private BCryptPasswordEncoder encoder; //to encrypt password
	
	@RequestMapping("/showReg")
	public String showRegisterPage() {
		return "login/registerUser";
	}
	
	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user) {
		//user.setPassword(encoder.encode(user.getPassword())); //password is encrypted
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap model) {
		User user = userRepo.findByEmail(email);
		//password = encoder.encode(password);  //added by me--
		//boolean loginResponse = securityService.login(email, password);
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println(password);
		if(!user.getPassword().equals(password)) {
			model.put("msg","Invalid Credentails. Try again...");
			return "login/login";
		}
		return "findFlights";
	}
}
