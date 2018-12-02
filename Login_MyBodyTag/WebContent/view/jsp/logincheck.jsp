<%@taglib prefix="login" uri="/WEB-INF/tlds/BodyLogin.tld" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="password" value="${param.password}" />
<c:set var="username" value="${param.username}" />

<login:LoginBodyTagHandler username="${username}" password="${password}">
     <strong> In tag body </strong>
</login:LoginBodyTagHandler>

<%-- The below JSP codes can be alternatively deleted. See the outcome of running. --%>
<c:set var="loginsuccess" value="${pageScope.success}" />
<c:choose> <c:when test="${loginsuccess=='true'}">
                          <c:set var="username" value="${username}" scope="session"/>
                          <c:redirect url="welcome.jsp" />
                     </c:when>
                     <c:otherwise> <c:redirect url="error.jsp" /></c:otherwise>
</c:choose>

<%-- <%@page contentType="text/html; charset=GBK" %>
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
<% } %> --%>
