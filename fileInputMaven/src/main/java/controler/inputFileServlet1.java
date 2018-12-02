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

/**
 * Servlet implementation class inputFileServlet2
 * 同步上传，下载文件
 */
@WebServlet("/inputFileServlet1")@MultipartConfig
public class inputFileServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public inputFileServlet1() {
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
		response.setContentType("text/html;charset=utf-8");
		Part file = request.getPart("file");//获取文件
		System.out.println(file.getName()+"    "+file.getSubmittedFileName()+"    "+file.getContentType());
		String newFileName = UUID.randomUUID()+file.getSubmittedFileName();//新文件名
		String url = request.getServletContext().getRealPath("/resource/myImage/")+newFileName;//
		System.out.println(url);
		file.write(url);//把图片存在disk
	}

}
