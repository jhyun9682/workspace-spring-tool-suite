package com.booklib.DAO;

import java.util.List;

import com.booklib.DTO.User;

public interface UserDao {
	
	//회원가입
	int insertUser(User user) throws Exception;
	
	//회원검색
	User selectByUserId(String user_id) throws Exception;
	
	//회원검색
	List<User> selectAll() throws Exception;
	
	//정보수정
	int updateUser(User user) throws Exception;
	
	//회원탈퇴
	int deleteUser(User user) throws Exception;
	
	
	//로그인?
	
	
	
	
	

}
