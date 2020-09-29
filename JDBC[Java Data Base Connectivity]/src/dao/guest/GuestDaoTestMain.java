package dao.guest;

public class GuestDaoTestMain {

	public static void main(String[] args) throws Exception {
		

		GuestDaoImpl gu = new GuestDaoImpl();
		/****************Insert*****************/
		gu.insertGuest(new Guest("돌카스", "2020/08/11", "redtuna@naver.com", "http://dolkas.net", "고추참치", "매콤한 맛 아이 좋아 밥도둑이야"));
		
//		/****************selectByNo*****************/
//		Guest g1 = gu.selectByNo(1);
//		System.out.println(g1);
	}

}
	