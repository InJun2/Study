package kr.or.kh03;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customerLee = new Customer();
		customerLee.bonusPoint = 1000;
		System.out.println(customerLee.showCustomerInfo());
		
		VIPcustomer customerKim = new VIPcustomer(2864, "������");
		customerKim.bonusPoint = 10000;
		System.out.println(customerKim.showCustomerInfo());
	
	
//		Customer customer = new VIPcustomer(2851, "Ȳ����");	// ��ĳ���� ��������
//		System.out.println(customer.showCustomerInfo());	// ��� VIP ��� ����
//		customer.setAgent();	// Customer Ÿ������ ���� VIPcustomer�� ��������� �޼ҵ� ���Ұ���
	
	}

}
