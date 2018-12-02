<%@page import="com.mashen.blog.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath }/resource/bookstrap/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript " src="${pageContext.request.contextPath }/resource/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/bookstrap/js/bootstrap.min.js"></script>
<title>更新功能</title>
</head>
<body>
	
	<div class="panel panel-primary"  style="width:300px;paddind:10px;margin-left:300px">
			<div class="panel-heading">用户登录</div>
			<form action=userUpdateServlet method="post"> 
			<input type="hidden" value="doUpdate" name="flag">
			<input type="hidden" value="${requestScope.user.id }" name="userId" >
		  <div class="form-group">
		    <label for="exampleInputEmail1">账号名</label>
		    <input value="${user.userName}" name="userName"  type="text" class="form-control" id="exampleInputEmail1" placeholder="Email">
		
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">密码</label>
		    <input value="${user.password }" name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
		  </div>
		  
			
		  <button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>

</body>
</html>