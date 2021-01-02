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
<h1>중고 장터</h1>
<p>중고 물품을 거래 하는 게시판 입니다.</p>
</div>


<div class="container-fluid max-width text-center">
<table class="table table-hover">

<thead>
<tr>
	<td><i class="fas fa-sign"> 글 번호</i></td>
	<td><i class="fas fa-list"> 글 제목</i></td>
	<td><i class="far fa-id-badge"> 작성자</i></td>
	<td><i class="fab fa-cloudscale"> 조회수</i></td>

		

</tr>
</thead>

<c:if test="${tradePage.hasNoBoards() }">
<tr>
	<td colspan="4">중고 장터 매물이 없습니다.</td>
</tr>
</c:if>

<c:forEach var="trade_Free" items="${tradePage.content }">
<tr>
	<td>${trade_Free.number }</td>
	
	<td>
	<a href="${root }/trade/read.do?no=${trade_Free.number }&pageNo=${tradePage.currentPage }">
	<c:out value="${trade_Free.title }"/>
	</a>
	<c:if test="${trade_Free.replyCount > 0 }" >
	<i class="fab fa-replyd"></i> ${trade_Free.replyCount }
	</c:if>
	</td>
	
	<td>${trade_Free.trader.name }</td>

	<td>${trade_Free.readCount }</td>


	
</tr>
</c:forEach>

<c:if test="${tradePage.hasBoards() }">
<tr>
	<td colspan="4">
	
		<c:if test="${tradePage.startPage > 5 }">
		<a href="${root }/trade/list.do?pageNo=${tradePage.startPage - 5 }">[PREV]</a>
		</c:if>
		<c:forEach var="pNo" begin="${tradePage.startPage }" end="${tradePage.endPage }">
		<a href="${root }/trade/list.do?pageNo=${pNo }">[${pNo }]</a>
		</c:forEach>
		
		<c:if test="${tradePage.endPage < tradePage.totalPages }">
		<a href="${root }/trade/list.do?pageNo=${tradePage.startPage + 5}">[NEXT]</a>
		</c:if>

	</td>
</tr>
</c:if>
</table>


	<i class="fas fa-pen-square fa-2x"><a href="${root }/trade/write.do"> 글 쓰기</a></i><br />

</div>

</body>
</html>