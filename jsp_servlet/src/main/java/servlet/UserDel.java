package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suguowen.service.UserService;

/**
 * Servlet implementation class UserDel
 */
public class UserDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置编码
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");  //解决中文乱码问题
				request.setCharacterEncoding("utf-8");
				
				UserService userService = new UserService();
				PrintWriter pw = response.getWriter();
				//检验数据正确性
				//乱码：new String(name.getBytes("ISO8859-1"),"UTF-8");
				String id = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
				String result = userService.del(Integer.parseInt(id));
				System.out.println(result);
				pw.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
