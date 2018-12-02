package com.suguowen.blog.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.suguowen.blog.service.BoardService;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/BoardServlet1")
public class BoardServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Gson实现array，map传输到javascript
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		//index.html拿tr,tc,size
		int dr = Integer.parseInt(request.getParameter("tr"));
		int dc = Integer.parseInt(request.getParameter("tc"));
		int size = Integer.parseInt(request.getParameter("size"));

//		从service把board、map传Board.jsp
		BoardService bs = BoardService.getInstance();
//		request.setAttribute("board",bs.buildBoard(dr, dc, size));
//		request.setAttribute("map", bs.colorMap());
		
//		bs.colorMap().put(1, 100);
		
		Gson g = new Gson();
		String jsonBoard = g.toJson(bs.buildBoard(dr, dc, size));
		String jsonMap = g.toJson(bs.colorMap());
		request.setAttribute("board", jsonBoard);
		request.setAttribute("map", jsonMap);

		
		request.getRequestDispatcher("/JSPtest1.jsp").forward(request, response);
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
