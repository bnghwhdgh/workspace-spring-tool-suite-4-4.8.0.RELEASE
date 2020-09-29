package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception {
		AddressDao2 addressDao2 = new AddressDao2();
		System.out.println("1.insert");
		addressDao2.create("JIM","레이너","999-5656","히페리온");
		addressDao2.create("Dolkas","돌카스","156-7564","고추참치");
		
		System.out.println("2.update");
		addressDao2.update("JIM","캐리건","111-0924","군단",13);
//		
		System.out.println("3.delete");
		addressDao2.delete(13);
//		
		System.out.println("4.selectByNo");
		addressDao2.selectByNo(22);
//		
		System.out.println("5.selectAll");
		addressDao2.selectAll();

	}

}
