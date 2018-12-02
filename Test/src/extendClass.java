import org.omg.CORBA.PUBLIC_MEMBER;

/*
 * 抽象类，继承后，必须重写抽象方法，普通方法可以选择性重写
 * 接口，实现后，必须实现所有接口方法
 * 抽象类实现接口，实现后，不需要实现接口，只要把接口方法写下来当做普通方法即可。
 * 这时候普通类再继承抽象类，就可以选择性实现接口方法。
 */
public class extendClass extends abstractClass{

	public extendClass() {
		System.out.println("子类构造器");
	}
	
	static {
		System.out.println("子类静态代码块");
	}
	
	@Override
	public void test2() {
		
	}

	@Override
	public void test5() {
		
	}
	
	public void method1() {
		//public 会报错
		/*public class innerClass2{
			
		}*/
	}
	//内部类
	public class innerClass{
		
	}
	
}
