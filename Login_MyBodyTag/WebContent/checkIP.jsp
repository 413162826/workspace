<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 坑爹玩意，放在tags包下面，没运行成功过，
放在web-inf下面，->/simpletag或者->WEB-INF/test.tld
 -->
<%@taglib uri="WEB-INF/tlds/test.tld" prefix="test" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	你的ip是:<test:viewIP/>
	<test:TableTag author="Robin" title="精通NetBeans" />
    <test:TableTag author="Apple" title="精通Mysql"  price_info="54.6"   />
</body>
</html>
