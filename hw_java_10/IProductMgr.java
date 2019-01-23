package com.ssafy.edu.java;

import java.util.ArrayList;

public interface IProductMgr {
	void add(Product product);
	ArrayList<Product> findAll();
	Product findByNo(String no);
	ArrayList<Product> findByName(String name);
	ArrayList<TV> findOnlyTV();
	ArrayList<Refrigerator> findOnlyRefrigerators();
	ArrayList<Refrigerator> findByAboveRefrigerator(int capacity);
	ArrayList<TV> findByAboveTV(int wide);
	
	void updateProduct(String no, int price);
	void deleteProduct(String no);
	
	long ProductsTotalPrice();
	int size();
	
	void open();
	void close();
}
