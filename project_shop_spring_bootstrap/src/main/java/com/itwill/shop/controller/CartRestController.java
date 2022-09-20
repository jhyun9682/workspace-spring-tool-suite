package com.itwill.shop.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;
@RestController
public class CartRestController {
	@Autowired
	private CartService cartService;

	/*
	 * 카트리스트
	 */
	@LoginCheck
	@RequestMapping(value = "cart_item_list_rest",produces = "application/json;charset=UTF-8")
	public List<CartItem> cart_item_count(HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		List<CartItem> cartItemList=cartService.getCartList(sUserId);
		return cartItemList;
	}
	/*
	 * 카트추가
	 */
	@LoginCheck
	@PostMapping(value = "cart_add_action_rest",produces = "text/plain;charset=UTF-8")
	public String cart_add_action(@RequestParam int p_no,@RequestParam int cart_qty,HttpSession session)throws Exception {
		String result="false";
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.addCart(sUserId,p_no,cart_qty);
		result="true";
		return result;
	}
	/*
	 * 카트아이템 1개삭제
	 */
	@LoginCheck
	@PostMapping(value = "cart_delete_item_action_rest",produces = "application/json;charset=UTF-8")
	public Map cart_delete_item_action_rest(@RequestParam int cart_no,HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.deleteCartItem(cart_no);
		
		List<CartItem> cartItemList=cartService.getCartList(sUserId);
		int tot_price=0;
		for (CartItem cartItem : cartService.getCartList(sUserId)) {
			tot_price+=cartItem.getCart_qty()*cartItem.getProduct().getP_price();
		}
		Map map=new HashMap();
		map.put("cart_tot_price", tot_price);
		map.put("cart_size", cartItemList.size());
		return map;
	}
	/*
	 * 카트아이템 전체삭제
	 */
	@LoginCheck
	@PostMapping(value = "cart_delete_all_item_action_rest",produces = "application/json;charset=UTF-8")
	public Map cart_delete_all_item_action_rest(HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.deleteCart(sUserId);
		List<CartItem> cartItemList=cartService.getCartList(sUserId);
		int tot_price=0;
		for (CartItem cartItem : cartService.getCartList(sUserId)) {
			tot_price+=cartItem.getCart_qty()*cartItem.getProduct().getP_price();
		}
		Map map=new HashMap();
		map.put("cart_tot_price", tot_price);
		map.put("cart_size", cartItemList.size());
		return map;
	}
	/*
	 * 카트아이템 수량수정
	 */
	@LoginCheck
	@RequestMapping(value = "cart_update_item_action_rest",produces = "application/json;charset=UTF-8")
	public Map cart_update_item_action_rest(@RequestParam int cart_no,@RequestParam int cart_qty,HttpSession session)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		cartService.updateCart(cart_no, cart_qty);
		int p_price=cartService.getCartItemByCartNo(cart_no).getProduct().getP_price();
		int tot_price=0;
		for (CartItem cartItem : cartService.getCartList(sUserId)) {
			tot_price+=cartItem.getCart_qty()*cartItem.getProduct().getP_price();
		}
		Map map=new HashMap();
		map.put("cart_no",cart_no);
		map.put("cart_qty",cart_qty);
		map.put("p_price",p_price);
		map.put("cart_item_subtotal",cart_qty*p_price);
		map.put("tot_price",tot_price);
		return map;
	}
}









