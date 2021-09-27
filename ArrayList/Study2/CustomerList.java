package Test2;

import java.util.ArrayList;
import java.util.List;

public class CustomerList {
	private static List<Customer> Customers = new ArrayList<>();
	
	CustomerList(Customer customer){
		Customers.add(customer);
	}
	
	public static List<Customer> getCustomers() {
		return Customers;
	}
}
