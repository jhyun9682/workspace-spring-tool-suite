package com.itwill.shop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ShopGlobalExceptionController {
	/* shop_global_exception_handler 메소드는 Exception 타입으로 처리하는 모든 예외를 처리하도록 설정*/
	@ExceptionHandler(Exception.class)
	public String shop_global_exception_handler(Exception e) {
		return "error404";
	}
	/* handleError404 메소드는 404 예외를 처리하도록 설정
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleError404(NoHandlerFoundException ex) {
		return "redirect:error404";
	}
	*/
	
	/* shop_global_exception_handler 메소드는 Exception 타입으로 처리하는 모든 예외를 처리하도록 설정
	@ExceptionHandler(Exception.class)
	public ModelAndView shop_global_exception_handler(Exception e, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("404");
		mv.addObject("exception", e);  //예외를 뷰에 넘깁니다.
		mv.addObject("url", request.getRequestURL());
		return mv;
	}
	*/
	/* handleError404 메소드는 404 예외를 처리하도록 설정
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handleError404(HttpServletRequest request, Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("404");
		mv.addObject("message", "404오류");
		mv.addObject("url", request.getRequestURL());
		return mv;
	}
	*/
}
