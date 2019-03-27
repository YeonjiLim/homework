import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	
	public int R, C;
	public String[][] map; // 처음 주어지는 혁셈블리어
	public Direction[][] direction; // 들어오고 나가는 방향
	public int[][] memorys; // 각 위치에 처음 저장되는 메모리
	public boolean[][] visited; // 방문정보저장
	
	// left, right, up, down
	public static final int[] moveR = {0, 0, -1, 1};
	public static final int[] moveC = {-1, 1, 0, 0};
	public int status;
	
	public int currMemory; // 현재 메모리
	
	public boolean hasCycle; // 사이클 여부 확인
	public boolean isEnd; // @에 도달하는지 확인
	
	public boolean cycleCheck(int row, int col, int prev, int next) {
		// 현재 메모리, 방향이 전부 -1이 아니고(이미 왔던곳) 기존값이랑 같다면
		if(memorys[row][col] != -1 && direction[row][col].in != -1 && 
				memorys[row][col] == currMemory && direction[row][col].in == prev && direction[row][col].out == next) {
			return true;
		}
		// 처음들어온거면 값저장
		if(memorys[row][col] == -1) {
			memorys[row][col] = currMemory;
		}
		if(direction[row][col].in == -1) {
			direction[row][col].in = prev;
			direction[row][col].out = next;
		}
		return false;
	}
	
	public int nextR(int row, int status) {
		int nxtR = row+moveR[status];
		if(nxtR >= R) {
			nxtR = 0;
		} 
		if(nxtR < 0) {
			nxtR = R-1;
		}
		return nxtR;
	}
	
	public int nextC(int col, int status) {
		int nxtC = col+moveC[status];
		if(nxtC >= C) {
			nxtC = 0;
		} 
		if(nxtC < 0) {
			nxtC = C-1;
		}
		return nxtC;
	}
	
	public void search(int row, int col) {
		if(!isEnd) {
			if(map[row][col].equals("<")) {
				if(!cycleCheck(row, col, status, 0)) {
					status = 0;
					search(nextR(row, status), nextC(col, status));
				}
			} else if(map[row][col].equals(">")) {
				if(!cycleCheck(row, col, status, 1)) {
					status = 1;
					search(nextR(row, status), nextC(col, status));
				}
			} else if(map[row][col].equals("^")) {
				if(!cycleCheck(row, col, status, 2)) {
					status = 2;
					search(nextR(row, status), nextC(col, status));
				}
			} else if(map[row][col].equals("v")) {
				if(!cycleCheck(row, col, status, 3)) {
					status = 3;
					search(nextR(row, status), nextC(col, status));
				}
			} else if(map[row][col].equals("_")) {
				if(currMemory == 0) {
					if(!cycleCheck(row, col, status, 1)) {
						status = 1;
						search(nextR(row, status), nextC(col, status));
					}
				} else {
					if(!cycleCheck(row, col, status, 0)) {
						status = 0;
						search(nextR(row, status), nextC(col, status));
					}
				}
			} else if(map[row][col].equals("|")) {
				if(currMemory == 0) {
					if(!cycleCheck(row, col, status, 3)) {
						status = 3;
						search(nextR(row, status), nextC(col, status));
					}
				} else {
					if(!cycleCheck(row, col, status, 2)) {
						status = 2;
						search(nextR(row, status), nextC(col, status));
					}
				}
			} else if(map[row][col].equals("?")) {
				int curStatus = status;
				for(int d = 0; d < 4; d++) {
					if(!cycleCheck(row, col, curStatus, d)) {
						status = d;
						if(!visited[nextR(row, status)][nextC(col, status)]) {
							visited[nextR(row, status)][nextC(col, status)] = true;
							search(nextR(row, status), nextC(col, status));
						}
					}
				}
			} else if(map[row][col].equals(".")) {
				if(!cycleCheck(row, col, status, status)) {
					search(nextR(row, status), nextC(col, status));
				}
			} else if(map[row][col].equals("@")) {
				isEnd = true;
				return;
			} else if(map[row][col].equals("+")) {
				currMemory++;
				if(currMemory > 15) {
					currMemory = 0;
				}
				if(!cycleCheck(row, col, status, status)) {
					search(nextR(row, status), nextC(col, status));
				}
			} else if(map[row][col].equals("-")) {
				currMemory--;
				if(currMemory < 0) {
					currMemory = 15;
				}
				if(!cycleCheck(row, col, status, status)) {
					search(nextR(row, status), nextC(col, status));
				}
			} else {
				currMemory = Integer.parseInt(map[row][col]);
				if(!cycleCheck(row, col, status, status)) {
					search(nextR(row, status), nextC(col, status));
				}
			}
		}
		
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim();
		int T = Integer.parseInt(str);
		for(int tc = 1; tc <= T; tc++) {
			String[] s = br.readLine().trim().split(" ");
			R = Integer.parseInt(s[0]);
			C = Integer.parseInt(s[1]);
			map = new String[R][C];
			direction = new Direction[R][C];
			memorys = new int[R][C];
			visited = new boolean[R][C];
			currMemory = 0;
			hasCycle = false;
			isEnd = false;
			status = 1;
			int ends = 0;
			for(int row = 0; row < R; row++) {
				s = br.readLine().trim().split("");
				for(int col = 0; col < C; col++) {
					map[row][col] = s[col];
					direction[row][col] = new Direction(-1, -1);
					memorys[row][col] = -1;
					visited[row][col] = false;
					if(map[row][col].equals("@")) {
						ends++;
					}
				}
			}
			if(ends != 0) {				
				search(0, 0);
			}
			if(isEnd) {
				System.out.println("#" + tc + " YES");
			} else {
				System.out.println("#" + tc + " NO");
			}
		}
	}
	
	class Direction {
		int in;
		int out;
		public Direction(int in, int out) {
			this.in = in;
			this.out = out;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Solution s1824 = new Solution();
		s1824.solve();
	}
}
