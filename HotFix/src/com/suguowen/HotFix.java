package com.suguowen;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * 
 * @author Gwen
 * @description 热部署的对象不能是同一个包下的类，否则不会重新部署
 */
public class HotFix {
	
	public static void main(String[] args) throws Exception {
		long lastModified = 0L;//最后修改时间
//		URL classUrl = new URL("file:D:\\my_workspace\\workspace2.0\\HotFixTest\\bin\\");
//		URLClassLoader parentLoader = new URLClassLoader(new URL[] {classUrl} , HotFix.class.getClassLoader());
		while(true) {
			//判断class文件有没有更新
			File file = new File("D:\\my_workspace\\workspace2.0\\HotFixTest\\bin\\com\\suguowen\\HelloService.class");
			
			if(file.lastModified() > lastModified) {
				try {
					lastModified = file.lastModified();
					//reload
					//自定义类加载器
					//java类加载器的作用，jvm加载class类的工具，支持通过文件目录，jar，zip等途径加载class类文件
					URLClassLoader loader = null;
					URL url = new URL("file:D:\\my_workspace\\workspace2.0\\HotFixTest\\bin\\");
					loader = new URLClassLoader(new URL[] {url} , HotFix.class.getClassLoader());
//					loader = new URLClassLoader(new URL[] {url} , parentLoader);
					//类加载流程
					//1、加载class文件 -> 内存
					//2、校验
					//3、准备内存？jvm内存模型
					//4、解析（方法、接口、字段...）
					Class clazz = loader.loadClass("com.suguowen.HelloService");
					//5、初始化（静态变量、静态代码块），使用class的时候，才会初始化
					//6、使用（new对象）
					Object newInstance = clazz.newInstance();
					
					Object result = clazz.getMethod("getValue").invoke(newInstance);
					
					System.out.println("调用getValue获取值为：" + result);
					
					//卸载class,GC去做
					System.gc();
					
				}catch(Exception e){
				}
			}
			Thread.sleep(1000L);
		}
		/*URLClassLoader loader = null;
		URL url = new URL("file:D:\\my_workspace\\workspace2.0\\HotFix\\bin\\");
		loader = new URLClassLoader(new URL[] {url} , HotFix.class.getClassLoader());
		//类加载流程
		//1、加载class文件 -> 内存
		//2、校验
		//3、准备内存？jvm内存模型
		//4、解析（方法、接口、字段...）
		Class clazz = loader.loadClass("com.suguowen.HelloService");
		//5、初始化（静态变量、静态代码块），使用class的时候，才会初始化
		//6、使用（new对象）
		Object newInstance = clazz.newInstance();
		
		Object result = clazz.getMethod("getValue").invoke(newInstance);
		
		System.out.println("调用getValue获取值为：" + result);
		
		//卸载class,GC去做
		System.gc();*/
	}
}
