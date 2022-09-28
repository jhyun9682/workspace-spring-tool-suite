package com.booklib.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.booklib.UserSQL;
import com.booklib.DTO.User;


public class UserDaoImpl implements UserDao{
	@Autowired
	private DataSource dataSource;
	
	public UserDaoImpl() throws Exception{
		
	}
	public DataSource getdataSource(){
		return dataSource;
		
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//회원가입
	@Override
	public int insertUser(User user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_INSERT);
		pstmt.setString(1,user.getUser_id());
		pstmt.setString(2,user.getUser_name());
		pstmt.setString(3,user.getUser_password());
		pstmt.setString(4,user.getUser_email());
		pstmt.setString(5,user.getUser_birth());
		pstmt.setString(6,user.getUser_gender());
		pstmt.setString(7,user.getUser_phone());
		pstmt.setString(8,user.getUser_address());
		pstmt.setInt(9,user.getCategory_no());
		int insertRowCount=pstmt.executeUpdate();
		con.close();
		return insertRowCount;
	}
	
	//회원검색_아이디
	/*
	@Override
	public User selectByUserId(String user_id) throws Exception {
		User user=null;
		Connection con = 
				dataSource.getConnection();
		PreparedStatement pstmt=
				con.prepareStatement(UserSQL.USER_SELECT_BY_ID);
		pstmt.setString(1, user_id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			user=new User(rs.getString("user_id"),
					rs.getString("user_password"),
					rs.getString("user_email"),
					rs.getString("user_birth"),
					rs.getString("user_gender"),
					rs.getString("user_phone"),
					rs.getString("user_address"),
					rs.getString("user_qr"),
					rs.getString("user_rental_status"),
					rs.getInt("user_book_cnt_limit"),
					rs.getInt("user_book_weight"),
					rs.getInt("category_no"));
			
					
		}
		con.close();
		return user ;
		
	}
	*/
	/*
	@Override
	public ArrayList<User> selectAll() throws Exception {
		ArrayList<User> userList=new ArrayList<User>();
		Connection con = 
				dataSource.getConnection();
		PreparedStatement pstmt=
				con.prepareStatement(UserSQL.USER_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		while (rs.next()) {
			userList.add(new User(rs.getString("user_id"),
					rs.getString("user_password"),
					rs.getString("user_email"),
					rs.getString("user_birth"),
					rs.getString("user_gender"),
					rs.getString("user_phone"),
					rs.getString("user_address"),
					rs.getString("user_qr"),
					rs.getString("user_rental_status"),
					rs.getInt("user_book_cnt_limit"),
					rs.getInt("user_book_weight"),
					rs.getInt("category_no")
					));
			
		}
		con.close();
		return userList;
	}
		*/
		
		//정보수정
	@Override
	public int updateUser(User user) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL.USER_UPDATE);
		pstmt.setString(1,user.getUser_id());
		pstmt.setString(2,user.getUser_name());
		pstmt.setString(3,user.getUser_password());
		pstmt.setString(4,user.getUser_email());
		pstmt.setString(5,user.getUser_birth());
		pstmt.setString(6,user.getUser_gender());
		pstmt.setString(7,user.getUser_phone());
		pstmt.setString(8,user.getUser_address());
		pstmt.setInt(9,user.getCategory_no());
		int updateRowCount=pstmt.executeUpdate();
		con.close();
		return updateRowCount;
	}
	
	@Override
	public int deleteUser(User user) throws Exception {
		
	}
	
}
