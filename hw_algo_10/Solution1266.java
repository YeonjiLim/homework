package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1266 {
	
	public boolean[] prime = new boolean[19];
	public static final long SUB = 1234567891;
	
	public long facto(long num) {
		long result = 1L;
		for(int i = 1; i <= num; i++) {
			result *= i;
			result %= SUB;
		}
		return result;
	}
		
	public long calculate(long base, long exponent, long mod) {
		long result = 1L;
		
		while(exponent > 0) {
			if(exponent % 2 == 1) {
				result = result * base % mod;
			}
			exponent = exponent >> 1;
			base = (base * base) % mod;
		}
		
		return result;
	}
	
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			double a = Double.parseDouble(s[0]);
			double b = Double.parseDouble(s[1]);
			Arrays.fill(prime, true);
			for(int i = 0; i <= 18; i++) {
				if(i <= 1) {
					prime[i] = false;
				}
				if(i > 1) {
					int j = i+i;
					while(j <= 18) {
						prime[j] = false;
						j += i;
					}
				}
			}
			double valueA = 0.0;
			double valueB = 0.0;
			for(int i = 0; i <= 18; i++) {
				if(!prime[i]) {
					long resN = facto(18);
					long resR = facto(i) * facto(18-i) % SUB;
					resR = calculate(resR, SUB-2, SUB) % SUB;
					long result = resN * resR % SUB;
					valueA += result*Math.pow(a/100.0, i)*Math.pow(1.0-(a/100.0), 18-i);
					valueB += result*Math.pow(b/100.0, i)*Math.pow(1.0-(b/100.0), 18-i);
				}
			}
			double result = 1 - (valueA*valueB);
			System.out.printf("#%d %.6f\n", tc, result);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1266 s1266 = new Solution1266();
		s1266.solve();
	}
}
