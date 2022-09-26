<<<<<<< HEAD
package com.itwill.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping(value = "/user")
	public String user() {
		return "user";
	}

}
=======
package com.itwill.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@RequestMapping(value = "user")
	public String user() {
		return "user";
	}

}
>>>>>>> branch 'main' of https://github.com/jhyun9682/workspace-spring-tool-suite.git
