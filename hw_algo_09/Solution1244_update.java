package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1244_update {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().split(" ");
			String[] sArr = s[0].split("");
			int[] arr = new int[sArr.length];
			for(int i = 0; i < sArr.length; i++) {
				arr[i] = Integer.parseInt(sArr[i]);
			}
			int compare = Integer.parseInt(s[1]);
			int count = 0;
			// sort
			for(int i = 0; i < arr.length-1; i++) {
				int max = i;
				for(int j = arr.length-1; j > i; j--) {
					if(arr[max] < arr[j]) {
						max = j;
					}
				}
				if(i != max) {					
					int temp = arr[i];
					arr[i] = arr[max];
					arr[max] = temp;
					count++;
				}
				if(count == compare) {
					break;
				}
			}
			boolean hasSame = false;
			if(count < compare) {
				for(int i = 0; i < arr.length-1; i++) {
					if(arr[i] == arr[i+1]) {
						hasSame = true;
						break;
					}
				}
				if(!hasSame) {
					if( (compare-count)  % 2 == 1) {
						int temp = arr[arr.length-1];
						arr[arr.length-1] = arr[arr.length-2];
						arr[arr.length-2] = temp;
					}
				}
			}
			count = 0;
			int last = 0;
			int size = compare;
			if(size > arr.length) {
				size = arr.length;
			}
			for(int i = 0; i < size-1; i++) {
				if(arr[i] == arr[i+1]) {
					count++;
					last = i+1;
				}
			}
			if(count != 0) {
				for(int i = arr.length-1; i > arr.length-1-last; i--) { // 5 
					for(int j = arr.length-1-last; j < i; j++) {
						if(arr[i] > arr[j]) {
							int temp = arr[i];
							arr[i] = arr[j];
							arr[j] = temp;
						}
					}
				}
			}
			System.out.print("#" + tc + " ");
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1244_update s1244 = new Solution1244_update();
		s1244.solve();
	}
}
