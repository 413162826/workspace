<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>登陆成功!</h1>
        欢迎您:
        <% out.println(session.getAttribute("username"));
        %> <br>
        <img src="../../resource/images/welcome.jpg" width="157" height="143" alt="welcome"/>
    </body>
</html>
