package com.itwill.guest;

public class GuestMyBatisDaoTestMain {

	public static void main(String[] args) throws Exception{
		GuestMyBatisDao guestDaoBybatis=new GuestMyBatisDao();
		System.out.println("1.selectAll:"+guestDaoBybatis.selectAll());
		System.out.println("2.selectByNo:"+guestDaoBybatis.selectByNo(150));
		Guest newGuest=new Guest(0, "name", null, "email@korea.com", "www.naver.com", "제목", "내용");
		System.out.println("3.insertGuest:"+guestDaoBybatis.insertGuest(newGuest));
		System.out.println(newGuest);
		Guest guest=guestDaoBybatis.selectByNo(250);
		guest.setGuest_name("김수정");
		guest.setGuest_email("sujung@gmail.com");
		guest.setGuest_date("2022/05/11");
		System.out.println("4.updateGuest:"+guestDaoBybatis.updateGuest(guest));
		System.out.println("5.deleteGuest:"+guestDaoBybatis.deleteGuest(240));
	}

}
