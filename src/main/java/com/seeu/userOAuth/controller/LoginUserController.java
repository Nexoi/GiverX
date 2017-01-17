package com.seeu.userOAuth.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seeu.userOAuth.model.User;
import com.seeu.userOAuth.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class LoginUserController {

	@Autowired
	private LoginUserService loginUserService;
	
	/**
	 * 登录
	 */
	@RequestMapping (value = "login", method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public ResponseEntity<String> login(HttpServletRequest request, HttpServletResponse response, @ModelAttribute User user){
		return loginUserService.login(request, response, user);
	}
}
