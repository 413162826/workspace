package com.suguowen.blog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.suguowen.blog.service.BoardService;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet(
		urlPatterns={
			"/BoardServlet2",
			"/Hello2"
		}
		)
public class BoardServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		//index.html拿tr,tc,size
//		int dr = Integer.parseInt(request.getParameter("tr"));
//		int dc = Integer.parseInt(request.getParameter("tc"));
//		int size = Integer.parseInt(request.getParameter("size"));

		//从service把board、map传Board.jsp
//		BoardService bs = BoardService.getInstance();
//		request.setAttribute("board",bs.buildBoard(dr, dc, size).toString());
//		request.setAttribute("map", bs.colorMap().toString());
		
//		List li = new ArrayList<>();
//		li.add(0, "su");
//		li.add(0, "guo");
//		li.add(0, "wen");
//		request.setAttribute("list", li);//test
		
		request.getRequestDispatcher("/JSPtest2.jsp").forward(request, response);
		//返回一个board
		//跳转到Boar.jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
