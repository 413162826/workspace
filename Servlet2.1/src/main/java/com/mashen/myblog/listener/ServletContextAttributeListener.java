package com.mashen.myblog.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.annotation.WebListener;
/*
 * @ClassName: ServletContextAttributeListener 
 * @Description: TODO
 * @author: Gwen
 * @date: 2018年2月1日 下午7:54:23
 * 添加、删除或者替换一个属性的时候，将会通知ServletContextAttributesListener
 */
@WebListener
public class ServletContextAttributeListener implements javax.servlet.ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub

	}

}
