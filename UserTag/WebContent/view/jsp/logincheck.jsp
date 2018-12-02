<%@page contentType="text/html; charset=GBK" %>
<%@page import="com.suguowen.homework.dao.LoginBean" %>

<jsp:useBean id="user" class="com.suguowen.homework.dao.LoginBean" scope="page">
    <jsp:setProperty name="user" property="*"/>
</jsp:useBean>
<% if (user.checklogin()) {
            String username = request.getParameter("username");
            session.setAttribute("username",username );
%>r
username:<jsp:getProperty name="user" property="username"/>
password:<jsp:getProperty name="user" property="password"/>
<jsp:forward page = "welcome.jsp"></jsp:forward>
<% } else { %>
<jsp:forward page = "error.jsp"></jsp:forward>
<% } %>
