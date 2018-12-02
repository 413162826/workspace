package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("进入loginFilter");
		
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		String uri = request.getRequestURI();//项目名+路径
		System.out.println(uri);
		if (!uri.contains("/index.html")&&!uri.contains("/resourse")&&!uri.contains("/loginServlet")) {
			HttpSession session = request.getSession();
			String userInfo = (String)session.getAttribute("user");
			if (userInfo==null) {
				//未登陆，弹出登陆页面
				response.sendRedirect("index.html");
			}else {
				arg2.doFilter(arg0, arg1);
			}
		}else {
			arg2.doFilter(arg0, arg1);
		}
		
		System.out.println("出去loginFilter");
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
