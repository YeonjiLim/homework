package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1257 {
	
	Set<String> strSet = new HashSet<String>();
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			int K = Integer.parseInt(str);
			str = br.readLine();
			strSet.clear();
			for(int i = 0; i < str.length(); i++) {
				for(int j = i+1; j <= str.length(); j++) {
					strSet.add(str.substring(i, j));
				}
			}
			List<String> strList = new ArrayList<String>();
			strList.addAll(strSet);
			Collections.sort(strList, new CompareStr());
			System.out.println(strList.toString());
			if(K >= strList.size()) {
				System.out.println("#" + tc + " none");
			} else {
				System.out.println("#" + tc + " " + strList.get(K-1));
			}
		}
	}

	class CompareStr implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2) > 0 ? 1 : -1;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		Solution1257 s1257 = new Solution1257();
		s1257.solve();
	}

}
