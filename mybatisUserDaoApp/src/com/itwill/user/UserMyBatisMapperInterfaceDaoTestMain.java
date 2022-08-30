package com.itwill.user;

public class UserMyBatisMapperInterfaceDaoTestMain {

	public static void main(String[] args) throws Exception {
		UserMyBatisMapperInterfaceDao userMyBatisMapperInterfaceDao=new UserMyBatisMapperInterfaceDao();
		System.out.println("1.findUserList:"+userMyBatisMapperInterfaceDao.findUserList());
		System.out.println("2.findUser:"+userMyBatisMapperInterfaceDao.findUser("guard1"));
		User updateUser=userMyBatisMapperInterfaceDao.findUser("guard1");
		updateUser.setEmail("change@change.com");
		updateUser.setName("김변경");
		System.out.println("3.update:"+userMyBatisMapperInterfaceDao.update(updateUser));
		System.out.println("5.create:"+userMyBatisMapperInterfaceDao.create(new User("guard9", "9999", "가드구", "nine@gmail.com")));
		System.out.println("4.remove:"+userMyBatisMapperInterfaceDao.remove("guard9"));
		

	}

}
