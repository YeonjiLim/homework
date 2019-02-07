package com.ssafy.ct;

import java.util.Scanner;

public class MagicSqaureMain {
	public static void main(String[] args) {
		System.out.print("만들고 싶은 마방진을 입력하세요:");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		MagicSquare odd = MagicFactory.factory(n); 
		MagicUtil.print(odd);
	}
}
