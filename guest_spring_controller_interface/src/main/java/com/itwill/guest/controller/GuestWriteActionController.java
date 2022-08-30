package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestWriteActionController implements Controller {
	private GuestService guestService;
	
	public GuestWriteActionController() {
		System.out.println("### GuestWriteActionController()생성자 호출");
	}

	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestWriteActionController : setGuestService(" + guestService + ") 메쏘드 호출");
		this.guestService = guestService;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv=new ModelAndView();
		if(request.getMethod().equalsIgnoreCase("GET")) {
			mv.setViewName("redirect:guest_main.do");
			return mv;
		}
		try {
			String guest_name=request.getParameter("guest_name");
			String guest_email=request.getParameter("guest_email");
			String guest_homepage=request.getParameter("guest_homepage");
			String guest_title=request.getParameter("guest_title");
			String guest_content=request.getParameter("guest_content");
			int insertRowCount=guestService.insertGuest(new Guest(0,
															guest_name,
															null,
															guest_email,
															guest_homepage,
															guest_title,
															guest_content));
			mv.setViewName("redirect:guest_list.do");
		}catch (Exception e) {
			e.printStackTrace();
			mv.setViewName("forward:/WEB-INF/views/guest_error.jsp");
		}
		return mv;
	}

}
