package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2819 {
	
	// up, right, down, left
	public int[] rpos = {-1, 0, 1, 0};
	public int[] cpos = {0, 1, 0, -1};
	
	public int[] num = new int[7];
	
	public Set<String> sset = new HashSet<String>();
	
	public void dfs(int[][] map, int row, int col, int depth, int[] num) {
		num[depth] = map[row][col];
		depth++;
		if(depth == num.length) {
			String strN = "";
			for(int i = 0; i < num.length; i++) {
				strN += num[i];
			}
			sset.add(strN);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(row+rpos[i] >= 0 && row+rpos[i] < 4 && col+cpos[i] >= 0 && col+cpos[i] < 4) {
				dfs(map, row+rpos[i], col+cpos[i], depth, num);
			}
		}
		
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			int[][] map = new int[4][4];
			for(int r = 0; r < 4; r++) {
				String[] s = br.readLine().split(" ");
				for(int c = 0; c < 4; c++) {
					map[r][c] = Integer.parseInt(s[c]);
				}
			}
			sset.clear();
			Arrays.fill(num, -1);
			for(int r = 0; r < 4; r++) {
				for(int c = 0; c < 4; c++) {
					dfs(map, r, c, 0, num);
				}
			}
			System.out.println("#" + tc + " " + sset.size());
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution2819 s2819 = new Solution2819();
		s2819.solve();
	}

}
