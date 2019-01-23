package com.ssafy.edu.java;

public class Product {
	private String no;
	private String name;
	private int price ;
	private int amount;
	public Product() {
		super();
	}
	public Product(String no, String name, int price, int amount) {
		super();
		this.no = no;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return no + "\t " + name + "\t " + price + "\t " + amount;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + amount;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((no == null) ? 0 : no.hashCode());
//		result = prime * result + price;
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		Product p = (Product) obj;
//		if(this.no.equals(p.getNo()) && this.name.equals(p.getName()) && this.price == p.getPrice() && this.amount == p.getAmount()) {
//			return true;
//		}else {
//			return false;
//		}
//	}
}
