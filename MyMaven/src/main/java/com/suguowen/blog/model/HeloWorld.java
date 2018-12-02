package com.suguowen.blog.model;

import java.io.IOException;
import java.io.InputStream;

public class HeloWorld {
	/*
	 * 输出一段helloWorld
	 */
	
	//system
	public static void test1() {
		System.out.println("HelloWorld");
		System.out.print("2");
		System.out.println("111");
	}
	//
	public void test2() {
		InputStream is = new InputStream() {
			
			@Override
			public int read() throws IOException {
				return 0;
			}
		};
	}
	public static void main(String[] args) {
		test1();
	}
}
