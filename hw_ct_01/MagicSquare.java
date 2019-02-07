package com.ssafy.ct;

public class MagicSquare {
	
	protected int[][] magic; 
	protected int n;
	
	public MagicSquare(int n) {
		magic = new int[n][n];
		this.n = n; 
	}
	
	public int[][] getMagic() {
		return this.magic;
	}
	
	public void make() {	}

	public boolean isCheck() {
		boolean isS = true; 
		int[] mm = new int[2*n + 2]; 
		for(int i = 0; i < n; i++) {
			mm[i] = sumRow(i);
			mm[i+n] = sumCol(i);
		}
		mm[2*n] = sumDia();
		mm[2*n + 1] = sumAntDia();
		for(int i = 0; i < mm.length; i++) {
			if(mm[0] != mm[i]) {
				isS = false;
				break;
			}
		}
		return isS;
	}
	
	private int sumRow(int row) {
		int tot = 0;
		for(int i = 0; i < magic.length; i++) {
			tot += magic[row][i];
		}
		return tot;
	}
	
	private int sumCol(int col) {
		int tot = 0;
		for(int i = 0; i < magic.length; i++) {
			tot += magic[i][col];
		}
		return tot;
	}
	
	private int sumDia() {
		int tot = 0;
		for(int i = 0; i < magic.length; i++) {
			tot += magic[i][i];
		}
		return tot;
	}
	
	private int sumAntDia() {
		int tot = 0;
		for(int i = 0; i < magic.length; i++) {
			tot += magic[i][magic.length-1-i];
		}
		return tot;
	}

	public void print() {
		if(isCheck()) {
			System.out.println("임의의 한 행의 값이 " + sumRow(0) + "인 마방진입니다.");
		}
		System.out.println("구해진 " + n + "마방진:");
		for(int i = 0; i < magic.length; i++) {
			for(int j = 0; j < magic[i].length; j++) {
				System.out.printf("%d\t", magic[i][j]);
			}
			System.out.println();
		}
		System.out.println(n + "마방진의 총합 : " + sumRow(0)*n);
	}
}
