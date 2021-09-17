package kr.or.kh02;

public class Customer{
	private int customerId;
	private String customerName;
	private String customerGrade;
	int bonusPoint;
	double bonusRatio;
	

	public Customer(int customerId, String customerName) {
		setCustomerId(customerId);
		setCustomerName(customerName);
		setCustomerGrade("SILVER");
		bonusRatio = 0.01;
	}
	
	public int calcPrice(int price) {
		bonusPoint +=price *bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName + "님의 등급은 " + customerGrade + " 등급이며 보너스포인트는 " + bonusPoint + " point 입니다.";
	}
	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}
}
