package controler;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import service.UserService;

//urlPattern相当于配置了xml

@WebServlet(name="loginServlet",urlPatterns= {"/loginServlet"},initParams= {@WebInitParam(name="account",value="Gwen")})
public class LoginServlet extends HttpServlet{
	
	UserService u = UserService.getInstancestance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req传来账号密码，账号--密码---成功登陆
		String account = req.getParameter("account");
		String password = req.getParameter("password");
		
		Map map = u.doLogin(account,password);//把账号密码交给dao判断
		if (map.get("flag")=="-1") {
			//账户名错误
			resp.getWriter().println("账号不存在！！");
			
		}else if (map.get("flag")=="-2") {
			//登陆失败
			resp.getWriter().println("密码错误！！");

		}else if (map.get("flag")=="1") {
			//登陆成功,设置已登录
			resp.getWriter().println("登陆成功！！");
			HttpSession session =req.getSession();
			session.setAttribute("user", "已登录");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
