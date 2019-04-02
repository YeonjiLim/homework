package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2577 {
	
	public int N, d, k, c;
	public int[] arr;
	public int[] check;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split(" ");
		N = Integer.parseInt(s[0]);
		d = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);
		c = Integer.parseInt(s[3]);
		arr = new int[N+k];
		check = new int[d+1];
		for(int i = 0; i < N; i++) {
			String str = br.readLine().trim();
			arr[i] = Integer.parseInt(str);
		}
		for(int i = N; i < arr.length; i++) {
			arr[i] = arr[i-N];
		}
		int res = 0;
		int cnt = 0;
		for(int i = 0; i < N+k; i++) {
			if(i >= k) {
				if(check[c] == 0) {
					cnt++;
					if(res < cnt) {
						res = cnt;
					}
					cnt--;
				} else {
					if(res < cnt) {
						res = cnt;
					}
				}
				if(res == k+1) {
					break;
				}
				check[arr[i-k]]--;
				if(check[arr[i-k]] == 0) {
					cnt--;
				}
			}
			
			if(check[arr[i]] == 0) {
				check[arr[i]]++;
				cnt++;
			} else {
				check[arr[i]]++;
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) throws IOException {
		Main2577 m2577 = new Main2577();
		m2577.solve();
	}
}
