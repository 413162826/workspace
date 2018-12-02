package com.mashen.myblog.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/*
 * @ClassName: MyServletContextListener 
 * @Description: TODO
 * @author: Gwen
 * @date: 2018年2月1日 上午10:59:25
 * Listenr分类
 * 第一类：与ServletContext有关的Listener接口
 * 包括两个Listener接口，分别是ServletContextListener和ServletContextAttributeListener
 *第二类：与HttpSession有关的Listener接口
 *包括四个：HttpSessionListener,HttpSessionAttributeListener,HttpSessionBindingListener和HttpSessionActivationListener
 *第三类：与ServletRequest有关的Listener接口
 *包括两个：ServletRequestListener和ServletRequestAttributeListen
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("MyServletContext启动！！");
	}

}
