package com.booklib.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.booklib.UserSQL2;
import com.booklib.DTO.User2;


public class UserDaoImpl2 implements UserDao2{
	@Autowired
	private DataSource dataSource;
	
	public UserDaoImpl2() throws Exception{
		
	}
	public DataSource getdataSource(){
		return dataSource;
		
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	//회원가입
	@Override
	public int insertUser(User2 user) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL2.USER_INSERT);
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
	public int updateUser(User2 user) throws Exception {
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(UserSQL2.USER_UPDATE);
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
	public int deleteUser(User2 user) throws Exception {
		
		return 0;
	}
	@Override
	public User2 selectByUserId(String user_id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<User2> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
