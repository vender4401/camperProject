<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
</head>
<body>
<table border="1">
	<tr>
		<td>번호</td>
		<td>${board_FreeData.board_Free.number }</td>		
	</tr>
	
	<tr>
		<td>작성자</td>
		<td>${board_FreeData.board_Free.writer.name}</td>
	</tr>
	
	<tr>
		<td>제목</td>
		<td>${board_FreeData.board_Free.title }</td>
	</tr>
	
	<tr>
		<td>내용</td>
		<td>${board_FreeData.board_Content.content }</td>
	</tr>
</table>
</body>
</html>