package Test2;

import java.util.List;

public class OutputInfo {
	
	OutputInfo(){
		System.out.print("��ȣ"+ "\t\t");
		System.out.print("�̸�"+ "\t\t");
		System.out.print("��ȭ��ȣ"+ "\t\t");
		System.out.println("�̸����ּ�");
	}
	
	protected static void OutputCustomerInfo(List list){
		List<Customer> Customerlist = list;
		for(Customer customer : Customerlist) {
			System.out.print(customer.getCustomerNum()+ "\t\t");
			System.out.print(customer.getCustomerName()+ "\t\t");
			System.out.print(customer.getCustomerTel()+ "\t");
			System.out.println(customer.getCustomerEmail());
		}
	}
}
