package 面试相关;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Day1 {
	
	public static int i = 3;
	/**
	 * 
	 * @Title: 测试Object会发生什么   
	 * @Description: TODO(区别在15，16行)       
	 * @return: Object多态，但是父类不能调用子类独有的方法，子类可以调用父类的方法。
	 */
	public void test() {
		Object o = new Day1();//多态
		Day1 test = (Day1)o;//父类强转成子类，拥有子类独有的变量和方法
		Object test2 = (Day1)o;//多态，不能调用子类独有的方法属性
		System.out.println(test.i);
		//System.out.println(test2.i);//程序编译错误
	}
	/**
	 * 
	 * @Title: 嵌套try，Catch，Finally的finally怎么执行
	 * @Description: TODO(看代码)       
	 * @return: 先执行最里面的，从里往外
	 */
	public void test2() {
		try {
			System.out.println("try1");
			try {
				System.out.println("try2");
			} catch (Exception e) {
				System.out.println("catch2");
			}finally {
				System.out.println("finally2");
			}
		} catch (Exception e) {
			System.out.println("catch1");
		}finally {
			i = i + 1;
			System.out.println("finally1");
		}
	}
	
	public void test3() {
		Set s = new HashSet<>();
		List l = new ArrayList<>();
		Map m = new HashMap<>();
	}
	
	public void test4() {
		short s = 2;
		int i = 10;
		int a = s/i;
		System.out.println(a);
		
	}
	
	public static void main(String[] args) {
		Day1 dd = new Day1();
		dd.test4();
	}

}

