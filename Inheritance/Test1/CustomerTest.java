package kr.or.kh03;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customerLee = new Customer();
		customerLee.bonusPoint = 1000;
		System.out.println(customerLee.showCustomerInfo());
		
		VIPcustomer customerKim = new VIPcustomer(2864, "김유신");
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.showCustomerInfo());
	
	
//		Customer customer = new VIPcustomer(2851, "황인준");	// 업캐스팅 생성가능
//		System.out.println(customer.showCustomerInfo());	// 등급 VIP 출력 가능
//		customer.setAgent();	// Customer 타입으로 들어가서 VIPcustomer의 멤버변수와 메소드 사용불가능
	
	}

}
