package com.mashen.spring.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	//解析定义的文件
	private static AbstractApplicationContext context = 
			new ClassPathXmlApplicationContext("applicationContext.xml");
	
	//获取文件中的实例
	public static Object getBean(String beanId) {
		Object object =context.getBean(beanId);
		return object;
	}
	
	//关闭
	public static void closeContext() {
		context.close();
	}
}
