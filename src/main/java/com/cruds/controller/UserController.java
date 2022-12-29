package com.cruds.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cruds.entity.User;
import com.cruds.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login")
	public String showLoginPage()
	{
		return "login";
	}

	@RequestMapping(value="/login" ,method= RequestMethod.POST)
	public String doLogin(@RequestParam("userId") String userId
			              ,@RequestParam("password") String password
			               ,HttpSession session ,RedirectAttributes ra)
	{
		User user = userService.authenticate(userId, password);
		
		if(user != null)
		{
			user.setPassword("");
			session.setAttribute("USER", user);
			return "home";
		}
		else
		{
			ra.addAttribute("ERROR", "Invalid");
			return "redirect:login";
		}
		
	}
}
