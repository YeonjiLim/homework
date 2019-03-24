import java.util.Scanner;

public class Main {

	public static final int MAX = 100;
	public static final int VISIT = 1;
	public static final int NOTVISIT = 0;
	
	public static int M, N, K;
	int[][] map = new int[MAX+1][MAX+1];
	boolean[][] visited = new boolean[MAX+1][MAX+1];
	static int[] sizeOfSpace = new int[MAX*MAX];
	int spaces = 0;
	
	int[] dx = new int[]{0, 0, -1, 1};
	int[] dy = new int[]{-1, 1, 0, 0};
	
	public Main(){
		
	}
	
	public static void main(String[] args) {
		Main p2 = new Main();
		p2.init();
		
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		
		for(int i = 0; i < K; ++i){
			int ld_x, ld_y, ru_x, ru_y;
			ld_x = sc.nextInt();
			ld_y = sc.nextInt();
			ru_x = sc.nextInt();
			ru_y = sc.nextInt();
			p2.draw(ld_x, ld_y, ru_x-ld_x, ru_y-ld_y);
		}
		
		int spaces = 0;
		int[] dot = new int[2];
		
		while(!p2.isCompleted()){
			dot = p2.getFirstPoint();
			p2.solve(dot[0], dot[1], spaces);
			spaces++;
		}
		
		System.out.println(spaces);
		p2.sort(spaces);
		for(int i = 0; i < spaces; ++i){
			System.out.print(sizeOfSpace[i] + " ");
		}
	}
	
	public void sort(int spaces) {
		for(int i = 0; i < spaces; ++i){
			for(int j = 1; j < spaces; ++j){
				if(sizeOfSpace[j-1] > sizeOfSpace[j]){
					int temp = sizeOfSpace[j];
					sizeOfSpace[j] = sizeOfSpace[j-1];
					sizeOfSpace[j-1] = temp;
				}
			}
		}
		
	}

	public void solve(int x, int y, int index) {
		if(y < 0 || y >= M || x < 0 || x >= N){
			return;
		}
		
		if(map[x][y] == 8 || map[x][y] == 1){
			return;
		}
		
		map[x][y] = 8;
		sizeOfSpace[index]++;
		
		for(int i = 0; i < 4; i++){
			solve(x+dx[i], y+dy[i], index);
		}
	}

	public int[] getFirstPoint() {
		int[] startDot = new int[2];
		for(int x = 0; x < N; ++x){
			for(int y = 0; y < M; ++y){	
				if(map[x][y] == 0){
					startDot[0] = x;
					startDot[1] = y;
					return startDot;
				}
			}
		}
		return startDot;
	}

	public boolean isCompleted() {
		for(int x = 0; x < N; ++x){
			for(int y = 0; y < M; ++y){
				if(map[x][y] == 0){
					return false;
				}
			}
		}
		return true;
	}

	public void init(){
		for(int x = 0; x < N; ++x){
			for(int y = 0; y < M; ++y){
				map[x][y] = NOTVISIT;
			}
		}
	}
	
	public void draw(int x_start, int y_start, int width, int height){
		for(int x = x_start; x < x_start+width; ++x){
			for(int y = y_start; y < y_start+height; ++y){
				map[x][y] = 1;
			}
		}
	}

}
