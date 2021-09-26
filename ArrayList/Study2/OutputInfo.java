package Test2;

import java.util.List;

public class OutputInfo {
	
	OutputInfo(){
		System.out.print("번호"+ "\t\t");
		System.out.print("이름"+ "\t\t");
		System.out.print("전화번호"+ "\t\t");
		System.out.println("이메일주소");
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
