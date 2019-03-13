package com.medical.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.medical.entity.UserEntity;
import com.medical.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userSerivce;

	@RequestMapping(value = "/")
	public ModelAndView welcomePage(Model model, HttpServletResponse res) {
		String instName = "Radical Technologies";
		ModelAndView modelview = new ModelAndView();
		modelview.addObject("name", instName);
		modelview.setViewName("loginPage");
		modelview.addObject("user", new UserEntity());
		return modelview;
	}

	@RequestMapping(value = "/login")
	public ModelAndView loginSuccess(@ModelAttribute UserEntity user,
			Model model, HttpServletResponse res) {
		UserEntity user1 = null;
		user1 = userSerivce.fetchUserByUserName(user.getUserName());
		if (user1 != null && user1.getUserId() != null) {
			return new ModelAndView("success", "user", new UserEntity());
		} else {
			return new ModelAndView("loginPage", "user", user);
		}
	}

	@RequestMapping(value = "/registerPage")
	public ModelAndView userRegisterPage() {
		ModelAndView modelview = new ModelAndView("userRegisterPage",
				"userModel", new UserEntity());
		return modelview;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(
			@ModelAttribute(value = "userModel") UserEntity userEntity,
			HttpServletRequest request, Model model) {

		if (userEntity.getUserId() != null) {
			System.out.println("update user");

		} else {
			System.out.println("add user");
			userSerivce.saveOrUpdateUser(userEntity);
			userEntity.setUserId(123l);
		}

		return new ModelAndView("userRegisterPage", "userModel", userEntity);

	}

	public UserService getUserSerivce() {
		return userSerivce;
	}

	public void setUserSerivce(UserService userSerivce) {
		this.userSerivce = userSerivce;
	}

}
