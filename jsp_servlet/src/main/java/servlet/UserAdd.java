package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suguowen.bean.User;
import com.suguowen.service.UserService;

/**
 * 
 * 增加用户(后端检验前端传来的数据是否正确)
 * @author suguowen
 * @date 2018/6/15
 */
public class UserAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		
		UserService userService = new UserService();
		PrintWriter pw = response.getWriter();
		//检验数据正确性
		//乱码：new String(name.getBytes("ISO8859-1"),"UTF-8");
		String id = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
		String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
		String birth = new String(request.getParameter("birth").getBytes("ISO8859-1"),"UTF-8");
		String sex = new String(request.getParameter("sex").getBytes("ISO8859-1"),"UTF-8");
		String hobby = request.getParameter("hobby");//new String(request.getParameter("hobby").getBytes("ISO8859-1"),"UTF-8");
		String school = request.getParameter("school");//new String(request.getParameter("school").getBytes("ISO8859-1"),"UTF-8");
		System.out.println("id:"+ new String(id.getBytes("ISO8859-1"),"UTF-8")+",name:"+new String(name.getBytes("ISO8859-1"),"UTF-8")+",birth:"+new String(birth.getBytes("ISO8859-1"),"UTF-8") + ",sex:" + new String(sex.getBytes("ISO8859-1"),"UTF-8") + ",hobby:" + new String(hobby.getBytes("ISO8859-1"),"UTF-8") + ",school:" + new String(school.getBytes("ISO8859-1"),"UTF-8"));
		
		//检验用户信息
		userService.addCheck(id, name, birth,sex,hobby,school);
       //构造用户
		User uu = new User(Integer.valueOf(id), name, birth,sex,hobby,school);
		//System.out.println(uu.getId()+"," + uu.getName() + "," + uu.getBirth());
		
		//插入数据库
		String result = userService.add(uu);
		//System.out.println(result);
		pw.println(result);
		//正确返回成功，错误返回失败
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
