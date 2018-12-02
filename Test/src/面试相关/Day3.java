package 面试相关;

public class Day3 {
	private int private_Num = 100;
	int default_Num = 200;
	protected int protected_Num = 300;
	public int public_Num = 400;
	
	public Day3() {
		System.out.println("i am 父类");
	}
	public Day3(String name) {
		System.out.println("i am 需要参数的父类");
	}
	
	public int getPublic_Num() {
		return public_Num;
	}
	
	/**
	 * 
	 * @Title: 访问权限修饰词   
	 * @return: 本类都可以用
	 */
	public static void main(String[] args) {
		Day3 d = new Day3();
		System.out.println(d.private_Num);
		System.out.println(d.default_Num);
		System.out.println(d.protected_Num);
		System.out.println(d.public_Num);
	}
}
