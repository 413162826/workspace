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
        <jsp:useBean id="user" scope="page" class="com.suguowen.homework.dao.LoginBean" >	 
		</jsp:useBean>
        
    </body>
</html>
