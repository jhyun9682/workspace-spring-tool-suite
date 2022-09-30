package com.booklib.DAO;

import java.util.List;

import com.booklib.DTO.User2;

public interface UserDao2 {
	
	//회원가입
	int insertUser(User2 user) throws Exception;
	
	//회원검색
	User2 selectByUserId(String user_id) throws Exception;
	
	//회원검색
	List<User2> selectAll() throws Exception;
	
	//정보수정
	int updateUser(User2 user) throws Exception;
	
	//회원탈퇴
	int deleteUser(User2 user) throws Exception;
	
	
	//로그인?
	
	
	
	
	

}
