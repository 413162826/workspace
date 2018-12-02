package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suguowen.service.UserService;

/**
 * 
 * 查询User:模糊匹配
 * @author 苏国文
 * @date 2018-6-21
 */
public class UserSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");  //解决中文乱码问题
		
		UserService userService = new UserService();
		PrintWriter pw = response.getWriter();

		String id = new String(request.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
		String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
		String school = new String(request.getParameter("school").getBytes("ISO8859-1"),"UTF-8");
		String page = new String(request.getParameter("page").getBytes("ISO8859-1"),"UTF-8");
/*		System.out.println(id.equals(""));//02 f  null t
		System.out.println(id == "");//02 f  null f
		System.out.println(id != "");//02 t null t
		System.out.println(id == null);//02 f null f
		System.out.println(id != null);//02 t null t
*/		
		//System.out.println("id:" + id + "," + "name:" + name + "," + "school:" + school + "," + "page" + page);
		String result = userService.selectUserByPattern(id,name,school,Integer.parseInt(page));
		String[] resultArray = result.split("],");
		String uList = resultArray[0] + "]";
		String count = resultArray[1];
		//System.out.println(uList+","+count);
		if (result.equals("[]")) {
			System.out.println("没有此用户");
		}else {
			//System.out.println(result);
		}
		pw.println("{'key1':'"+count+"','key2':'"+uList+"'}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
