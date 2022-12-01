<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/ress/dist/ress.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/css/style.css">
<title>迷路ゲーム</title>
</head>
<body>

	<c:forEach var="y" items="${viewMap}" varStatus="s">
		<p>
			<c:forEach var="x" items="${y}">${x}</c:forEach>
			<c:if test="${s.index == 2}">
			&emsp;<a href="/Maze/MapServlet?direction=up">↑</a>
			</c:if>
			<c:if test="${s.index == 3}">
			<a href="/Maze/MapServlet?direction=left">←</a>&emsp;<a href="/Maze/MapServlet?direction=right">→</a>
			</c:if>
			<c:if test="${s.index == 4}">
			&emsp;<a href="/Maze/MapServlet?direction=down">↓</a>
			</c:if>
		</p>
	</c:forEach>
</body>
</html>