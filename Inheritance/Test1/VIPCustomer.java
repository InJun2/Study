package kr.or.kh02;

public class VIPCustomer extends Customer{
	private int agentId;
	private double salesRadio;
	private static int agentNum=1000;
	
	public VIPcustomer() {
		super();
		setCustomerGrade("VIP");
		setBonusRatio(0.05);
		setSalesRadio(0.1);
		System.out.println("VIPCustomer() 생성자 호출");
	}
	public VIPCustomer(int customerId, String customerName) {
		super(customerId, customerName);
		setCustomerGrade("VIP");
		setBonusRatio(0.05);
		setSalesRadio(0.1);
		System.out.println("VIPCustomer(int,String) 생성자 호출");
	}
	
	public int calcPrice(int price) {
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	}	// 부모클래스와 구현할 내용이 다를경우 오버라이딩해서 가져오고 수정할 수 있음
	
	public void setAgent() {
		this.agentID=agentNum++;
	}
	
	public int getAgentId() {
		return agentId;
	}

	public double getSalesRadio() {
		return salesRadio;
	}

	public void setSalesRadio(double salesRadio) {
		this.salesRadio = salesRadio;
	}

}
