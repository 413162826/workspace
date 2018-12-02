
public class Test {

	public void int_Integer_Test() {
		// ==测试，int和Integer
		Integer a = 1, b = 1, c = 200, d = 200;
		int a1 = 1, b1 = 1, c1 = 200, d1 = 200;
		//超过127，new Integer，对象地址不同
		System.out.println((a == b));
		System.out.println((c == d));
		//int值同ok
		System.out.println(a1 == b1);
		System.out.println(c1 == d1);
		//封装型会自动拆箱，int和Integer值同就ok
		System.out.println(a == a1);
		System.out.println(c == c1);

	}

	public void intTstr() {
		// 最简单的int To str方法
		Integer a = 10;
		String b = a + "";
		System.out.println(b);
	}

	public void valueOf_Test() {
		// 整形valueOf测试,-128~127从缓存取，超过的new Integer(x);
		Integer a = 5;
		Integer b = Integer.valueOf(5);

		Integer c = 200;
		Integer d = Integer.valueOf(200);

		System.out.println(a == b);
		System.out.println(c == d);
	}

	//位运算
	public void test1() {
		int a = 3<<3;
		System.out.println(a);
	}
	//
	static Integer a;
	static int b;
	static String c;
	public static void test2() {
		
		System.out.println(a+","+b+","+c);
	}
	
    public boolean test3() {
    	int x = 200;
    	return x == 200?true:false;
    }
	
    public void test4() {
    	extendClass e = new extendClass();
    }
    
	public static void main(String[] args) {
		Test tt = new Test();
		tt.test4();
		/*boolean s = tt.test3();
		System.out.println(s);*/
	}
}
