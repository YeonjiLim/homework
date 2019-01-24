package com.ssafy.edu.java;

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		ProductMgrImpl productManager = ProductMgrImpl.getInstance();
		productManager.add(new TV("NT001", "TV001", 50000000, 3, 55));
		productManager.add(new TV("NT002", "TV002", 60000000, 2, 60));
		productManager.add(new TV("NT003", "TV003", 70000000, 4, 65));
		productManager.add(new TV("NT004", "TV004", 80000000, 1, 70));
		productManager.add(new Refrigerator("NR001", "RFI001", 5500000, 2, 600));
		productManager.add(new Refrigerator("NR002", "RFI002", 6500000, 1, 700));
		productManager.add(new Refrigerator("NR003", "RFI003", 7500000, 3, 800));
		productManager.add(new Refrigerator("NR004", "RFI004", 8500000, 4, 900));
		
		ArrayList<Product> proArr = productManager.findAll();
		productManager.saveObj("product.txt", proArr);
		
		ArrayList<Product> products = productManager.openObj("product.txt");
		for(Product p : products) {
			System.out.println(p);
		}
	}

}
