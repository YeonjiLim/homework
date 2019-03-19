package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1239 {
	
	// A B C D E F G H
	public static final int[] alpha = {0, 15, 19, 28, 38, 41, 53, 58};
	
	public int check(int num) {
		int number = -1;
		for(int idx = 0; idx < alpha.length; idx++) {
			int cnt = 0;
			int compare = alpha[idx]^num;
			for(int c = 0; c < 6; c++) {
				if((compare & (1 << c)) != 0) {
					cnt++;
				}
			}
			if(cnt < 2) {
				number = idx;
				break;
			}
		}
		return number;
	}
	
	public int strToDec(String str) {
		int sum = 0;
		for(int idx = str.length()-1; idx >= 0; idx--) {
			if(str.charAt(idx) == '1') {
				sum += (1 << (str.length()-1-idx));
			}
		}
		return sum;
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int length = Integer.parseInt(str);
		str = br.readLine().trim();
		int arr[] = new int[length];
		for(int idx = 0; idx < length; idx++) {
			String tmp = str.substring((idx*6), (idx*6)+6);
			int num = strToDec(tmp);
			int secret = check(num);
			arr[idx] = secret;
		}
		boolean notFound = false;
		for(int idx = 0; idx < arr.length; idx++) {
			if(arr[idx] == -1) {
				System.out.println(idx+1);
				notFound = true;
				break;
			}
		}
		if(!notFound) {
			for(int idx = 0; idx < arr.length; idx++) {
				print(arr[idx]);
			}
			System.out.println();
		}
	}
	
	public void print(int secret) {
		switch(secret) {
			case 0:
				System.out.print("A");
				break;
			case 1:
				System.out.print("B");
				break;
			case 2:
				System.out.print("C");
				break;
			case 3:
				System.out.print("D");
				break;
			case 4:
				System.out.print("E");
				break;
			case 5:
				System.out.print("F");
				break;
			case 6:
				System.out.print("G");
				break;
			case 7:
				System.out.print("H");
				break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main1239 m1239 = new Main1239();
		m1239.solve();
	}
}
