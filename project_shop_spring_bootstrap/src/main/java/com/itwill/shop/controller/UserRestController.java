package com.itwill.shop.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.shop.controller.interceptor.LoginCheck;
import com.itwill.shop.user.Account;
import com.itwill.shop.user.User;
import com.itwill.shop.user.UserService;

@RestController
public class UserRestController {
	@Autowired
	private UserService userService;
	/*
	 * 회원로그인
	 */
	@PostMapping(value = "/account-login-rest",produces = "application/json;charset=UTF-8")
	public Map user_login_action_post(@RequestParam String userId,@RequestParam String password,Model model,HttpSession session) throws Exception{
		User user=new User(userId, password, "", "");
		int result = userService.login(user.getUserId(), user.getPassword());
		/*
		 * 0 아이디존재안함
		 * 1 패쓰워드불일치
		 * 2 패쓰워드일치(로그인성공)
		 */
		if(result==2) {
			//로그인성공
			session.setAttribute("sUserId", user.getUserId());
		}
		
		HashMap map=new HashMap();
		map.put("result", result);
		map.put("user", user);
		return map;
	}
	/*
	 * 회원아이디 중복체크
	 */
	@RequestMapping(value = "/user_id_duplicate_check_rest",produces = "text/plain;charset=UTF-8")
	public String user_id_duplicate_check(@RequestParam String userId) throws Exception{
		boolean isDuplicate= userService.isDuplcateUserId(userId);
		System.out.println(!isDuplicate+"-->"+userId);
		return !isDuplicate+"";
	}
	/*
	 * 회원이름
	 */
	@LoginCheck
	@RequestMapping(value = "user_name_rest",produces = "text/plain;charset=UTF-8")
	public String user_name_rest(HttpSession session,Model model)throws Exception {
		String sUserId=(String)session.getAttribute("sUserId");
		User sUser=userService.findUser(sUserId);
		return sUser.getName();
	}
	/*
	 * 회원수정
	 */
	@LoginCheck
	@PostMapping(value = "/user_profile_modify_action_rest",produces = "application/json;charset=UTF-8")
	public User user_profile_modify_action_rest( @ModelAttribute Account account,HttpSession session) throws Exception {
		String loginUserId=(String)session.getAttribute("sUserId");
		User loginUser=userService.findUser(loginUserId);
		
		if(loginUser.getPassword().equals(account.getAccount_pass())) {
			loginUser.setUserId(loginUserId);
			loginUser.setName(account.getAccount_ln()+account.getAccount_fn());
			loginUser.setEmail(account.getAccount_email());
			userService.update(loginUser);
			return loginUser;
		}else {
			return new User();
		}
	}
	/*
	 * 회원가입
	 */
	@PostMapping(value ="/user_write_action_rest" ,produces = "application/json;charset=UTF-8")
	public Map user_write_action_post(@ModelAttribute User user,Model model,HttpServletRequest request) throws Exception{
		
		int result = userService.create(user);
		System.out.println("Controller-->"+result);
		
		String userImagePath=request.getServletContext().getRealPath("img/account/");
		File userImageFileDir = new File(userImagePath);
		String[] userImageFileNameList = userImageFileDir.list();
		boolean isExist=false;
		for (String userImageFileName : userImageFileNameList) {
			if(userImageFileName.equals(user.getUserId()+".png")) {
				isExist=true;
				break;
			}
		}
		if(!isExist) {
			File noNameImageFile=new File(userImagePath+"/noimage.png");
			File userAvaImageFile=new File(userImagePath+"/"+user.getUserId()+".png");
			// 파일복사
			Files.copy(noNameImageFile.toPath(), userAvaImageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		
		HashMap map=new HashMap();
		map.put("result", result);
		map.put("user", user);
		if(result>0) {
			map.put("msg", user.getUserId()+ "님 가입축하드립니다.");
		}else {
			map.put("msg", user.getUserId()+ "는 이미존재하는 아이디입니다.");
		}
		return map;
	}
}
