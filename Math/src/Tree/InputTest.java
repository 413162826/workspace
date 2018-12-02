package Tree;

import java.util.Scanner;

public class InputTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("输入你的名字:");
		String name = s.nextLine();
		System.out.println("输入你的年龄:");
		int age = s.nextInt();
		System.out.println("-------------------");
		System.out.println("姓名:"+ name);
		System.out.println("年龄 :"+ age);
	}
}
