<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
<h1>제목</h1>
<table border="1">
<tr>
	<td colspan="4"><a href="${root }/board_Free/write.do">게시물 쓰기</a> <br /></td>
</tr>

<tr>
	<td>번호</td>
	<td>제목</td>
	<td>작성자</td>
	<td>조회수</td>	
</tr>


<c:if test="${boardPage.hasNoBoards() }">
<tr>
	<td colspan="4">게시글이 없습니다.</td>
</tr>
</c:if>

<c:forEach var="board_Free" items="${boardPage.content }">
<tr>
	<td>${board_Free.number }</td>
	
	<td>
	<a href="${root }/board_Free/read.do?no=${board_Free.number }&pageNo=${boardPage.currentPage }">
	<c:out value="${board_Free.title }"/>
	</a>
	</td>
	
	<td>${board_Free.writer.name }</td>
	<td>${board_Free.readCount }</td>
</tr>
</c:forEach>

<c:if test="${boardPage.hasBoards() }">
<tr>
	<td colspan="4">
	
		<c:if test="${boardPage.startPage > 5 }">
		<a href="${root }/board_Free/list.do?pageNo=${boardPage.startPage - 5 }">[이전]</a>
		</c:if>
		<c:forEach var="pNo" begin="${boardPage.startPage }" end="${boardPage.endPage }">
		<a href="${root }/board_Free/list.do?pageNo=${pNo }">[${pNo }]</a>
		</c:forEach>
		
		<c:if test="${boardPage.endPage < boardPage.totalPages }">
		<a href="${root }/board_Free/list.do?pageNo=${boardPage.startPage + 5}">[다음]</a>
		</c:if>
	</td>
</tr>
</c:if>
</table>

</body>
</html>