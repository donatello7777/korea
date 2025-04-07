<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="top.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="save" method="post">
<table border="1" width="300px" align="center">
	<caption>스프링자료입력</caption>
		<tr>
			<th>이름</th>
			<td>
		    <input type="text" name="name">
			</td>
		</tr>
		<tr>
			<th>국어</th>
			<td>
		    <input type="text" name="kor">
			</td>
		</tr>
		<tr>
			<th>영어</th>
			<td>
		    <input type="text" name="eng">
			</td>
		</tr>
		<tr>
			<th>수학</th>
			<td>
		    <input type="text" name="mat">
			</td>
		</tr>
		<tr>
			<th>나이</th>
			<td>
		    <input type="text" name="age">
			</td>
		</tr>
		<tr style="text-align: center;">
			<td colspan="2"><input type="submit" value="전송">
							<input type="reset" value="취소">
			</td>
		</tr>
</table>
</form>
</body>
</html>