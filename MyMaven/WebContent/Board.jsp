<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@page import="com.suguowen.blog.model.BoardBean"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<!-- 卡在了javascipt不能迭代el表达式传过来的map。array -->
<%--  面板：${board[1][1]}
地图：${map.get(board[1][1]) }  --%>

	<canvas id="canvas" width="1600" height="1600"> 你的浏览器还不支持canvas </canvas>
	<div id="div1"></div>
	


</body>
<script type="text/javascript">
	
	var canvas = document.getElementById("canvas");
	var context = canvas.getContext("2d");
	var varRandomColor;
	var varSize
	var vari;
	var varj;
	
	${map.1}
	${map.2}
	${map.3}
	
/* 	var test0 = "${map.get(board[1][1])}";
	var test1 = "${map.get(board[1][2])}";
	var test2 = "${map.get(board[1][3])}";
	alert(test0);
	alert(test1);
	alert(test2); */
	
/* 	var count = 0;
	for ( ${board} in iterable) {
		varRandomColor = ${board[count]};
 		context.fillStyle = varRandomColor;
 		context.fillRect(vari, varj, 100, 100);
		count++;
	} */

/*   	for (var i = 0; i < 8; i++) {
		for (var j = 0; j < 8; j++) {
			vari = 100*i;
			varj = 100*j;
			varRandomColor = "${map.get(board["+i+"]["+j+"])}";//  map/chessBoard
	 		context.fillStyle = varRandomColor;
	 		context.fillRect(vari, varj, 100, 100);
		}
	}    */

	
<%--  	<%for (int i = 0; i < 8; i++) {
		for (int j = 0; j < 8; j++) {%>
		
		vari = 100*<%=i%>;
		varj = 100*<%=j%>;	
 		varRandomColor = "<%=map.get(chessBoard[i][j])%>";//  map/chessBoard
 		
 		context.fillStyle = varRandomColor;
 		context.fillRect(vari, varj, 100, 100);
		<%}%>
	<%}%>  --%>
	
</script>
</html>