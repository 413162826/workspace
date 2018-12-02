package controler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class inputFileServlet2
 * 同步上传，下载文件
 */
@WebServlet("/inputFileServlet4")
public class inputFileServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public inputFileServlet4() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
//		ServletFileUpload fileUpload = new ServletFileUpload(factory);
//		try {
//			List<FileItem> list = fileUpload.parseRequest(request);
//			for(int i=0;i<list.size();i++) {
//				if(list.get(i).isFormField()) {
//					String userName = list.get(i).getString("UTF-8");//解决中文乱码问题
//					System.out.println(userName);
//				} else {
//					System.out.println(list.get(i).getContentType());
//					System.out.println(list.get(i).getFieldName());
//					System.out.println(list.get(i).getName());
//					System.out.println(list.get(i).getSize());
//					
//					//储存到服务器
//					list.get(i).write(new File("E://img"));
//					
//					//把相对服务器存储路径连同个人信息保存到数据库
//					
//					//反馈，告诉用户是否提交陈宫
//					
//				}
//			}
//		} catch (FileUploadException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
