<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	pageContext.setAttribute("path", request.getContextPath());
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- bootstrap-->
<script src="${path}/static/bootstrap-3.3.7-dist/jquery.min.js"></script>
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<link href="${path}/static/bootstrap-3.3.7-dist/css/bootstrap.css"
	rel="stylesheet">
<script src="${path}/static/bootstrap-3.3.7-dist/jquery.min.js"></script>
<script src="${path}/static/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
<link
	href="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/css/bootstrap-datepicker3.css"
	rel="stylesheet">
<script
	src="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/js/bootstrap-datepicker.js"></script>
<script
	src="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/locales/bootstrap-datepicker.zh-CN.min.js"></script>

<link
	href="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/css/test.css"
	rel="stylesheet" />
<script
	src="${path}/static/bootstrap-3.3.7-dist/bootstrap-datepicker-master/dist/js/test.js"></script>

</head>
<body>
	<div class="form-group">
		<label class="form-group-title">日期范围</label>
		<div class="input-group date">
			<input name="startDate" class="form-control date-picker form-control-left" /> 
		</div>
	</div>
	<span id = "old1">this is test1</span> 
	<span id = "old2">this is test2</span> 
	<span id = "old3"></span> 
	<span id = "old4">this is test4</span> 
	<button id = "button1">Pick ME</button>
<script type="text/javascript">
$('span').replaceWith(function(){
	  return $("<input />").append($(this).contents());
	});
	
	function A(){
		var a = $("#old1").text();	
		alert(a);
	}

	$(document).on("click", "#button1", function() {
		A();
	})
</script>

</body>
</html>