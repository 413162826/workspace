package com.mashen.myblog.filter;

import java.io.IOException;
import java.net.URL;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mashen.myblog.model.User;

@WebFilter("/*")
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("进入过滤器2");	
		HttpServletRequest request = (HttpServletRequest) arg0;//孩子可以强制转换为父亲、内存问题，儿子包含父亲
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (!uri.contains("login.html") && !uri.contains("loginServlet") && !uri.contains("resourse")&& !uri.contains("yzCodeServlet")) {
			HttpSession session = request.getSession();
			User userInfo = (User)session.getAttribute("user");
			if (userInfo!=null) {
				arg2.doFilter(arg0, arg1);//寻找下一个过滤器，如果没有呀，就是我们的访问的目标资源
			}else {
				response.sendRedirect("login.html");
			}
		}else {
			arg2.doFilter(arg0, arg1);//寻找下一个过滤器，如果没有，就是我们访问的目标资源

		}
		System.out.println("出去过滤器2");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
