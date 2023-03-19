//Project: < Recipe Database >
//		* Assignment: < assignment 2 >
//		* Author(s): < Marie Pagaduan, Janine Usana, Ellyn Bibon>
//		* Student Number: < 101256979,  101328279, 101329235>
//		* Date: December 4, 2022
//		* Description: <It contains the main controller>
package net.javaguides.springboot.web;

import net.javaguides.springboot.model.Recipe;
import net.javaguides.springboot.model.User;
import net.javaguides.springboot.service.RecipeServices;
import net.javaguides.springboot.service.UserService;
import net.javaguides.springboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class MainController {

	@Autowired
	RecipeServices service;

	@Autowired
	UserServiceImpl userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}

}
