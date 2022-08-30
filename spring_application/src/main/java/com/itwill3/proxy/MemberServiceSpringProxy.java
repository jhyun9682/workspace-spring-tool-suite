package com.itwill3.proxy;

/*
 * Spring Container가구현하는 Proxy객체
 */
public class MemberServiceSpringProxy implements MemberService{
	private MemberService targetObject;
	private LoggingBeforeAdvice logginBeforeAdvice;
	
	public MemberServiceSpringProxy(MemberService memberService,LoggingBeforeAdvice loggingBeforeAdvice) {
		this.targetObject = memberService;
		this.logginBeforeAdvice=loggingBeforeAdvice;
	}
	
	
	@Override
	public void create() {
		logginBeforeAdvice.beforeLog();
		targetObject.create();
		
	}

	@Override
	public void login() {
		logginBeforeAdvice.beforeLog();
		targetObject.login();
		
	}

	@Override
	public void list() {
		logginBeforeAdvice.beforeLog();
		targetObject.list();
		
	}

	@Override
	public void view() {
		logginBeforeAdvice.beforeLog();
		targetObject.view();
		
	}
	
	

}
