package com.pizza.vo;

public class PizzaModel {
	private String pizza;
	private String[] topping;
	private String[] side;
	private String orderResult;
	
	public PizzaModel(String pizza, String[] topping, String[] side, String orderResult) {
		this.pizza = pizza;
		this.topping = topping;
		this.side = side;
		this.orderResult = orderResult;
	}

	public String getPizza() {
		return pizza;
	}

	public void setPizza(String pizza) {
		this.pizza = pizza;
	}

	public String[] getTopping() {
		return topping;
	}

	public void setTopping(String[] topping) {
		this.topping = topping;
	}

	public String[] getSide() {
		return side;
	}

	public void setSide(String[] side) {
		this.side = side;
	}

	public String getOrderResult() {
		return orderResult;
	}

	public void setOrderResult(String orderResult) {
		this.orderResult = orderResult;
	}
	
}
