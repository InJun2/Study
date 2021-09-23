package kr.or.kh02;

public class CustomerTest {

public static void main(String[] args) {
		Customer customerLee = new Customer();
		System.out.println(customerLee.getCustomerName()+"님의 "+customerLee.calcPrice(100000)+"원 계산 후 정보");
		System.out.println(customerLee.showCustomerInfo());
		
		VIPcustomer customerKim = new VIPcustomer(2864, "김유신");
		System.out.println(customerKim.getCustomerName()+"님의 "+customerKim.calcPrice(100000)+"원 계산 후 정보");
		System.out.println(customerKim.showCustomerInfo());

		Customer customer = new VIPcustomer(2851, "황인준");	// 업캐스팅 생성가능
//		customer.setAgent();	//error : Customer 타입으로 들어가서 VIPcustomer의 멤버변수와 메소드 사용불가능
		System.out.println(customer.getCustomerName()+"님의 "+customer.calcPrice(100000)+"원 계산 후 정보");
									// Override를 이용하여 VIPcustomer의 calcPrice 메소드를 가상으로 사용
		System.out.println(customer.showCustomerInfo());	// 등급 VIP 출력 가능
	}

}
