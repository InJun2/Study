package Test2;

public class Customer {
	private static int StaticNum=1001;
	private String CustomerName;
	private String CustomerTel;
	private String CustomerEmail;
	private int CustomerNum;
	
	Customer(String name,String tel, String email){
		this.CustomerName = name;
		this.CustomerTel = tel;
		this.CustomerEmail = email;
		this.CustomerNum=StaticNum++;
	}

	public int getCustomerNum() {
		return CustomerNum;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public String getCustomerTel() {
		return CustomerTel;
	}

	public String getCustomerEmail() {
		return CustomerEmail;
	}
		
	
}
