package 面试相关;

/*
 * 值传递和引用传递
 */
public class Day2 {

	/**
	 * 
	 * @Title: 给形式参数指向了新地址   
	 * @return: 不会改变原来的值
	 */
	public void test1(String a) {
		a = new String("world");
		System.out.println("整形后："+a);
	}
	
	/**
	 * 
	 * @Title: System不为人知的东东   
	 * @Description: TODO()       
	 * @return: null
	 */
	public void test2(){
		System.getProperties().list(System.out);
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("java.library.path"));
	}
	/**
	 * 
	 * @Title: 字符串连接转型问题   
	 * @Description: TODO(""+(Integer)a)       
	 * @return: "+"意味着字符串连接，如果必要，还有字符串转换
	 */
	public void test3() {
		Integer a = 1;
		Integer b = a;
		System.out.println(a == b);
		System.out.println("a:" + a);
		System.out.println(a == b);
	}
	/**
	 * 
	 * @Title: 包装类型和基本类型比较   
	 * @return: 初始化时，有小数点的都是double/Double；小数点带F/f的才是Float/float
	 * 			Double、Float的equals要同"类型" 且 "同值"，才能true
	 */
	public void test4() {
		Double D = 10.0D;
		double d = 10.0d;
		Float F = 10.0F;
		float f = 10.0f;
		System.out.println("Double:"+ D);
		System.out.println("double:"+ d);
		System.out.println("Float:"+ F);
		System.out.println("float:"+ f);
		System.out.println(D.equals(d));
		System.out.println(F.equals(f));
		System.out.println(D == d);
		System.out.println(F == f);
		System.out.println(D.equals(F));
	}
	
	/**
	 * 
	 * @Title: 值传递和引用传递   
	 * @Description: TODO(传递的过程，其实是实参调用copy()给形参的过程，地址暂时是一样的
	 * ，如果你未改变地址就修改值，那肯定会修改原地址的值，如果你改变了地址再修改值，肯定不影响原地址
	 * 为什么要修改；因为如果是引用传递，传递过来的是一个“指针”，修改地址，“指针”指向新地址，原地址就没人指向了
	 * ；而如果是值传递，传递的是引用地址这个“值”（就是上文的copy（）），那修改地址，原地址不会被干扰)       
	 * @return: void
	 */
	public static void main(String[] args) {
		Day2 d2 = new Day2();
		
		/*String a = new String("hello");
		Man m = new Man("刘德华");
		
		d2.test1(a);
		m.setName("黎明");
		System.out.println("整形前："+a);
		System.out.println("整形前："+m.getName());*/
		d2.test4();
	}
	
	/**
	 * 
	 * @return: 内部类也可以public 
	 *
	 */
	public static class Man{
		private String name;
		
		public Man(String name) {
			this.name = name;
		}
		public String getName() {
			return this.name;
		}
		public void setName(String name) {
			this.name = name;
			System.out.println("整形后："+this.name);
		}
	}
}
