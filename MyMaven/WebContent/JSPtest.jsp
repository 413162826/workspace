<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	c:set标签：
	<c:set var="varName" value="foo" scope="session" />
	<br> c:out标签：
	<c:out value="${varName}" default="default value" />
	<br> if标签：
	<c:if test="${varName=='foo'}">
if输出
</c:if>
	<br> if-else标签：
	<c:choose>
		<c:when test="${empty param.username}">
no user
</c:when>
		<c:when test="${1==1}">
invalid section
</c:when>
		<c:otherwise>
otherwise
</c:otherwise>
	</c:choose>
	<br> foreach标签:
	<c:forEach var="i" begin="1" end="3">
item is: <c:out value="${i}" />
	</c:forEach>
	<br> c:forTokens标签：
	<c:forTokens items="Zara,nuha,roshy" delims="," var="name">
		<c:out value="${name}" />
	</c:forTokens>
</body>
</html>
