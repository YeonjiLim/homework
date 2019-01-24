package com.ssafy.edu.java;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProductMgrImpl implements IProductMgr{

	private static ProductMgrImpl productImpl;
	private ProductMgrImpl() {
	}
	public static ProductMgrImpl getInstance() {
		if(productImpl==null) {
			productImpl=new ProductMgrImpl();
		}
		return productImpl;
	}
	//---------------------위 싱글턴
	private ArrayList<Product> arrayProducts = new ArrayList<>();
	//------- ProductManagerImpl <> -----> Product  aggregation
	@Override
	public void add(Product product) {
		for(int i = 0; i < arrayProducts.size(); i++) {
			if(arrayProducts.get(i).getNo().equals(product.getNo())) {
				try {
					throw new DuplicateException();
				} catch (DuplicateException e) {
					System.out.println(e);
				}
				return;
			}
		}
		arrayProducts.add(product);
	}
	
	@Override
	public ArrayList<Product> findAll() {
		return arrayProducts;
	}
	@Override
	public Product findByNo(String no) {
		Product findP = null;
		for(Product p : arrayProducts) {
			if(p.getNo().equals(no)) {
				findP = p;
			}
		}
		if(findP == null) {
			try {
				throw new CodeNotFoundException();
			} catch (CodeNotFoundException e) {
				System.out.println(e);
			}
		}
		return findP;
	}
	@Override
	public ArrayList<Product> findByName(String name) {
		ArrayList<Product> arrP = new ArrayList<Product>();
		for(Product p : arrayProducts) {
			if(p.getName().contains(name)) {
				arrP.add(p);
			}
		}
		return arrP;
	}
	@Override
	public ArrayList<TV> findOnlyTV() {
		ArrayList<TV> arrTV = new ArrayList<TV>();
		for(Product t : arrayProducts) {
			if(t instanceof TV) {
				arrTV.add((TV) t);
			}
		}
		return arrTV;
	}
	@Override
	public ArrayList<Refrigerator> findOnlyRefrigerators() {
		ArrayList<Refrigerator> arrR = new ArrayList<Refrigerator>();
		for(Product r : arrayProducts) {
			if(r instanceof Refrigerator) {
				arrR.add((Refrigerator) r);
			}
		}
		return arrR;
	}
	@Override
	public ArrayList<Refrigerator> findByAboveRefrigerator(int capacity) {
		ArrayList<Refrigerator> arrR = new ArrayList<Refrigerator>();
		for(Product r : arrayProducts) {
			if(r instanceof Refrigerator && ((Refrigerator)r).getCapacity() > capacity) {
				arrR.add((Refrigerator)r);
			}
		}
		if(arrR.isEmpty()) {
			try {
				throw new ProductNotFoundException();
			} catch (ProductNotFoundException e) {
				System.out.println(e);
			}
		}
		return arrR;
	}
	@Override
	public ArrayList<TV> findByAboveTV(int wide) {
		ArrayList<TV> arrTV = new ArrayList<TV>();
		for(Product t : arrayProducts) {
			if(t instanceof TV && ((TV)t).getWide() > wide) {
				arrTV.add((TV)t);
			}
		}
		if(arrTV.isEmpty()) {
			try {
				throw new ProductNotFoundException();
			} catch (ProductNotFoundException e) {
				System.out.println(e);
			}
		}
		return arrTV;
	}
	
	@Override
	public void updateProduct(String no, int price) {
		for(int i = 0; i < arrayProducts.size(); i++) {
			if(arrayProducts.get(i).getNo().equals(no)) {
				arrayProducts.get(i).setPrice(price);
			}
		}
	}
	@Override
	public void deleteProduct(String no) {
		for(Product pList : arrayProducts){
			if(pList.getNo().equals(no)) {
				arrayProducts.remove(pList);
				break;
			}
		}
	}
	@Override
	public long ProductsTotalPrice() {
		int sum = 0;
		for(Product pList : arrayProducts) {
			sum += (pList.getPrice()*pList.getAmount());
		}
		return sum;
	}
	@Override
	public int size() {
		return arrayProducts.size();
	}
	@Override
	public ArrayList<Product> openObj(String fname) {
		ArrayList<Product> products = new ArrayList<Product>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream(fname);
			ois = new ObjectInputStream(fis);
			
			int count = ois.readInt();
			for(int i = 0; i < count; i++) {
				Product pp = (Product) ois.readObject();
				products.add(pp);
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} 
		return products;
	}
	
	@Override
	public void saveObj(String fname, ArrayList<Product> products) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream(fname, false);
			oos = new ObjectOutputStream(fos);
			oos.writeInt(arrayProducts.size());
			for(Product p : arrayProducts) {
				oos.writeObject(p);
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
		
	}
}
