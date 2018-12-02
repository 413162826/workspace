
public abstract class abstractClass implements IClass1{
	public abstractClass() {
		System.out.println("父类构造器");
	}
	static {
		System.out.println("父类静态代码块");
	}
	//不抽象
	public void test1() {
		
	}
	
	//抽象
	public abstract void test2() ;

	@Override
	public void test3() {
	}

	@Override
	public void test4() {
	}
	
	
}
