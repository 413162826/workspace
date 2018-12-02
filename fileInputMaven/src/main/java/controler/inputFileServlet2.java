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
 * um异步上传
 */
@WebServlet("/inputFileServlet2")@MultipartConfig
public class inputFileServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public inputFileServlet2() {
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
		Part file = request.getPart("upfile");//获取文件
		String newFileName = UUID.randomUUID()+file.getSubmittedFileName();//
		String url = request.getServletContext().getRealPath("/resource/myImage/")+newFileName;//
		System.out.println(url);
		file.write(url);//把图片存在disk
	    String result = "{\"name\":\""+ file.getName() +"\", \"originalName\": \""+ file.getSubmittedFileName() +"\", \"size\": "+ file.getSize() +", \"state\": \""+ "SUCCESS" +"\", \"type\": \""+ "jpg" +"\", \"url\": \"" + "/fileInputMaven/resource/myImage/" +newFileName +"\"}";
	    System.out.println(result);
	    response.getWriter().println(result);
	}

}
