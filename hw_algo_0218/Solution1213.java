package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1213 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 10; tc++) {
			String str = br.readLine();
			int T = Integer.parseInt(str);
			String s = br.readLine();
			String sl = br.readLine();
			int count = 0;
			for(int i = 0; i < sl.length()-s.length()+1; i++) {
				if(s.equals(sl.substring(i, i+s.length()))) {
					count++;
				}
			}
			System.out.println("#" + tc + " " + count);
		}
		
	}

	public static void main(String[] args) throws IOException {
		Solution1213 s1213 = new Solution1213();
		s1213.solve();
	}

}
