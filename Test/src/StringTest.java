import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringTest {
	public static void main(String[] args) {
		StringTest st = new StringTest();
		st.test4();
		/*//验证String如何指向
		String a = new String("aaa");
		StringBuffer sb = new StringBuffer("111");
		int ia = new Integer(5);
		st.changeStr(a,sb,ia);
		System.out.println(a+","+sb+","+ia);//结果:aaa,111333
*/	}
	
	public void changeStr(String str,StringBuffer sb,int ia) {
		str = str + "ccc";
		sb.append("333");
		ia = ia + 5;
	}
	
	/*
	 * 测试标题：测试String加法对象是否一致
	 * 测试方法：对比输出第二第三行，直接字符相加，产生的是一个对象；一个对象+一个字符的地址不等于值相同的一个字符
	 * 测试结论：“ab”肯定开辟了一个新空间，“a”+“b”并没有开辟两个空间再加。
	 */
	public void test1() {
		String a = "a";
		String b = a + "b";
		String c = "a" + "b";
		System.out.println(a == "a");
		System.out.println(b == "ab");
		System.out.println(c == "ab");
	}
	
	/**
	 * 
	 * @Title: Set里的元素是不能重复的，那么用什么方法来区分重复与否呢?   
	 * @Description: TODO(查看源代码)       
	 * @return: 首先判断两个对象是否==，否则判断size大小是否相同，是则判断containAll，是则true
	 */
	public void test2() {
		Set s = new HashSet<>();
	}
	
	/**
	 * 
	 * @Title: list,set,map有什么方法
	 * @Description: TODO(查看源代码)       
	 * @return: 结论在下面
	 */
	public void test3() {
		List l = new ArrayList<>();//add,remove,get
		Set s = new HashSet<>();//add,remove
		Map<String, String> m = new HashMap<>();//put,remove
	}
	/**
	 * 
	 * @Title: equal和== 
	 * @Description: TODO(查看Object源代码)       
	 * @return: equal其实调用够了==，但equal可以重写，可以重写成只要值相同就true，改写equal一般要改写
	 * hashode()
	 */
	public void test4() {
		Integer a = new Integer(47);
		Integer b = new Integer(47);
		System.out.println(a == b);//地址相等，false
		System.out.println(a.equals(b));//equals被重写了，值相等，true
	}
}
