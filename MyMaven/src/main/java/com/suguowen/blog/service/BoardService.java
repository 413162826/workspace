package com.suguowen.blog.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BoardService {
	//判断是否单例
	static BoardService singleton = null;
	//确认了没有的情况下，才创建一个，保证单例
	public static BoardService getInstance() {
		if (singleton == null) {
			singleton = new BoardService();
		}
		return singleton;
	}
	//封死外面的new
	private BoardService() {
		
	}
	
	//L型号/计时器
	private int tile = 1;
	private int[][] board;
	
	/**
	 * 
	 * @param tr：棋盘左上角方格的行号
	 * @param tc:棋盘左上角方格的列号
	 * @param dr：特殊方格所在的行号
	 * @param dc：特殊方格所在的列号
	 * @param size：当前棋盘的大小
	 */
	public void chessBoard(int tr, int tc, int dr, int dc, int size) {
		/* 1、当前棋盘的大小是 1 就返回 */
		if (size == 1) {
			return;
		}
		int t = tile++;
		// 分割棋盘，棋盘大小减半
		int s = size / 2;

		/* 2、覆盖左上角子棋盘 */
		if (dr < tr + s && dc < tc + s) {
			// 特殊方格在此棋盘中
			chessBoard(tr, tc, dr, dc, s);
		} else {
			// 特殊方格不在此棋盘中，用 t 号骨牌覆盖右下角
			board[tr + s - 1][tc + s - 1] = t;
			// 覆盖其余方格
			chessBoard(tr, tc, tr + s - 1, tc + s - 1, s);
		}

		/* 3、覆盖右上角子棋盘 */
		if (dr < tr + s && dc >= tc + s) {
			// 特殊方格在此棋盘中
			chessBoard(tr, tc + s, dr, dc, s);
		} else {
			// 特殊方格不在此棋盘中，用 t 号骨牌覆盖左下角
			board[tr + s - 1][tc + s] = t;
			// 覆盖其余方格
			chessBoard(tr, tc + s, tr + s - 1, tc + s, s);
		}

		/* 4、覆盖左下角子棋盘 */
		if (dr >= tr + s && dc < tc + s) {
			// 特殊方格在此棋盘中
			chessBoard(tr + s, tc, dr, dc, s);
		} else {
			// 特殊方格不在此棋盘中，用 t 号骨牌覆盖右上角
			board[tr + s][tc + s - 1] = t;
			// 覆盖其余方格
			chessBoard(tr + s, tc, tr + s, tc + s - 1, s);
		}

		/* 5、覆盖左下角子棋盘 */
		if (dr >= tr + s && dc >= tc + s) {
			// 特殊方格在此棋盘中
			chessBoard(tr + s, tc + s, dr, dc, s);
		} else {
			// 特殊方格不在此棋盘中，用 t 号骨牌覆盖右上角
			board[tr + s][tc + s] = t;
			// 覆盖其余方格
			chessBoard(tr + s, tc + s, tr + s, tc + s, s);
		}
	}
	
	// 输出棋盘,需要获得棋盘大小参数
	public int[][] buildBoard(int dr, int dc, int size) {
		board = new int[size][size];
		chessBoard(0, 0, dr, dc, size);//调用,定死了原点(0,0)
		return board;
//		for (int i = 0; i < BOARD_SIZE; i++) {
//			for (int j = 0; j < BOARD_SIZE; j++) {
//				System.out.print(board[i][j] + "\t");
//			}
//			System.out.println("\n");
//		}
	}
	
	//生成随机颜色(或许可以移到工具类)
	public String randomColor() {
		String a = Integer.toHexString((int) (Math.random() * 255));
		String b = Integer.toHexString((int) (Math.random() * 255));
		String c = Integer.toHexString((int) (Math.random() * 255));
		String rC = "#" + a + b + c;
		return rC;
	}
	
	//从文档读取颜色存放到map,颜色是网上随便爬虫爬下来存在了本地的.
	public Map<Integer, String> colorMap() {
		Map<Integer, String> map = new HashMap<>();
		Map<Integer,String> map2=new HashMap<>();  
//		String filePath = "colorStyle.txt";//本地运行可以，tomcat运行找不到路径
		String filePath = "E:\\mashen\\TOMCAT\\apache-tomcat-8.0.28\\webapps\\MyMaven\\colorStyle.txt";
		BufferedReader reader;
		int i = 0;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
				map.put(i, line);//(1,#000000)(2,#xxxxxxx).....
				i++;
			}
			//去重
	        for(Integer key:map.keySet()){  
	            if(!map2.containsValue(map.get(key))){  
	                map2.put(key, map.get(key));  
	            }  
	        } 
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map2;
	}
	
}
