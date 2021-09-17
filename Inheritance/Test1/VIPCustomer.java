package kr.or.kh02;

public class VIPCustomer extends Customer{
	private int agentId;
	private double salesRadio;
	
	public VIPCustomer(int customerId, String customerName) {
		super(customerId, customerName);
		setCustomerGrade("VIP");
		setBonusRatio(0.05);
		setSalesRadio(0.1);
		
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
