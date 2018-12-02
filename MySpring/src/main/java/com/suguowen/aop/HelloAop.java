package com.suguowen.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class HelloAop {
	
	//定义切的范围
	@Pointcut("execution(* com.suguowen.*.*(..))")
	private  void allMethod() {};
	
	//定义前置通知
	@Before("allMethod()")
	public void beforeAop() {
		System.out.println("hello , i am before man!!");
	}
	
	//定义后置通知
	@AfterReturning("allMethod()")
	public void afterAop() {
		System.out.println("hello , i am after man!!");
	}
}
