package com.libertymutual.goforcode.invoicify.controllers;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private UserRepository userRepository;
	private PasswordEncoder encoder;
	
	public HomeController(UserRepository userRepository, PasswordEncoder encoder) {
		this.userRepository = userRepository;
		this.encoder = encoder;
	}

	@GetMapping("")
	public String showHomePage() {
		return "home/default";
	}
	
	@GetMapping("signup")
	public ModelAndView signUp() {
		ModelAndView mv = new ModelAndView("home/signup");
		mv.addObject(mv);
		return mv;
	}
	
	@PostMapping("signup")
	public ModelAndView handleSignUp(User user) {
		ModelAndView mv = new ModelAndView();
		String password = user.getPassword();
		String encryptedPassword = encoder.encode(password);
		user.setPassword(encryptedPassword);
		
		try {
		userRepository.save(user);
		mv.setViewName("redirect:/login");
				
		} catch (DataIntegrityViolationException dive) {
			mv.setViewName("home/signup");
			mv.addObject("errorMessage", "Cannot signup with that username");
		}
			
		return mv;
	}
	
	//constraint violation exception
	//set return to home/signup
}

