package Test2;

public class MainTest {
	
	public static void main(String[] args) {
		new InputInfo();
		new OutputInfo();
		OutputInfo.OutputCustomerInfo(CustomerList.getCustomers());
	}

}
