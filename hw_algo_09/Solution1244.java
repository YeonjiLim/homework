package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1244 {
	
	public void solve() throws IOException {
		// 뒤에서부터 탐색하면서 max를 맨앞자리랑 swap, swap시마다 count증가
		// 탐색도중 count가 원하는 만큼 진행되면 정렬이 덜되었어도 멈춤
		// 만약 모든 탐색이 끝났는데 원하는 횟수보다 count가 적다면
		// 1. 연속된 항중에 같은숫자인게 있다면 그냥 지금 그대로가 정답
		// 2. 없다면 마지막 두 항이 가장 작은 두 수이므로 남은 횟수에 따른 두 수의 위치를 바꿔주면됨.
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
					if( (compare/count)  % 2 == 1) {
						int temp = arr[arr.length-1];
						arr[arr.length-1] = arr[arr.length-2];
						arr[arr.length-2] = temp;
					}
				}
			}
			// 마지막 예외처리
			count = 0;
			for(int i = 0; i < (arr.length)/2 - 1; i++) {
				count += 2;
				if(arr[i] == arr[i+1] && count <= compare) {
					if(arr[arr.length-i-2] < arr[arr.length-i-1]) {
						int temp = arr[arr.length-i-1];
						arr[arr.length-i-1] = arr[arr.length-i-2];
						arr[arr.length-i-2] = temp;
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
		Solution1244 s1244 = new Solution1244();
		s1244.solve();
	}
}
