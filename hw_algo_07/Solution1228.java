package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution1228 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			String str = br.readLine();
			int pwN = Integer.parseInt(str);
			String[] strArr = br.readLine().split(" ");
			ArrayList<Integer> pwArr = new ArrayList<>();
			for(int i = 0; i < pwN; i++) {
				pwArr.add(Integer.parseInt(strArr[i]));
			}
			str = br.readLine();
			int comN = Integer.parseInt(str);
			strArr = br.readLine().split(" ");
			for(int i = 0; i < strArr.length; i++) {
				if(strArr[i].equals("I")) {
					int idx = Integer.parseInt(strArr[i+1]);
					int item = i+3;
					for(int cnt = 0; cnt < Integer.parseInt(strArr[i+2]); cnt++) {
						pwArr.add(idx, Integer.parseInt(strArr[item]));
						idx++;
						item++;
					}
				}
			}
			System.out.print("#" + tc + " ");
			for(int t = 0; t < 10; t++) {
				System.out.print(pwArr.get(t) + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1228 s1228 = new Solution1228();
		s1228.solve();
	}
}
