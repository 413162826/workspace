package 面试相关;public class StaticInitialization {
	/**
	 * 
	 * @Title: 静态数据的初始化   
	 * @Description: TODO(复杂的跳转初始化)       
	 * @return: 
	 * 结论1：按顺序初始化 static 变量/对象 -> 执行主（static）方法 
	 * 结论2：用构造函数new一个对象时 -> 先初始化改对象所在类的 static 变量/对象 -> 再执行构造(staitc)方法
	 * 结论3：static 变量/对象 只会初始化一次
	 */
	public static void main(String[] args) {
		System.out.println("Create new Cupboard() in main");//11
		new Cupboard();//12
		System.out.println("Creating new Cupboard() in main");//16
		new Cupboard();//17
		table.f2(1);//21
		cupboard.f3(1);//22
	}
	static Table table = new Table();//0
	static Cupboard cupboard = new Cupboard();//5
}
class Bowl{
	Bowl(int marker) {
		System.out.println("Bow("+marker+")");
	}
	void f1(int marker) {
		System.out.println("f1("+marker+")");
	}
}
class Table{
	static Bowl bowl1 = new Bowl(1);//1
	Table(){
		System.out.println("Table()");//3
		bowl2.f1(1);//4
	}
	void f2(int marker) {
		System.out.println("f2("+marker+")");
	}
	static Bowl bowl2 = new Bowl(2);//2
}
class Cupboard{
	Bowl bowl3 = new Bowl(3);//8,13,18
	static Bowl bowl4 = new Bowl(4);//6
	Cupboard() {
		System.out.println("Cupboard");//9,14,19
		bowl4.f1(2);//10,15,20
	}
	void f3(int marker) {
		System.out.println("f3("+marker+")");
	}
	static Bowl bowl5 = new Bowl(5);//7
}