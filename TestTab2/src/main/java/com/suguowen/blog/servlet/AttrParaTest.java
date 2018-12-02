package com.suguowen.blog.servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/attrParaTest")
public class AttrParaTest extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * 1.怎么拿请求响应头的任何信息    请求头成功
		 * 2.怎么拿url的变量信息		getParameter
		 * 3.怎么往请求头设置信息		无法
		 * 4.怎么往url设置变量		无法
		 * 5.设置session，设置cookie	session.setAttribute resp.addCookie
		 * 6.查看session，查看cookie	req.getRequestSessionId req.getCookies
		 */
		resp.setContentType("text/html;charset=utf-8");
		
		req.getParameter("");//1.拿请求头的信息
		//2.响应头的信息应该不能拿吧，还没设置
		//3.i dont know
		req.setAttribute("", "");//4.往url设置信息
		//5.i dont know
		req.getSession();//6.查看session
		req.getCookies();//6.查看cookie
		
//		System.out.println(req.getMethod());
		//获得请求头信息
//		Enumeration<String> enums = req.getHeaderNames();
//		String enumName;
//		while(enums.hasMoreElements()) {
//			enumName = enums.nextElement();
//			System.out.println(enumName+":"+req.getHeader(enumName));
//		}
		
		//获取路径
//		System.out.println(req.getRequestURI());//	/TestTab2/attrParaTest
//		System.out.println(req.getRequestURL());//	http://localhost:8080/TestTab2/attrParaTest
//		System.out.println(req.getContextPath());//	/TestTab2
//		System.out.println(req.getServletPath());//	/attrParaTest
		
		//getParameter获取url的值，getAttribute拿setAttribute
//		System.out.println(req.getParameter("name"));//name
//		System.out.println(req.getAttribute("number"));//null
//		
//		req.setAttribute("evil", "i am evil");
//		
//		System.out.println(req.getParameter("evil"));//null
//		System.out.println(req.getAttribute("evil"));//i am evil
		
		//重定向拿不到，转发拿到
//		resp.sendRedirect("sendRedirectPage.jsp");
//		req.getRequestDispatcher("sendRedirectPage.jsp").forward(req, resp);
		
		System.out.println(req.getRequestedSessionId());
		HttpSession httpSession =  req.getSession();
		httpSession.setAttribute("name", "suguowen");//cookie行不会增加name
		System.out.println(httpSession.getAttribute("name"));
				
		Cookie cookieName = new Cookie("name", "suguowen");
		cookieName.setPath(req.getContextPath());
		resp.addCookie(cookieName);//cookie增加了name
		System.out.println(req.getContextPath());
		//输出所有cookies
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			System.out.println(cookie.getName());
			System.out.println(cookie.getValue());
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
	}
	
}
