package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1053 {
	
	public static final int mod = 10000;
	
	public int[][] multiple(int[][] first, int[][] second) {
		int[][] result = new int[2][2];
		result[0][0] = ((first[0][0]*second[0][0])%mod + (first[0][1]*second[1][0])%mod)%mod;
		result[0][1] = ((first[0][0]*second[0][1])%mod + (first[0][1]*second[1][1])%mod)%mod;
		result[1][0] = ((first[1][0]*second[0][0])%mod + (first[1][1]*second[1][0])%mod)%mod;
		result[1][1] = ((first[1][0]*second[0][1])%mod + (first[1][1]*second[1][1])%mod)%mod;
		return result;
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		while(!(str = br.readLine()).equals("-1")) {
			long number = Long.parseLong(str);
			
			int[][] basic = {
					{1, 0},
					{0, 1}
			};
			
			int[][] power = {
					{1, 1},
					{1, 0}
			};
			
			while(number > 0) {
				if(number % 2 == 1) {
					basic = multiple(basic, power);
				}
				power = multiple(power, power);
				number /= 2;
			}
			
			System.out.println(basic[0][1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main1053 m1053 = new Main1053();
		m1053.solve();
	}
}
