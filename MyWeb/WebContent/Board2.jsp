<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@page import="com.suguowen.blog.model.Board"%>
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
		Board bd = new Board();
		bd.chessBoard(0, 0, 2, 2, 8);
		int[][] chessBoard = bd.getBoard();
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

/* 	//使用fillRect方法，直接绘制出填充的矩形；
	context.fillStyle = "#1424DE";
	context.fillRect(200, 0, 200, 200);

	//使用strokeRect方法
	context.fillStyle = "#080808";
	context.fillRect(400, 0, 200, 200); */
<%for (int i = 0; i < 8; i++) {
	for (int j = 0; j < 8; j++) {%>
	
	
	test =<%=chessBoard[i][j]%>;
	vari = 100*<%=i%>;
	varj = 100*<%=j%>;
	varRandomColor = "<%=bd.randomColor()%>";
	
 	context.fillStyle = varRandomColor;
	context.fillRect(vari, varj, 100, 100); 
	
	//System.out.print(board[i][j] + "\t");
<%}%>
	//System.out.println("\n");
<%}%>
	
</script>
</html>