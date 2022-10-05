package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	@RequestMapping(value = "/rest_guest_view", params = "guest_no")
	public Map guest_view(@RequestParam int guest_no, Model model) throws Exception {
		int code=0;
		String url="";
		String msg="";
		List<Guest> data=new ArrayList<Guest>();
		/***************************/
		Guest guest=guestService.selectByNo(guest_no);
		data.add(guest);
		code=1;
		msg="성공";
		url="guest_view";
		/***************************/
		
		Map resultMap=new HashMap();
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	@RequestMapping(value = "/rest_guest_list")
	public Map guest_list() throws Exception {
		int code=0;
		String url="";
		String msg="";
		List<Guest> data=new ArrayList<Guest>();
		/*********************/
		List<Guest> guestList=guestService.selectAll();
		code=1;
		msg="성공";
		url="guest_list";
		data.addAll(guestList);
		/********************/
		
		Map resultMap=new HashMap();
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", data);
		return resultMap;
	}
	
}
