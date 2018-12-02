package Tree;

import java.util.Scanner;

public class Chocolate {
	/*
	 * 计算a可以平分多少次
	 * 算法: 如果a>=2
	 * 		a=a/2,count++
	 */
	public static int getHappy(int a) {
		System.out.println("=====进入方法=====");
		int count = 0;
		//2及以上都可以平分加开心值
		while(a >= 2) {
			a = a/2;
			count++;
			//为什么乘2，考虑到二叉树我们只能算一条路，另一条路的情况是一样的，所以乘2
			if(a >= 2) {
				count = count*2;
			}
		}
		System.out.println("渣渣辉开心值:"+count);
		return count;
	}
	public static void main(String[] args) {
		//随便输入巧克力长度
		getHappy(8);
		
	}
}
