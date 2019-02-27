package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main1828 {
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		ArrayList<Refri> ref = new ArrayList<>();
		for(int idx = 1; idx <= N; idx++) {
			String[] s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			ref.add(new Refri(start, end));
		}
		
		Collections.sort(ref, new CompareIdx());
		
		int res = 1;
		int idx = 0;
		for(int tmp = idx+1; tmp < N; tmp++) {				
			if(ref.get(idx).start > ref.get(tmp).end) {
				res++;
				idx = tmp;
			}
		}
		
		System.out.println(res);
	}
	
	class CompareIdx implements Comparator<Refri>{

		@Override
		public int compare(Refri o1, Refri o2) {
			return o1.start > o2.start ? -1 : 1;
		}
		
	}
	
	class Refri {
		int start;
		int end;
		public Refri(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main1828 m1828 = new Main1828();
		m1828.solve();
	}
}
