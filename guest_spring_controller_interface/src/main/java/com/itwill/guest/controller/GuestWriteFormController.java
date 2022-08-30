package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class GuestWriteFormController implements Controller{
	public GuestWriteFormController() {
		System.out.println("### GuestWriteFormController()생성자 호출");
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView("forward:/WEB-INF/views/guest_write_form.jsp");
		return mv;
	}
	
}
