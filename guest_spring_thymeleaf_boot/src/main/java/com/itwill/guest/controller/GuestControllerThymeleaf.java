package com.itwill.guest.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestControllerThymeleaf {
	@Autowired
	private GuestService guestService;

	@RequestMapping("/guest_main")
	public String guest_main() {
		return "guest_main";
	}
	@RequestMapping("/guest_list")
	public String guest_list(HttpServletRequest request) {
		String forwardPath = "";
		try {
			List<Guest> guestList = guestService.selectAll();
			request.setAttribute("guestList", guestList);
			forwardPath = "guest_list";

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error_msg", e.getMessage());
			forwardPath = "guest_error";
		}
		return forwardPath;
	}
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "guest_error";
		return forwardPath;
	}
	@RequestMapping(value = "/guest_modify_action", method = RequestMethod.GET)
	public String guest_modify_action_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	@RequestMapping(value = "/guest_modify_action", method = RequestMethod.POST)
	public String guest_modify_action(@ModelAttribute Guest guest, Model model) {
		String forwardPath = "";

		try {
			// GuestDao guestDao=new GuestDao();
			int updateRowCount = guestService.updateGuest(guest);
			forwardPath = "redirect:guest_view?guest_no=" + guest.guest_no;

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", e.getMessage());
			forwardPath = "guest_error";
		}

		return forwardPath;
	}
	@RequestMapping(value = "/guest_modify_form", method = RequestMethod.GET)
	public String guest_modify_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	@RequestMapping(value = "/guest_modify_form", method = RequestMethod.POST)
	public String guest_modify(
			@RequestParam(value = "guest_no", required = false, defaultValue = "") String guest_noStr, Model model) {
		String forwardPath = "";
		if (guest_noStr == null || guest_noStr.equals("")) {
			forwardPath = "redirect:guest_list";

		} else {
			try {
				Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
				model.addAttribute("guest", guest);
				forwardPath = "guest_modify_form";

			} catch (Exception e) {
				e.printStackTrace();
				model.addAttribute("MSG", e.getMessage());
				forwardPath = "guest_error";

			}

		}

		return forwardPath;
	}
	@RequestMapping(value = "/guest_remove_action", method = RequestMethod.GET)
	public String guest_remove_action_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	@RequestMapping(value = "/guest_remove_action", method = RequestMethod.POST)
	public String guest_remove_action(@RequestParam("guest_no") String guest_noStr, Model model) {
		String forwardPath = "";
		int deleteRowCount = 0;
		try {
			deleteRowCount = guestService.deleteGuest(Integer.parseInt(guest_noStr));
			forwardPath = "redirect:guest_list";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			model.addAttribute("MSG", e.getMessage());
			forwardPath = "guest_error";
		}
		return forwardPath;
	}
	@RequestMapping("/guest_view")
	public String guest_view(@RequestParam(value = "guest_no", required = false, defaultValue = "") String guest_noStr,
			Model model) {
		String forwardPath = "";
		if (guest_noStr == null || guest_noStr.equals("")) {
			forwardPath = "redirect:guest_list";
		} else {
			try {
				Guest guest = guestService.selectByNo(Integer.parseInt(guest_noStr));
				model.addAttribute("guest", guest);
				forwardPath = "guest_view";
			} catch (Exception e) {
				e.printStackTrace();
				forwardPath = "guest_error";
			}
		}

		return forwardPath;
	}

	@RequestMapping(value = "/guest_write_action", method = RequestMethod.GET)
	public String guest_write_action_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}

	@RequestMapping(value = "/guest_write_action", method = RequestMethod.POST)
	public String guest_write_action(@ModelAttribute Guest guest, Model model) {
		String forwardPath = "";
		try {
			int insertRowCount = guestService.insertGuest(guest);
			forwardPath = "redirect:guest_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", "잘모르는실패!!!");
			forwardPath = "guest_error";
		}
		return forwardPath;
	}

	@RequestMapping(value = "/guest_write_form")
	public String guest_write() {
		String forwardPath = "guest_write_form";
		return forwardPath;

	}
	
	
	
	
	
	
	
	
	
	
	
	
}