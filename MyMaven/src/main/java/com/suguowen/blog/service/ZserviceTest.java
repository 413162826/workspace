package com.suguowen.blog.service;


public class ZserviceTest {
	public static void test1() {

		BoardService bs = BoardService.getInstance();
		int[][] a = bs.buildBoard(1, 1, 4);
		for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 4; j++) {
			System.out.print(a[i][j] + "\t");
		}
		System.out.println("\n");
	}
	}
	public static void main(String[] args) {
		test1();
	}
}
