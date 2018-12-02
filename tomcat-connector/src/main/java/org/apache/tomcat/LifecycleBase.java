package org.apache.tomcat;

/**
 * 
 * @author Gwen
 * @description 目标方法 为什么要抛异常
 */
public abstract class LifecycleBase {
	// 定义一个初始化的抽象方法，留个子类去实现
	protected abstract void initInternal() throws Exception;

	// 定义一个运行的抽象方法
	protected abstract void startInternal() throws Exception;

	// 定义一个可以调用的方法
	public void init() throws Exception {
		// 初始化之前做什么
		initBefore();

		initInternal();

		// 初始化之后做什么
		initAfter();
	}

	// 定义一个可以调用的方法
	public void start() throws Exception {
		// 运行之前做什么
		startBefore();

		startInternal();

		//运行之后做什么
		startAfter();
	}

	// 初始化之前
	private void initBefore() {
		System.out.println("Before Do");
	}

	// 初始化之后
	private void initAfter() {
		System.out.println("After Do");
	}

	// 运行之前
	private void startBefore() {
		System.out.println("Before Do");
	}

	// 运行之后
	private void startAfter() {
		System.out.println("After Do");
	}
}
