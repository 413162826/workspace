/**   
 * Copyright © 2018 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * @Package: hello 
 * @author: Gwen   
 * @date: 2018年1月24日 下午4:46:07 
 */
package hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/** 
 * @ClassName: Servlet1 
 * @Description: TODO
 * @author: Gwen
 * @date: 2018年1月24日 下午4:46:07  
 */
public class Servlet1 extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=utf-8");
//		resp.sendRedirect("../index.jsp");//一个http响应，重定向到另一个url、servlet、jsp.
		resp.getWriter().write("你好");
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");//这行代码必须在getParameter第一次调用前使用才有效果，网页底层使用iso编码
//		req.getRequestDispatcher("url").forward(req, resp);//内部跳转，完成HTML的静态拼接
		String title = req.getParameter("title");//找url里面的参数名得到值
		String body = req.getParameter("body");
		System.out.println(title+","+body);
		//get方式不要用来传输中文
		//如果你非要用get方式传输中文，那就先用js先对中文进行转码，然后在后端用java进行解码。
		
		 
	}
	
}
