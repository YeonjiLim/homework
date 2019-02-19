package com.ssafy.edu.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1251 {
	
	int N;
	public int[] parent;
	public ArrayList<Edge> mst;
	public PriorityQueue<Edge> pq;
	int[] col;
	int[] row;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			str = br.readLine();
			N = Integer.parseInt(str);
			col = new int[N+1];
			row = new int[N+1];
			parent = new int[N+1];
			mst = new ArrayList<>();
			pq = new PriorityQueue<>(new EdgeComparator());
			String[] s = br.readLine().split(" ");
			for(int i = 1; i < N+1; i++) {
				col[i] = Integer.parseInt(s[i-1]);
			}
			s = br.readLine().split(" ");
			for(int i = 1; i < N+1; i++) {
				row[i] = Integer.parseInt(s[i-1]);
			}
			str = br.readLine();
			double E = Double.parseDouble(str);
			for(int i = 1; i < N+1; i++) {
				for(int j = 1; j < N+1; j++) {
					double val = (Math.pow(Math.abs(col[i]-col[j]), 2)+Math.pow(Math.abs(row[i]-row[j]), 2))*E;
					pq.add(new Edge(i, j, val));
				}
			}
			
			kruskal();
			
			double tot = 0.0;
			for(Edge edge:mst) {
				tot += edge.value;
			}
			
			System.out.printf("#%d %.0f\n", tc, tot);
		}
	}
	
	public void kruskal() {
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < N*N; i++) {
			Edge edge = pq.poll();
			if(find(edge.start) == find(edge.end)) {
				continue;
			}
			union(edge.start, edge.end);
			mst.add(edge);
		}
		
	}
	
	public void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		if(p1 != p2) {
			parent[p1] = p2;
		}
	}
	
	public int find(int n) {
		if(parent[n] == n) {
			return n;
		}
		parent[n] = find(parent[n]);
		return parent[n];
	}
	
	class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge e1, Edge e2) {
			return e1.value > e2.value ? 1 : -1;
		}
		
	}
	
	class Edge {
		int start, end;
		double value;
		public Edge(int start, int end, double value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
		
//		@Override
//		public String toString() {
//			return "("+start + "," + end + "," + value +")";
//		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution1251 s1251 = new Solution1251();
		s1251.solve();
	}
}
