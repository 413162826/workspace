package 面试相关;


public class Day4 {
	/**
	 * 
	 * @Title: 访问权限修饰词   
	 * @return: 本包可用，除了private
	 */
	public static void main(String[] args) {
		/*Day3 d3 = new Day3();
		
		System.out.println(d3.default_Num);
		System.out.println(d3.protected_Num);
		System.out.println(d3.public_Num);*/
		test2 t2 = new test2();
	}
	
}	

class test1{
	public test1() {
		System.out.println("test1");
	}
}
class test2{
	private test1 t1 = new test1();
	static{
		System.out.println("static test2");
	}
	
	public test2() {
		System.out.println("test2");
	}
}