package com.suguowen.blog.reflect;

import java.awt.event.MouseMotionAdapter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;

import javax.activation.FileDataSource;

/*
 * 反射；反射拿到类，反射拿到属性，反射拿到方法，反射调用方法，反射修改属性方法
 */
public class Reflect {
	//获得class方法一：正常类1,如果私有则无法创建
	static TestReflect tr1 = new TestReflect();
	
	//拿类的方式
	public static void test1() {
		try {
			//获得class方法二：获得对象路径，如果你已经知道对象路径可以不需要对象，如果不知道就需要对象
			System.out.println(tr1.getClass().getName());;
			Class tr2 = Class.forName(tr1.getClass().getName());
//			Class tr2 = Class.forName("com.suguowen.blog.reflect.TestReflect");
			//获得class方法三：通过类来创建对象
			System.out.println(TestReflect.class.toString());
			Class tr3 = TestReflect.class;		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//拿属性
	public static void test2() {
		Class tr = TestReflect.class;
		Field[] fields = tr.getDeclaredFields();//获得已经声明的属性数组
		for (Field field : fields) {
			String str = "";
			str += Modifier.toString(field.getModifiers())+" ";//获得属性的修饰符
			str += field.getType().getName()+" ";//获得属性类型
			str += field.getName()+" ";//获得属性名字
			System.out.println(str);
		}
		try {
			TestReflect testReflect = (TestReflect)tr.newInstance();
			Field f = tr.getDeclaredField("name");
			f.setAccessible(true);
			System.out.println(f.get(testReflect));
			

		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//拿方法
	public static void test3() {
		try {
		Class tr = TestReflect.class;
		Constructor[] c = tr.getDeclaredConstructors();//获得构造方法
		Method[] methods = tr.getMethods();//获得方法,没有构造方法

		for (Constructor constructor : c) {
			//判断有没有参数,先写文档再编码，效率加快，定个时间，多长时间搞定一个概念，需要知晓这个概念，时间观念
			constructor.setAccessible(true);
			//没有参数
			if (constructor.getParameterCount() != 0) {
				TestReflect iniTr1 = (TestReflect)constructor.newInstance("hello");//创建对象
				System.out.println("1."+iniTr1.getName());
				
				Method method1 = tr.getDeclaredMethod("printMyName", String.class);
				method1.setAccessible(true);
				method1.invoke(iniTr1, "suguowen");
			}
			else if (constructor.getParameterCount()==0) {
				TestReflect iniTr2 = (TestReflect)constructor.newInstance();//创建对象
				System.out.println("2."+iniTr2.getName());
				
				Method method2 = tr.getDeclaredMethod("printMyName", String.class);
				method2.setAccessible(true);
				method2.invoke(iniTr2, "girlF");
			}
		}
		
//		Method constructor = tr.getMethod("TestReflect");//获得方法
//		constructor.setAccessible(true);
//		constructor.invoke();
					
			
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	
	
	public static void main(String[] args) {
		test2();

	}
}
