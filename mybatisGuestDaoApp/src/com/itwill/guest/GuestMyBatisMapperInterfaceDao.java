package com.itwill.guest;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GuestMyBatisMapperInterfaceDao{
	
	private SqlSessionFactory sqlSessionFactory;
	public GuestMyBatisMapperInterfaceDao() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			this.sqlSessionFactory=new SqlSessionFactoryBuilder().build(myBatisConfigInputStream);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int insertGuest(Guest guest) throws Exception {
		return 0;
	}
	
	public Guest selectByNo(int no) throws Exception {
		return null;
	}

	
	public ArrayList<Guest> selectAll() throws Exception {
		
		return null;
	}

	
	public int updateGuest(Guest guest) throws Exception {
		return 0;
	}

	
	public int deleteGuest(int no) throws Exception {
		return 0;
	}

}
