package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itwill.guest.mapper.GuestMapper;

public class GuestDaoImplMyBatisMapperInterface implements GuestDao{
	private GuestMapper guestMapper;
	public GuestDaoImplMyBatisMapperInterface() {
		System.out.println("#### GuestDaoImplMyBatisMapperInterface()기본생성자");
	}
	@Override
	public List<Guest> selectAll() throws Exception {
		return null;
	}
	@Override
	public Guest selectByNo(int no) throws Exception {
		return null;
	}
	@Override
	public int insertGuest(Guest guest) throws Exception {
		return 0;
	}
	@Override
	public int updateGuest(Guest guest) throws Exception {
		return 0;
	}
	@Override
	public int deleteGuest(int no) throws Exception {
		return 0;
	}
}
