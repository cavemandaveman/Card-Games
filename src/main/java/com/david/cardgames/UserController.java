package com.david.cardgames;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.david.beans.User;

@Controller
@Scope("session")
@SessionAttributes({"name"})
public class UserController {

	@Autowired
	private User user;
	//private UserDB db = new UserDB();
	
	//Default home page is login page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginGET() {

		return "login";
	}
	//When coming from register page do this
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String loginPOST(Model model, @RequestParam String name,
			@RequestParam String password, @RequestParam String email) {

		if(name.equals("") || password.equals("") || email.equals("")) {
			model.addAttribute("error", "true");
			return "register";
		}
		//db.writeUser(name, password, email);
		user.setName(name);
		user.setPassword(password);
		user.setEmail(email);
		return "login";

	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		
		return "register";
	}
	
	//Come here after login
	@RequestMapping(value = "/*", method = RequestMethod.POST)
	public String startGame(Model model, @RequestParam String email, @RequestParam String password) {
		
		if(email.equals(user.getEmail()) && password.equals(user.getPassword())) {
			model.addAttribute("name", user.getName());
			return "start";
		}
		else {
			model.addAttribute("error", "true");
			return "login";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		
		return "logout";
	}
	
	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String error() {
		
		return "error";
	}
	
}
