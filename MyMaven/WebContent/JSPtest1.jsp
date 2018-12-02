<%@page import="com.suguowen.blog.service.BoardService"%>
<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<link rel="stylesheet" href="resource/bookstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="resource/bookstrap/js/bootstrap.min.js"></script>
<style type="text/css">
#canvas {
	border: 1px solid #ADACB0;
	display: block;
	margin: 20px auto;
}
</style>
</head>
<body>
	<%
		BoardService bs = BoardService.getInstance();
		Map<Integer,String> map = bs.colorMap();	
		int[][] chessBoard = bs.buildBoard(Integer.parseInt(request.getParameter("tr")), Integer.parseInt(request.getParameter("tc")), Integer.parseInt(request.getParameter("size")));
		int size = Integer.parseInt(request.getParameter("size"));
	%>
	<canvas id="canvas" width="1600" height="1600"> 你的浏览器还不支持canvas </canvas>
	<div id="div1"></div>
</body>
<script type="text/javascript">
	var canvas = document.getElementById("canvas");
	var context = canvas.getContext("2d");
	var varRandomColor;
	var test;
	var vari;
	var varj;

	
	alert(varRandomColor);
/* 	for(k in varRandomColor){
		alert(varRandomColor.k);
	} */
	
/* 	var res = ${board};
	for(r in res){
		for(t in res[r]){
			alert(res[r][t]);
		}
	} */
	
<%-- 	<%for (int i = 0; i < size; i++) {
		for (int j = 0; j < size; j++) {%>
		
		
		test =<%=chessBoard[i][j]%>;
		vari = 100*<%=i%>;
		varj = 100*<%=j%>;
		document.write(varRandomColor);
 		varRandomColor = "<%=map.get(chessBoard[i][j])%>";
		document.write(varRandomColor);
		
		
	 	context.fillStyle = varRandomColor;
		context.fillRect(vari, varj, 100, 100); 
			<%}%>
	<%}%> --%>
<%-- <%for (int i = 0; i < 8; i++) {
	for (int j = 0; j < 8; j++) {%>
		//0赋一种颜色
		//1-n赋n种颜色	
	test =<%=chessBoard[i][j]%>;
 	varColorMap = "<%=map.get(chessBoard[i][j])%>";
	vari = 100*<%=i%>;
	varj = 100*<%=j%>;
  	context.fillStyle = varColorMap;
	context.fillRect(vari, varj, 100, 100);  
	
	//System.out.print(board[i][j] + "\t");
<%}%>
	//System.out.println("\n");
<%}%> --%>
	
</script>
</html>