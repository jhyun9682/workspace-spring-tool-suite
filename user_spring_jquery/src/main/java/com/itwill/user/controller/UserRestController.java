package com.itwill.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.user.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	
	/*
	/user_main
	/user_write_form
	/user_write_action
	/user_login_form
	/user_login_action
	/user_logout_action
	/user_view
	/user_modify_form
	/user_modify_action
	/user_remove_action
	*/
	
	
}
