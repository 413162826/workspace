package com.suguowen.blog.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		//login系统
//		int result = registerService.isUser(userName, password);
//		if (result == 1) {
//			registerService.sendMail(mail);
//			response.getWriter().println("注册成功,正在给您发送邮件... ...");
//			
//		}else if (result == -1) {
//			response.getWriter().write("<script languge=javascript>alert('账户名不符合规则... ...')</script>");
//			response.getWriter().write("<script languge=javascript>alert('正在为您跳转到注册页面... ...')</script>");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			response.getWriter().write("<script>window.location ='http://localhost:8080/JAVAMail/Register.jsp'</script>");
//		}else if(result == -2) {
//			response.getWriter().write("<script languge=javascript>alert('密码不符合规则... ...')</script>");
//			response.getWriter().write("<script languge=javascript>alert('正在为您跳转到注册页面... ...')</script>");
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			response.getWriter().write("<script>window.location ='http://localhost:8080/JAVAMail/Register.jsp'</script>");
//			
//		}else {
//			response.getWriter().println("未知错误... ...");
//		}	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
