package com.itwill.shop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.order.Address;
import com.itwill.shop.order.Card;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderService;
import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;

@SessionAttributes({ "order", "address", "card" ,"viewProductList"})
@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private CartService cartService;

	@ModelAttribute("order")
	public Order setUpOrder() {
		return new Order();
	}

	@ModelAttribute("address")
	public Address setUpAddress() {
		return new Address();
	}

	@ModelAttribute("card")
	public Card setUpCard() {
		return new Card();
	}
	@ModelAttribute("viewProductList")
	public List<Product> setUpViewProductList() {
		return new ArrayList<Product>();
	}

	/*
	 * 결제주소 입력폼
	 */
	@LoginCheck
	@RequestMapping(value = "/checkout-address")
	public String checkout_address(@ModelAttribute("viewProductList") List<Product> viewProductList,Model model, HttpSession session)throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		return "checkout-address";
	}
	/*
	 * 결재주소 세션저장
	 * 결제배송방법 입력폼
	 */
	@LoginCheck
	@RequestMapping(value = "/checkout-shipping")
	public String checkout_shipping(@ModelAttribute("order") Order order,
									@ModelAttribute("address") Address address,
									@ModelAttribute("viewProductList") List<Product> viewProductList,
									Model model,
									HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		order.setAddress(address);
		
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		return "checkout-shipping";
	}
	/*
	 * 결제배송방법 세션저장
	 * 카드정보 입력폼
	 */
	@LoginCheck
	@RequestMapping(value = "/checkout-payment")
	public String checkout_payment(	@ModelAttribute("order") Order order,
									@ModelAttribute("viewProductList") List<Product> viewProductList,
								   Model model,
								   HttpSession session)	throws Exception {

		String sUserId = (String) session.getAttribute("sUserId");
		
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);

		return "checkout-payment";
	}
	/*
	 * 카드정보 세션저장
	 * 결재상품,배송주소,결재카드정보 보여주기
	 */
	@LoginCheck
	@RequestMapping(value = "/checkout-review")
	public String checkout_review(	@SessionAttribute("order") Order order, 
									@ModelAttribute("card") Card card,
									@ModelAttribute("viewProductList") List<Product> viewProductList,
									Model model,
									HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		
		order.setCard(card);
		
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);

		return "checkout-review";
	}
	/*
	 * 결재상품,배송주소,결재카드정보를 사용해서 주문(세션정보삭제)
	 * 주문완료 페이지보여주기
	 */
	@LoginCheck
	@RequestMapping(value = "/checkout-complete")
	public String checkout_complete(@SessionAttribute("order") Order order, 
									@ModelAttribute("viewProductList") List<Product> viewProductList,
									Model model, 
									SessionStatus sessionStatus,
									HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		orderService.create(sUserId);
		
		User loginUser = userService.findUser(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getCart_qty() * cartItem.getProduct().getP_price();
		}
		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		sessionStatus.setComplete();
		return "checkout-complete";
	}
	/*
	 * 주문리스트
	 */
	@LoginCheck
	@RequestMapping(value = "/account-orders")
	public String order_list( Model model,HttpSession session) throws Exception {
		String sUserId = (String) session.getAttribute("sUserId");
		
		List<Order> orderList = orderService.list(sUserId);
		List<CartItem> cartItemList = cartService.getCartList(sUserId);
		User loginUser = userService.findUser(sUserId);
		int cartTotPrice = 0;
		for (CartItem cartItem : cartItemList) {
			cartTotPrice += cartItem.getProduct().getP_price() * cartItem.getCart_qty();
		}

		model.addAttribute("loginUser", loginUser);
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("cartTotPrice", cartTotPrice);
		model.addAttribute("orderList", orderList);
		return "account-orders";
	}
}
