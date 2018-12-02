package com.mashen.myblog.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.omg.CORBA.ARG_OUT;

import com.sun.org.apache.bcel.internal.classfile.Code;

@WebFilter(value="/*",initParams= {@WebInitParam(name="code",value="utf"
		+ "-8")})
public class CharsetFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("进入过滤器1");
		//过滤器的作用：在过滤器写的任何代码，任何把过滤器注册那所有类都会执行这段代码
		arg0.setCharacterEncoding(code);
		arg1.setContentType("text/html;charset=utf-8");//浏览器显示格式
		arg1.setCharacterEncoding("utf-8");
//		request.setCharacterEncoding("gbk");//中文接收
//		response.setContentType("text/html;charset=utf-8");//浏览器显示格式
//		response.setCharacterEncoding("utf-8");
		
		arg2.doFilter(arg0, arg1);
		System.out.println("出去过滤器1");
		
	}

	private String code;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		code = arg0.getInitParameter("code");//通过在filter的init配置编码实现动态编码、
		ServletContext  a = arg0.getServletContext();
		a.setAttribute("filter", "-servletContext-");
	}

}
