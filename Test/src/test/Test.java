package test;

import 面试相关.Day3;

public class Test{
	/**
	 * 
	 * @Title: 访问权限修饰词   
	 * @return: 不同包public可用
	 */
	public static void main(String[] args) {
		Day3 d = new Day3();
		/*System.out.println(d.private_Num);
		System.out.println(d.default_Num);
		System.out.println(d.protected_Num);*/
		System.out.println(d.public_Num);
	}

}
class Test2 extends Day3{ 
	public int public_Num = 600;
	private final String name;
	/*public Test2() {
		System.out.println("i am 子类");
	}*/
	public Test2(String name) {
		super(name);
		this.name = name;
		System.out.println("i am 需要名字的子类");
	}
	
	@Override
	public int getPublic_Num() {
		return public_Num;
	}

	public static void main(String[] args) {
		Day3 d3 = new Test2("suguowen");
		System.out.println(d3.public_Num +","+ d3.getPublic_Num());
	}
	public void test1() {
		Day3 d = new Day3();
		/*System.out.println(super.private_Num);
		System.out.println(super.default_Num);*/
		System.out.println(super.protected_Num);
		System.out.println(super.public_Num);
	}
}
