package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamModelAttributeController {
	@RequestMapping(value = "parameter_guest_write_form.do")
	public String parameter_guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	@RequestMapping(value = "parameter_guest_write_action.do",method=RequestMethod.POST)
	public String parameter_guest_write_action(@RequestParam String guest_name,
											@RequestParam String guest_email,
											@RequestParam String guest_homepage,
											@RequestParam String guest_title,
											@RequestParam String guest_content) {
		return "";
	}

}
