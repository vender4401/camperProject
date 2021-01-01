<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>

<u:navbar />
<div class="text-center">
<h1>FREE COMMUNITY</h1>
<p>자유롭게 글을 작성 할수 있는 공간 입니다.</p>
</div>


<div class="container-fluid max-width text-center">
<table class="table table-hover">

<thead>
<tr>
	<td><i class="fas fa-sign"></i></td>
	<td><i class="fas fa-list"></i></td>
	<td><i class="far fa-id-badge"></i></td>
	<td><i class="fab fa-cloudscale"></i></td>	
</tr>
</thead>

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
	<c:if test="${board_Free.replyCount > 0 }" >
	<i class="fab fa-replyd"></i> ${board_Free.replyCount }
	</c:if>
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


	<i class="fas fa-pen-square fa-2x"><a href="${root }/board_Free/write.do"> 글 쓰기</a></i><br />

</div>

</body>
</html>