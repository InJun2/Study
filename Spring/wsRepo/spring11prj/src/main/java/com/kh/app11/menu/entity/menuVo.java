package com.kh.app11.menu.entity;

public class menuVo {
	private String menu;
	private int price;
	
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String toString() {
		return "menu : + " + menu +  " price : " + price;
	}
}
