package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.omg.IOP.Codec;


public class CharsetFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		System.out.println("进入charsetFilter");
		System.out.println("1."+request.getRequestURI());
		arg0.setCharacterEncoding("utf-8");
//		arg1.setCharacterEncoding(code);//不起作用or生效比println慢
		arg1.setContentType("text/html;charset="+code);//必须用text/html
		arg2.doFilter(arg0, arg1);
		System.out.println("出去charsetFilter");

	}

	private String code;
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		code = arg0.getInitParameter("code");
	}

}
