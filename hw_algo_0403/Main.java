package kr.co.jungol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	public int[] parent;
	public boolean[] visited;
	public ArrayList<Edge> mst;
	public ArrayList<Edge> pq;
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int V = Integer.parseInt(s[0]);
		int E = Integer.parseInt(s[1]);
		
		parent = new int[V+1];
		visited = new boolean[V+1];
		mst = new ArrayList<>();
		pq = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			s = br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int end = Integer.parseInt(s[1]);
			int value = Integer.parseInt(s[2]);
			pq.add(new Edge(start, end, value));
		}
		Collections.sort(pq, new EdgeComparator());
		kruskal(V, E);
		long result = 0L;
		for(Edge edge:mst) {
			result += edge.value;
		}
		System.out.println(result);
	}
	
	public void kruskal(int V, int E) {
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < E; i++) {
			Edge edge = pq.get(i);
			if(find(edge.start) == find(edge.end)) {
				continue;
			}
			union(edge.start, edge.end);
			mst.add(edge);
		}
	}
	
	public int find(int n) {
		if(parent[n] == n) {
			return n;
		}
		parent[n] = find(parent[n]);
		return parent[n];
	}
	
	public void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) {
			parent[p1] = p2;
		}
	}
	
	class EdgeComparator implements Comparator<Edge> {

		@Override
		public int compare(Edge o1, Edge o2) {
			return o1.value < o2.value ? 1 : -1;
		}
		
	}
	
	class Edge {
		int start, end, value;
		public Edge(int start, int end, int value) {
			this.start = start;
			this.end = end;
			this.value = value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main s3124 = new Main();
		s3124.solve();
	}
}