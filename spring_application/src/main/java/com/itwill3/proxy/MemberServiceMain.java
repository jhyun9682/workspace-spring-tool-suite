package com.itwill3.proxy;


public class MemberServiceMain {

	public static void main(String[] args) {
		System.out.println("--------no weaving-------");
		MemberService memberService=new MemberServiceImpl();
		memberService.create();
		memberService.list();
		memberService.view();
		memberService.login();
		System.out.println("--------weaving-------");
		MemberService memberServiceProxy1 = new MemberServiceSpringProxy(new MemberServiceImpl(),new LoggingBeforeAdvice());
		memberServiceProxy1.create();
		memberServiceProxy1.list();
		memberServiceProxy1.view();
		memberServiceProxy1.login();
			
		

	}

}
