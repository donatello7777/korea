<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ include file="top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="2" width="300px" align="center">
	<caption>출력화면</caption>
		<tr>
			<th>이름</th><th>국어</th><th>영어</th><th>수학</th><th>나이</th>
		</tr>
		<tr>
		<c:forEach items="${list}" var="my">
		</tr>
		<tr>
			<td>${my.name}</td>
			<td>${my.kor}</td>
			<td>${my.eng}</td>
			<td>${my.mat}</td>
			<td>${my.age}</td>
		</tr>
		</c:forEach>
</table>
</body>
</html>