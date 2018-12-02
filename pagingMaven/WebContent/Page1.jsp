<%@page import="javax.crypto.interfaces.PBEKey"%>
<%@page import="com.mashen.blog.model.User,com.mashen.blog.model.PageBean"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="resource/js/jquery.min.js"></script>
<link rel="stylesheet" href="resource/bookstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="resource/bookstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<form action="pageServlet" method="post">
		<%
			PageBean pb = (PageBean) request.getAttribute("pageBean");
		%>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>UserName</th>
					<th>ID</th>
				</tr>
			</thead>
			<tbody>
				<!-- Java代码循环输出行 -->
				<%int i = 2*(pb.getCurrentPage()-1); %>
				<%
					for (; i < pb.getPageSize(); i++) {
				%>
				<tr>
					<th scope="row">1</th>
					<td><%=pb.getUlist().get(i).getUserName()%></td>
					<td><%=pb.getUlist().get(i).getId()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<nav aria-label="Page navigation">
		<ul class="pagination">
			<li><a href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<%for(int j=1;j<=pb.getTotalPage();j++){ %>
			<%String url = request.getContextPath()+"/pageServlet?pageNum="+j; %>
			<li><a href=<%=url %>><%=j%></a></li>
			<%} %>
			<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
		</nav>
		总页数:<%=pb.getTotalPage() %>
		当前页<%=pb.getCurrentPage() %>
	</form>
</html>