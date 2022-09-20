package com.itwill.shop.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductService;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;
@SessionAttributes("viewProductList")
@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute("viewProductList")
	public List<Product> setUpViewProductList(){
		List<Product> productViewList=new ArrayList<Product>();
		return productViewList;
	}
	
	/*
	 * 상품리스트
	 */
	@RequestMapping(value = "/shop-grid-ns")
	public String product_list(Model model,HttpSession session) throws Exception{
		String sUserId=(String)session.getAttribute("sUserId");
		
		List<Product> productList=productService.getProductList();
		User loginUser=new User();
		List<CartItem> cartItemList=new ArrayList<CartItem>();
		int cartTotPrice=0;
		if(sUserId!=null) {
			loginUser=userService.findUser(sUserId);
			cartItemList = cartService.getCartList(sUserId);
			for (CartItem cartItem : cartItemList) {
				cartTotPrice+=cartItem.getProduct().getP_price()*cartItem.getCart_qty();
			}
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		model.addAttribute("productList", productList);
		return "shop-grid-ns";
	}
	
	/*
	@RequestMapping(value = "/product_detail",headers="content-type=text/plain")
	@RequestMapping(value = "/product_detail",headers="content-type=xml/*")
	@RequestMapping(value = "/product_detail",headers="content-type=html/*")
	@RequestMapping(value = "/product_detail",params ="p_no=1") 
	@RequestMapping(value = "/product_detail",params ="p_no!=1")
	@RequestMapping(value = "/product_detail",params ="p_no")
	@RequestMapping(value = "/product_detail",params ="!p_no")
	*/
	
	@RequestMapping(value = "/shop-single",params ="!p_no")
	public String product_detail_no_param() {
		return "redirect:shop-grid-ns";
	}
	/*
	 * 상품한개보기
	 */
	@RequestMapping(value = "/shop-single",params="p_no")
	public String product_detail(	@RequestParam int p_no,
									@ModelAttribute("viewProductList") List<Product> viewProductList,
									Model model,
									HttpSession session) throws Exception{
		String sUserId=(String)session.getAttribute("sUserId");
		
		Product product=productService.getProduct(p_no);
		boolean isExist=false;
		for (Product viewProduct : viewProductList) {
			if(viewProduct.getP_no()==product.getP_no()) {
				isExist=true;
				break;
			}
		}
		if(!isExist) {
			viewProductList.add(product);
		}
	
		List<Product> productList=productService.getProductList();
		User loginUser=new User();
		List<CartItem> cartItemList=new ArrayList<CartItem>();
		int cartTotPrice=0;
		if(sUserId!=null) {
			loginUser=userService.findUser(sUserId);
			cartItemList = cartService.getCartList(sUserId);
			for (CartItem cartItem : cartItemList) {
				cartTotPrice+=cartItem.getProduct().getP_price()*cartItem.getCart_qty();
			}
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		model.addAttribute("productList", productList);
		model.addAttribute("product", product);
		
		return "shop-single";
	}
}
