package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.suguowen.bean.Pages;
import com.suguowen.bean.User;
import com.suguowen.service.UserService;

/**
 * 通过前端返回的result，来进行分页
 * select t2.* 
 * from (select t1.*,rownum as rn 
 * from table_name t1 where 1=1 and rownum <= page * page_size) t2 
 * where t2.rn > (page - 1) * page_size;
 * 
 * page当前页，pagesize是每页几条
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //解决中文乱码问题
		request.setCharacterEncoding("utf-8");
		
		ObjectMapper om = new ObjectMapper();
		JavaType javaType = om.getTypeFactory().constructParametricType(ArrayList.class, User.class);

		String jsonString = request.getParameter("conditions");

		System.out.println(request.getParameter("pn") + "," + jsonString);
		ArrayList<User> uList = om.readValue(jsonString,javaType);
		
		
		String strPage = request.getParameter("pn");//通过url获取当前页数
		UserService userService = new UserService();
		ArrayList<User> newList = null;
		Pages  myPages = null;

		int Page = 1;
		if (request.getSession().getAttribute("myPages") == null) {//myPage对象存放session
			myPages = new Pages();
			ArrayList<User> list = uList;
			int recordCount = list.size();
			int pagesize = 5;//？？？为什么是12，12条数据
			myPages.setRecordCount(recordCount);
			myPages.setPagesize(pagesize);
			myPages.setList(list);
			int maxPage = myPages.getMaxPage();
			myPages.setMaxPage(maxPage);
			newList = myPages.getInitPage(list, 1, pagesize);//？？？ 初始化分页信息，即获取到存在数据库中的list,同时获取到首页数据
		} else {
			myPages = (Pages) request.getSession().getAttribute("myPages");
			Page = myPages.getPage(strPage);
			newList = myPages.getAppointPage(Page);// 获取当前页数据
		}
		myPages.setPage(Page);
		request.setAttribute("myPages", myPages);
		request.setAttribute("ItemsList", newList);
		response.sendRedirect("UserList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}


