package controler;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mysql.fabric.Response;

@WebServlet("/fileServlet")@MultipartConfig
public class FileServlet extends HttpServlet{
	//原始异步上传功能
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//访问这个类之要判断是否有userInfo，如果有则进入，无则弹出。
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Part file = req.getPart("file");//获取文件
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getSubmittedFileName());
		
		//E:\mashen\TOMCAT\apache-tomcat-8.0.28\webapps\aaa\resource\myImage\1.jpg
		//System.out.println(req.getServletContext().getRealPath("/resource/myImage/")+file.getSubmittedFileName());
		String newFileName = UUID.randomUUID()+file.getSubmittedFileName();
		
		String url = req.getServletContext().getRealPath("/resourse/myImage/")+newFileName;
		System.out.println(url);
		file.write(url);//把图片存在disk
		
//		UUID.randomUUID();//生成唯一ID
		
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().println("/ccc/resourse/myImage/"+newFileName);
//		resp.getWriter().println(url);

		
	}
	
}
