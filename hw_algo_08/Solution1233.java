package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1233 {
	
	public static final String sign = "+-/*";
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			String str = br.readLine();
			int n = Integer.parseInt(str);
			boolean isM = true;
			for(int i = 1; i < n+1; i++) {
				String[] s = br.readLine().split(" ");
				if(isM) {
					if(s.length % 2 == 1) {
						isM = false;
					}
					if(s.length > 2 && !sign.contains(s[1])) {
						isM = false;
					}
					if(s.length == 2 && sign.contains(s[1])) {
						isM = false;
					}
				}
			}
			if(isM) {				
				System.out.println("#" + tc + " 1");
			} else {
				System.out.println("#" + tc + " 0");
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Solution1233 s1233 = new Solution1233();
		s1233.solve();
	}
}
