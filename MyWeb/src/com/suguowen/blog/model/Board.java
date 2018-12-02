package com.suguowen.blog.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @title ChessboardCoverage
 * @describe 棋盘覆盖：
 *           利用分治法，将方形棋盘分成4部分，如果该特殊点在某一部分，我们就去递归他，如果不在某一部分，我们假设一个点为特殊点，同样递归下去，知道全覆盖。
 * 
 *           左上角的子棋盘（若不存在特殊方格）：则将该子棋盘右下角的那个方格假设为特殊方格；
 *           右上角的子棋盘（若不存在特殊方格）：则将该子棋盘左下角的那个方格假设为特殊方格；
 *           左下角的子棋盘（若不存在特殊方格）：则将该子棋盘右上角的那个方格s假设为特殊方格；
 *           右下角的子棋盘（若不存在特殊方格）：则将该子棋盘左上角的那个方格假设为特殊方格；
 * 
 *           Board执行算法，得到结果列表bList bList传到jsp页面，讲bList的标号的位置信息传给方格，且相同值的颜色相同
 *           q1：如何传数组给jsp-----在jsp运行得到bList，然后把bLilst的值迭代出来存在变量a，然后a再赋值给color
 *           q2:如何生成8*8的格子-- 静态：0,0,0,0,8格子是200*200，格子()---for,for嵌套 q3:如何放颜色
 *           先随机颜色+筛选同值得到颜色+位置的list，在用list生成格子
 *           q3.1:一个列表有(x,y,value)三个信息，如何讲value相同的点筛选出来
 *           planA:将value从小到大存在排序表里，到时候迭代排序表就可以了，而且这样做有顺序的输出格子！！！！！！
 *           （暂时想到的方法是创建一个boardBean来存放x,y,value数据，
 *           然而这样的话对每一个格子都需要new，对内存要求高！！或许三维数组能解决~~）
 *           planB:从网上找到颜色表，用爬虫的方式爬下来后保存在a.txt中，然后根据数组的value来选择颜色！！！
 *           q4:加入两个input,用于用户输入参数并Board.jsp
 *           q5:封装应用
 * 
 * @author suguwen
 * @date 2017年4月9日下午7:36:15
 */
public class Board {
	// 定义棋盘的大小：2^k，需要的骨牌数是：(4^k-1)/3
	private int BOARD_SIZE = 8;
	// 定义一个二维数组用来模拟棋盘
	private int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
	// 定义一个全局变量，用来记录骨牌的编号
	private int tile = 0;
	private Map<Integer, String> map;

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

	// 输出棋盘
	private void printBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	public String randomColor() {
		String a = Integer.toHexString((int) (Math.random() * 255));
		String b = Integer.toHexString((int) (Math.random() * 255));
		String c = Integer.toHexString((int) (Math.random() * 255));
		String rC = "#" + a + b + c;
		return rC;
	}

	public Map<Integer, String> colorMap() {
		Map<Integer, String> map = new HashMap<>();
		Map<Integer,String> map2=new HashMap<Integer,String>();  
//		String filePath = "colorStyle.txt";
		String filePath = "E:\\mashen\\TOMCAT\\apache-tomcat-8.0.28\\webapps\\MyWeb\\colorStyle.txt";
		
		BufferedReader reader;
		int i = 0;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String line = reader.readLine();
			while ((line = reader.readLine()) != null) {
//				System.out.println(line);
				map.put(i, line);
				i++;
			}
//			System.out.println(map.size());
			//去重
	        for(Integer key:map.keySet()){  
	            if(!map2.containsValue(map.get(key))){  
	                map2.put(key, map.get(key));  
	            }  
	        } 
//			System.out.println(map2.size());
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

	static {
		Board b = new Board();
//		Map<Integer, String> map = b.colorMap();
//		 for (int ix = 0; ix < map.size(); ix++) {
//		 System.out.println(map.get(ix));
//		 }
		System.out.println(b.colorMap().get(10));
	}

	/**
	 * @return the board
	 */
	public int[][] getBoard() {
		return board;
	}

	/**
	 * @param board
	 *            the board to set
	 */
	public void setBoard(int[][] board) {
		this.board = board;
	}
	

	public static void main(String[] args) {
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("棋盘的大小为：" + BOARD_SIZE);
		// System.out.println("请输入特殊方格所在的行号：");
		// int dr = scanner.nextInt();
		// System.out.println("请输入特殊方格所在的列号：");
		// int dc = scanner.nextInt();
		// scanner.close();
		// // 行号和列号与二位数组的下标相差 1
		// chessBoard(0, 0, dr - 1, dc - 1, BOARD_SIZE);
		// System.out.println("特殊方块在第 " + dr + " 行第 " + dc + "列，覆盖后的棋盘：");
		// // 输出棋盘
		// printBoard();
	}

}