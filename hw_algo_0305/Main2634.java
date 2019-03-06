package kr.co.jungol;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Scanner;

public class Main2634 {
	
	// 좌표의 최대값
	public static final int MAX = 1000000000;
	public int M, N, L;
	
	public HashMap<Integer, Integer> mRange;
	
	// 시작 사대, 최대사정거리, 오른쪽으로 가야하는 수
	public void makeUpField(int M, int L, int r) {
		int range = 1;
		while(range <= r) {
			mRange.put(M+range, L-range);
			range++;
		}

	}
	
	public void makeDownField(int M, int L, int r) {
		int range = 1;
		while(range <= r) {
			mRange.put(M-range, L-range);
			range++;
		}
	}
	
	public void solve() throws IOException {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 사대의 수
		N = sc.nextInt(); // 동물의 수
		L = sc.nextInt(); // 사정거리
		ArrayList<Integer> mList = new ArrayList<>();
		mRange = new HashMap<Integer, Integer>();
		for(int i = 0; i < M; i++) {
			int kl = sc.nextInt();
			mRange.put(kl, L); // 일단 처음받는건 다 넣어도됨 
			mList.add(kl);
		}
		
		Collections.sort(mList);
		
		for(int i = 0; i < mList.size(); i++) {
			if(i < mList.size()-1) {
				makeUpField(mList.get(i), L, (mList.get(i+1)-mList.get(i))/2);
			}
			if(i > 0) {
				makeDownField(mList.get(i), L, (mList.get(i)-mList.get(i-1))/2);
			}
			if(i == 0) {
				if(mList.get(i)-L >= 0) {
					makeDownField(mList.get(i), L, L);
				} else {
					makeDownField(mList.get(i), L, mList.get(i));
				}
			}
			if(i == mList.size()-1) {
				if(mList.get(i)+L < MAX) {
					makeUpField(mList.get(i), L, L);
				} else {
					makeUpField(mList.get(i), L, MAX-mList.get(i));
				}
			}
		}
//		
//		Iterator<Integer> it = mRange.keySet().iterator();
//		while(it.hasNext()) {
//			int kk = it.next();
//			System.out.println("키:" + kk + ",밸류:" + mRange.get(kk));
//		}
//		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int k = sc.nextInt();
			int v = sc.nextInt();
			if(mRange.containsKey(k)) {
				if(mRange.get(k) >= v) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static void main(String[] args) throws IOException {
		Main2634 m2634 = new Main2634();
		m2634.solve();
	}
}
