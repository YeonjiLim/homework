package kr.co.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1082 {

	public int R, C;
	public String[][] map;
	
	// up, down, left, right
	public int[] moveR = {-1, 1, 0, 0};
	public int[] moveC = {0, 0, -1, 1};
	
	public boolean[][] visitedFire;
	public boolean[][] visitedJS;

	public Queue<Position> fireQ;
	public Queue<Position> JSQ;
	
	public int time;
	public boolean canEscape;
	
	public void jsBFS() {
		int size = JSQ.size();
		for(int i = 0; i < size; i++) {
			Position tmp = JSQ.poll();
			visitedJS[tmp.row][tmp.col] = true;
			if(map[tmp.row][tmp.col].equals("D")) {
				canEscape = true;
				break;
			}
			for(int d = 0; d < 4; d++) {
				int nxtR = tmp.row + moveR[d];
				int nxtC = tmp.col + moveC[d];
				if(nxtR >= 0 && nxtR < R && nxtC >= 0 && nxtC < C && !map[nxtR][nxtC].equals("X") && !map[nxtR][nxtC].equals("*") && !visitedJS[nxtR][nxtC]) {
					visitedJS[nxtR][nxtC] = true;
					JSQ.add(new Position(nxtR, nxtC));
				}
			}
		}

		if(!canEscape) {				
			time++;
		}
	}
	
	public void fireBFS() {
		while(!fireQ.isEmpty() && !canEscape) {
			int size = fireQ.size();
			for(int i = 0; i < size; i++) {
				Position tmp = fireQ.poll();
				visitedFire[tmp.row][tmp.col] = true;
				for(int d = 0; d < 4; d++) {
					int nxtR = tmp.row + moveR[d];
					int nxtC = tmp.col + moveC[d];
					if(nxtR >= 0 && nxtR < R && nxtC >= 0 && nxtC < C && !map[nxtR][nxtC].equals("X") && !map[nxtR][nxtC].equals("D") && !visitedFire[nxtR][nxtC]) {
						visitedFire[nxtR][nxtC] = true;
						map[nxtR][nxtC] = "*";
						fireQ.add(new Position(nxtR, nxtC));
					}
				}
			}
			jsBFS();
		}
	}
	
	public void solve() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		map = new String[R][C];
		fireQ = new LinkedList<>();
		JSQ = new LinkedList<>();
		visitedFire = new boolean[R][C];
		visitedJS = new boolean[R][C];
		for(int row = 0; row < R; row++) {
			s = br.readLine().trim().split("");
			for(int col = 0; col < C; col++) {
				map[row][col] = s[col];
			}
		}
		
		for(int row = 0; row < R; row++) {
			for(int col = 0; col < C; col++) {
				if(map[row][col].equals("*")) {
					fireQ.add(new Position(row, col));
				} else if(map[row][col].equals("S")) {
					JSQ.add(new Position(row, col));
				}
			}
		}
		
		time = 0;
		canEscape = false;
		fireBFS();
		if(fireQ.isEmpty()) {
			while(!JSQ.isEmpty()) {
				if(canEscape) {
					break;
				}
				jsBFS();
			}
		}
		
		if(canEscape) {
			System.out.println(time);
		} else {
			System.out.println("impossible");
		}
	}
	
	class Position{
		int row;
		int col;
		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		Main1082 m1082 = new Main1082();
		m1082.solve();
	}
}
