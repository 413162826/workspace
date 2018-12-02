<%-- <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="/simpletag" prefix="mytagdesp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	你的ip是:<mytagdesp:viewIP></mytagdesp:viewIP>
</body>
</html> --%>



<%-- <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="mytagdesp" uri="/simpletag" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><title>Hello World</title>
    </head>
    <body bgcolor=“#ffffff”>     bgcolor已过时
    hello
        <h1>使用创建的标记文件</h1>
        <mytagdesp:TableTag author="Robin" title="精通NetBeans" />
        <mytagdesp:TableTag author=“Apple” title=“精通Java Me开发" price_info="54.6"/>
    </body>
</html>   --%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Login</title>
    </head>
<body>
        <h1>请登录系统!</h1>
        <form name="form" action="logincheck.jsp">
            用户:
            <input type="text" name="username" value="Robin" />
            <br>
            密码:
            <input type="password" name="password" value="" />
            <p></p>
            <input type="submit" value="确认" name="submit" />
            <input type="reset" value="重置" name="reset" />
        </form>
        <jsp:useBean id="user" scope="page" class="login.LoginBean" >	 
		</jsp:useBean>
        
    </body>
</html> 
