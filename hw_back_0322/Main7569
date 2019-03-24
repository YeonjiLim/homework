import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public int M, N, H; // 가로, 세로, 쌓이는 상자 개수
	
	// 2차원에서 up, right, down, left
	public int[] moveR = {-1, 0, 1, 0};
	public int[] moveC = {0, 1, 0, -1};
	
	public int[][] box;
	public ArrayList<int[][]> boxes;
	
	public boolean[][] visited;
	public ArrayList<boolean[][]> visitList;
	
	public Queue<Position> queue;
	
	public int res;
	
	public Position top;
	
	public void searchZero(Position temp) {
		visitList.get(temp.height)[temp.row][temp.col] = true;
		boxes.get(temp.height)[temp.row][temp.col] = 1;
		queue.add(new Position(temp.row, temp.col, temp.height, top.len+1));
	}
	
	public void searchOne(Position temp) {
		visitList.get(temp.height)[temp.row][temp.col] = true;
		searchNESW(temp);
	}
	
	public void searchNESW(Position temp) {
		for(int d = 0; d < moveR.length; d++) { // 현재 상자에서 모든방향 돌아보기 
			int currR = temp.row+moveR[d];
			int currC = temp.col+moveC[d];
			if(currR >= 0 && currR < N && currC >= 0 && currC < M) {
				if(!visitList.get(temp.height)[currR][currC]) {
					Position cur = new Position(currR, currC, temp.height, top.len);
					if(boxes.get(temp.height)[currR][currC] == 1) {
						searchOne(cur);
						searchHeight(cur);
					}
					if(boxes.get(temp.height)[currR][currC] == 0) {
						searchZero(cur);
					}
				}
			}
		}
	}
	
	public void searchHeight(Position temp) {
		if(H != 1 && temp.height >= 0 && temp.height < H-1) { // 현재 높이 위에 있는 상자
			Position curr = new Position(temp.row, temp.col, temp.height+1, top.len);
			if(!visitList.get(curr.height)[curr.row][curr.col]) { // 안간곳인데				
				if(boxes.get(curr.height)[curr.row][curr.col] == 1) { // 이미 익었으면 그 자리에서 동서남북탐색			
					searchOne(curr);
				}			
				if(boxes.get(curr.height)[curr.row][curr.col] == 0) { // 안익은거면 그자리만 익음
					searchZero(curr);
				}
			}
		}
		if(H != 1 && temp.height > 0 && temp.height <= H-1) { // 현재 높이 아래 있는 상자
			Position curr = new Position(temp.row, temp.col, temp.height-1, top.len);
			if(!visitList.get(curr.height)[curr.row][curr.col]) { // 안간곳인데				
				if(boxes.get(curr.height)[curr.row][curr.col] == 1) { // 이미 익었으면 그 자리에서 동서남북탐색			
					searchOne(curr);
				}			
				if(boxes.get(curr.height)[curr.row][curr.col] == 0) { // 안익은거면 그자리만 익음
					searchZero(curr);
				}
			}
		}
	}
	
	public void bfs(int row, int col, int height) {
		while(!queue.isEmpty()) {
			top = queue.poll(); // 큐 가장위
			
			// 현재 높이의 상자 탐색하고 큐에 넣기
			searchNESW(top);
			
			// 인접한 상자(위아래)에 안익은게 있다면 익히고 카운트 인덱스만 올리기(값은 부모+1로 동일)
			searchHeight(top);
			
			res = top.len;
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);
		H = Integer.parseInt(s[2]);
		boxes = new ArrayList<>();
		visitList = new ArrayList<>();
		for(int height = 0; height < H; height++) {			
			box = new int[N][M];
			visited = new boolean[N][M];
			for(int row = 0; row < N; row++) {
				s = br.readLine().split(" ");
				for(int col = 0; col < M; col++) {
					box[row][col] = Integer.parseInt(s[col]);
				}
			}
			boxes.add(box);
			visitList.add(visited);
		}
		int max = 0;
		queue = new LinkedList<>();
		for(int height = 0; height < H; height++) {	
			int[][] selectB = boxes.get(height);
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(selectB[row][col] == 1 && !visited[row][col]) {
						visitList.get(height)[row][col] = true;
						queue.add(new Position(row, col, height, 0));
					}
				}
			}
		}
		
		bfs(queue.peek().row, queue.peek().col, queue.peek().height);
		
		if(max < res) {
			max = res;
		}
		
		for(int height = 0; height < H; height++) {	
			int[][] selectB = boxes.get(height);
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(selectB[row][col] == 0) { // 하나라도 안익은 토마토 있다면
						max = -1;
						break;
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	class Position {
		int row;
		int col;
		int height;
		int len;
		public Position(int row, int col, int height, int len) {
			this.row = row;
			this.col = col;
			this.height = height;
			this.len = len;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main m2606 = new Main();
		m2606.solve();
	}
}