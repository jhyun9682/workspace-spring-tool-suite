package com.itwill.shop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;
	@Autowired 
	private UserService userService;
	@Autowired 
	private ProductService productService;
	/*
	 카트리스트
	 */
	@LoginCheck
	@RequestMapping(value = "cart")
	public String cart_view(HttpSession session,Model model)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		User loginUser=userService.findUser(sUserId);
		List<Product> productList=productService.getProductList();
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice=0;
		for (CartItem cartItem : cartItemList) {
				cartTotPrice+=cartItem.getProduct().getP_price()*cartItem.getCart_qty();
		}
		
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		model.addAttribute("productList", productList);
		return "cart";
	}
}
