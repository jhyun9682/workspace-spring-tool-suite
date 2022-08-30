package com.itwill.user;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserMyBatisDao {
	public static final String NAMESPACE = "com.itwill.user.mapper.UserMapper.";
	private SqlSessionFactory sqlSessionFactory;

	public UserMyBatisDao() {
		try {
			InputStream myBatisConfigInputStream = Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(myBatisConfigInputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public int create(User user) throws Exception {
		return sqlSessionFactory.openSession(true).insert(NAMESPACE + "create", user);
	}


	public int update(User user) throws Exception {
		return sqlSessionFactory.openSession(true).update(NAMESPACE + "update", user);
	}

	
	public int remove(String userId) throws Exception {
		return sqlSessionFactory.openSession(true).delete(NAMESPACE + "remove", userId);
	}

	
	public User findUser(String userId) throws Exception {
		return sqlSessionFactory.openSession(true).selectOne(NAMESPACE + "findUser", userId);
	}

	
	public ArrayList<User> findUserList() throws Exception {
		List<User> users = sqlSessionFactory.openSession(true).selectList(NAMESPACE + "findUserList");
		ArrayList<User> userList = (ArrayList<User>) users;
		return userList;
	}

	
	public boolean existedUser(String userId) throws Exception {
		int count = sqlSessionFactory.openSession(true).selectOne(NAMESPACE + "existedUser", userId);
		if (count == 1) {
			return true;
		} else {
			return false;
		}
	}

}
