package com.booklib;

public class UserSQL {
	public static final String USER_INSERT = "insert into user_info values (?,?,?,?,?,?,?,?,?)";
	public static final String USER_UPDATE = "update user_info set user_password=?, user_phone=?, user_email=?, user_address=? where user_id=?";
	public static final String USER_DELETE_BY_ID = "delete from user_info where user_id=?";
	public static final String USER_SELECT_ALL = "select * from user_info";
	public static final String USER_SELECT_BY_ID = "select * from user_info where user_id=?";
	
	//public static final String ADDRESS_UPDATE = "update user_info set user_address=? where user_id=?";
	
}
/*
*USER_INSERT*
insert into user_info values ;

/*USER_UPDATE*
update user_info set user_password=?, user_phone=?, user_email=?, user_address=? where user_id=?;

/*USER_DELETE_BY_ID*
delete from user_info where user_id=?;

/*USER_SELECT_ALL*
select * from user_info;

/*USER_SELECT_BY_ID*
select * from user_info where user_id=?;

select * from user_info where user_id='abc';
*
*/

