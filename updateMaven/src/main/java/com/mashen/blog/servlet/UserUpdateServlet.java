package com.mashen.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mashen.blog.model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//异步接收HTML传来的id
		String id = request.getParameter("id");
		System.out.println(id);
		
		String name = "Gwen";
		String password = "123456";
		String u = "{"+ "\"Name\":"+"\""+ name+ "\"," +  "\"Password\":"+"\""+password+"\""    +"}";
		response.setContentType("application/json");
		response.getWriter().println(u);
		
	}

}
