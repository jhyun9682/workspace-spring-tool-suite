package com.itwill.user;

public class UserMyBatisDaoTestMain {

	public static void main(String[] args) throws Exception {
		UserMyBatisDao userDaoMyBatis=new UserMyBatisDao();
		System.out.println("1.findUserList:"+userDaoMyBatis.findUserList());
		System.out.println("2.findUser:"+userDaoMyBatis.findUser("guard1"));
		User updateUser=userDaoMyBatis.findUser("guard1");
		updateUser.setEmail("change@change.com");
		updateUser.setName("김변경");
		System.out.println("3.update:"+userDaoMyBatis.update(updateUser));
		System.out.println("5.create:"+userDaoMyBatis.create(new User("guard9", "9999", "가드구", "nine@gmail.com")));
		System.out.println("4.remove:"+userDaoMyBatis.remove("guard9"));
		

	}

}
