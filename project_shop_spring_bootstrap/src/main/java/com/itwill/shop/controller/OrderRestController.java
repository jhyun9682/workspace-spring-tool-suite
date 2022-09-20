package com.itwill.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.user.UserService;


@RestController
public class OrderRestController {
	@Autowired
	private OrderService orderService;

	/*
	 * 주문리스트
	 */
	@LoginCheck
	@RequestMapping(value = "order_list_count_rest",produces = "application/json;charset=UTF-8")
	public List<Order> order_list_count(@RequestParam int o_no, HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		List<Order> orderList = orderService.list(sUserId);
		return orderList;
	}
	/*
	 * 주문상세
	 */
	@LoginCheck
	@RequestMapping(value = "order_detail_rest",produces = "application/json;charset=UTF-8")
	public Order order_detail(@RequestParam int o_no, HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		Order order = orderService.detail(sUserId, o_no);
		return order;
	}
	/*
	 * 주문1개삭제
	 */
	@LoginCheck
	@PostMapping(value = "order_item_delete_action_rest",produces = "application/json;charset=UTF-8" )
	public Map order_item_delete_action_rest(@RequestParam int o_no, HttpSession session) throws Exception {
		orderService.deleteByOrderNo(o_no);
		String sUserId = (String) session.getAttribute("sUserId");
		List<Order> orderList = orderService.list(sUserId);
		int order_count=orderList.size();
		
		Map map=new HashMap();
		map.put("remove_order_no",o_no);
		map.put("order_count", order_count);
		return map;
	}
	/*
	 * 주문전체삭제
	 */
	@LoginCheck
	@PostMapping(value = "order_all_delete_action_rest",produces = "application/json;charset=UTF-8" )
	public Map order_all_delete_action_rest( HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		orderService.delete(sUserId);
		List<Order> orderList = orderService.list(sUserId);
		int order_count=orderList.size();
		
		Map map=new HashMap();
		map.put("remove_order_no",-1);
		map.put("order_count", order_count);
		return map;
	}
	
}
