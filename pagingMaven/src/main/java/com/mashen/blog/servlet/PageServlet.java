package com.mashen.blog.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mashen.blog.model.PageBean;
import com.mashen.blog.service.UserService;

/**
 * Servlet implementation class PageServlet
 */
@WebServlet("/pageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int currentPage;//无值默认1，有则从网页取值
		if(request.getParameter("pageNum")==null) {
			currentPage = 1;
		}else {
			currentPage=Integer.parseInt(request.getParameter("pageNum"));//从网页得到的当前页码
		}
		int pageSize = 2;//设定显示记录数
		
		UserService us = UserService.getInstance();
		PageBean pb = us.findAllUserByPage(currentPage, pageSize);//当前页，记录数，总页数
		request.setAttribute("pageBean", pb);//页面设置属性
//		System.out.println(pb.getUlist().get(0));
		request.getRequestDispatcher("/Page1.jsp").forward(request, response);//传回页面
	}

}
