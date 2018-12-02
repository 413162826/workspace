package org.apache.tomcat;

/**
 * 
 * @author Gwen
 * @description 实现Tomcat里常用的模板方法模式和简单监控8080端扣
 */
public class Main {
	public static void main(String[] args) throws Exception{
		Service service = new Service();
		service.init();
		service.start();
	}
}
