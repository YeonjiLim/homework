package com.ssafy.ct;

public class FourMagicSquare extends MagicSquare{
	
	public FourMagicSquare(int n) {
		super(n);
	}

	public FourMagicSquare() {
		this(4); 
	}
	
	public void make() {
		makeA(); 
		makeR();
	}
	
	private void makeR() {
		for(int i = 0; i < magic.length; i++) {
			for(int j = 0 ; j < magic.length; j++) {
				if((i >= 0 && i < n/4) || (i >= n/4*3 && i < n)) { 
					if(j >= n/4 && j < n/4 * 3 && i < n) { 
						magic[i][j] = n*n - (i*n+j); 
					}
				} else {
					if((j >= 0 && j < n/4) || (j >= n/4*3 && j < n)) {
						magic[i][j] = n*n - (i*n+j); 
					}
				}
			}
		}
	}

	private void makeA() {
		for(int i = 0; i < magic.length; i++) {
			for(int j = 0; j < magic.length; j++) {
				magic[i][j] = i*n+j + 1; 
			}
		}
	}
}
