<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" errorPage="errorPage.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>     

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

 <jsp:include page="head.jsp"></jsp:include>
	hello
<jsp:include page="bottom.jsp"></jsp:include> 

<jsp:useBean id="bean1" class="com.suguowen.blog.model.TabBean" ></jsp:useBean>
<jsp:setProperty property="tabName" name="bean1" value="haha tab"/>
<jsp:getProperty property="tabName" name="bean1"/>

<c:set var="var1" value="suguowen"></c:set>
<c:set var="var2" value="suguowen2"></c:set>
<c:out value="${var1 }"></c:out> 

<c:choose>
<c:when test="${var1==var2 }">when is true</c:when>
<c:when test="${var1!=var2 }">when is false</c:when>
<c:otherwise>不存在的otherwise</c:otherwise>
</c:choose>

<c:if test="${var1=='suguowen' }" >if1 is true</c:if>
<br>
<c:if test="${var1!=var2 }" >
	if2 is false
</c:if>
<br>

<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/><p>
</c:forEach>
<%-- 	<%int a = 1/0; %> --%>
</body>
</html>