package com.ssafy.edu.java;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl productManager = ProductMgrImpl.getInstance();
		productManager.open();
		productManager.print();
		productManager.close();
	}

}
