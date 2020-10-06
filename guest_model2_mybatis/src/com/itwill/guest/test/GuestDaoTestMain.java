package com.itwill.guest.test;

import java.util.ArrayList;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestDaoImplMyBatis;
import com.itwill.guest.GuestDaoImplMyBatisMapperInterface;

public class GuestDaoTestMain {

	public static void main(String[] args)throws Exception {
//		GuestDao guestDao=new GuestDaoImplMyBatis();
//		System.out.println(guestDao.selectAll());
//		System.out.println("1.insert");
//		System.out.println(guestDao
//				.insertGuest(
//						new Guest(-9090, "이름", null, "이메일", "홈페이지", "타이틀", "내용")));
//		
//		Guest guest=guestDao.selectByNo(4);
//		guest.setGuest_name("김변경");
//		System.out.println("2.update");
//		System.out.println(guestDao.updateGuest(guest));
		
		
		//System.out.println(guestDao.selectByNo(63)); 테스트 완료
		//System.out.println(guestDao.selectAll()); 테스트 완료
		//guest_date 가 db에 not null로 되있어서 null, "" 이건 안되는건 알겠는데 "sysdate"가 안되는 이유는 뭔가여??;;
		//Guest test1 = new Guest(-9000, "칠공팔", "2020-09-21", "708@gmail.com", "http://", "졸리당", "현재시간 7시8부..이 아니라 9분");
		//System.out.println(guestDao.insertGuest(test1));
		//Guest test2 = new Guest(-9000, "구삼로", null, "935@gmail.com", "http://", "졸리당", "현재시간 7시8부..이 아니라 9분");
		//System.out.println(guestDao.insertGuest(test2));
//		Guest test3 = new Guest(-9000, "일공이", null, "102@gmail.com", "http://", "졸리당", "현재시간 7시8부..이 아니라 9분");
//		System.out.println(guestDao.insertGuest(test3));
//		Guest guest = guestDao.selectByNo(1);
//		guest.setGuest_content("호로롤ㄹ로롤로롤");
//		System.out.println(guestDao.updateGuest(guest));
		System.out.println("----------------------------------------------------------------------------");
//		System.out.println("지운당:"+guestDao.deleteGuest(4));
		GuestDao guestDao = new GuestDaoImplMyBatisMapperInterface();
		//1. selectById 확인
		//Guest guest = guestDao.selectByNo(5);
		//System.out.println(guest);
		//2. selectAll 확인
		ArrayList<Guest> findList = guestDao.selectAll();
		System.out.println(findList);
		//3. insertGuest 확인
//		Guest insertGuest = new Guest(-9000,"김추석",null,"cu@gmail.com","http://","믱믱","으앙 오후 5시당 으히히히");
//		int insert = guestDao.insertGuest(insertGuest);
//		System.out.println("추가되면 1이 출력되지렁: "+insert);
		//4.update 확인
//		Guest findGuest = guestDao.selectByNo(21);
//		System.out.println(findGuest);
//		findGuest.setGuest_content("냉장고를 열어봐라 고추참치 꺼내먹어라~~~~~");
//		int update =guestDao.updateGuest(findGuest);
//		System.out.println("업뎃되면 1이 출력되지렁:" + update);
		//5. delete 확인
//		int delete = guestDao.deleteGuest(21);
//		System.out.println("삭제되면 1이 출력되지렁: "+delete);
		
	}	

}
