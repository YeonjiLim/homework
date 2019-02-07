package com.ssafy.ct;

public class SixMagicSquare extends MagicSquare{
	
	public SixMagicSquare(int n) {
		super(n);
	}

	public SixMagicSquare() {
		this(6); 
	}
	
	public void make() {
		makeA(); // A지역 만들기
		makeB();
		makeC();
		makeD();
		makeMulti();
		makeOdd();
	}

	private void makeOdd() {
		OddMagicSquare odd = new OddMagicSquare(n / 2); // 의존
		odd.make();
		int[][] mm = odd.getMagic();
		for(int i = 0; i < n / 2; i++) {
			for(int j = 0; j < n / 2; j++) {
				magic[i][j] += mm[i][j];
				magic[i][j+n/2] += mm[i][j];
				magic[i+n/2][j] += mm[i][j];
				magic[i+n/2][j+n/2] += mm[i][j];
			}
		}
	}

	private void makeA() {
		for(int i = 0; i < n / 2; i++) { // A지역 row 범위
			for(int j = 0; j < n /4; j++) { // A지역에서 3으로 바꾸는 곳
				if( i == n / 4) { // A지역의 중앙행이면,
					magic[i][j+1] = 3;
				} else { // A지역 중앙행이 아니면,					
					magic[i][j] = 3; // A지역에서 n/4지역 3으로 채움
				}
			}
		}
	}

	private void makeB() {
		for(int i = 0; i < n /2; i++) { // 일단 1로 채우기
			for(int j = 0; j < n/2 ; j++) {
				magic[i][j+n/2] = 1;
			}
		}
		for(int i = 0; i < n /2; i++) {
			for(int j = 0; j < n/2 - (n/4 - 1) ; j++) {
				magic[i][j+n/2] = 2;
			}
		}
	}
	
	private void makeC() {
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				if(magic[i][j] == 0) {
					magic[i + n/2][j] = 3; 
				} else {
					magic[i + n/2][j] = 0;
				}
			}
		}
	}
	
	private void makeD() {
		for(int i = 0; i < n/2; i++) {
			for(int j = 0; j < n/2; j++) {
				if(magic[i][j+n/2] == 1) {
					magic[i+n/2][j+n/2] = 2;
				}else {
					magic[i+n/2][j+n/2] = 1;
				}
			}
		}
	}
	
	private void makeMulti() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				magic[i][j] *= (n/2) * (n/2);
			}
		}
	}
}
