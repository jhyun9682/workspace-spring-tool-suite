package com.itwill.user;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserMyBatisMapperInterfaceDao {
	
	private SqlSessionFactory sqlSessionFactory;

	public UserMyBatisMapperInterfaceDao() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(myBatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int create(User user) throws Exception {
		return 0;
	}


	public int update(User user) throws Exception {
		return 0;
	}

	
	public int remove(String userId) throws Exception {
		return 0;
	}

	
	public User findUser(String userId) throws Exception {
		return null;
	}

	
	public List<User> findUserList() throws Exception {
		
		return null;
	}

	
	public boolean existedUser(String userId) throws Exception {
			return true;
	}

}
