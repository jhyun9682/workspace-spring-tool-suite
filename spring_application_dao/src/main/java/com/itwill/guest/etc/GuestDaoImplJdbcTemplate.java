package com.itwill.guest.etc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestSQL;

public class GuestDaoImplJdbcTemplate implements GuestDao {
	private JdbcTemplate jdbcTemplate;

	public GuestDaoImplJdbcTemplate() {
		System.out.println("2.#### GuestDaoImpl() 기본생성자호출");
	}

	public GuestDaoImplJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("2.#### GuestDaoImplJdbcTemplate(JdbcTemplate jdbcTemplate) 생성자호출:" + this);
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("3.#### GuestDaoImpl.setJdbcTemplate(JdbcTemplate jdbcTemplate) 메쏘드호출");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		
		List<Guest> guests = 
				jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, new BeanPropertyRowMapper<Guest>(Guest.class));
		ArrayList<Guest> guestList=(ArrayList<Guest>)guests;
		return guestList;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest guest = jdbcTemplate.queryForObject(
				GuestSQL.GUEST_SELECT_BY_NO, 
				new Object[] {no},
				new BeanPropertyRowMapper<Guest>(Guest.class));

		return guest;
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {

		int rowCount = jdbcTemplate.update(
				GuestSQL.GUEST_INSERT, 
				guest.getGuest_name(),
				guest.getGuest_email(),
				guest.getGuest_homepage(),
				guest.getGuest_title(),
				guest.getGuest_content());

		return rowCount;

	}

	@Override
	public int updateGuest(Guest guest) throws Exception {

		int rowCount = jdbcTemplate.update(
				GuestSQL.GUEST_UPDATE,
				guest.getGuest_name(),
				guest.getGuest_email(),
				guest.getGuest_homepage(),
				guest.getGuest_title(),
				guest.getGuest_content(),
				guest.getGuest_no());
		return rowCount;

	}
	@Override
	public int deleteGuest(int no) throws Exception {
		int rowCount = jdbcTemplate.update(GuestSQL.GUEST_DELETE, no);
		return rowCount;
	}
}
