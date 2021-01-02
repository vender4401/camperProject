<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 읽기</title>
</head>
<body>

<u:navbar />
<div class="container-fluid max-width text-center">
<table class="table table-hover">

	<tr>
	
	<td><i class="fas fa-sign"> 글 번호</i></td>
	<td><i class="far fa-id-badge"> 작성자</i></td>
	<td><i class="fas fa-list"> 글 제목</i></td>
	<td><i class="far fa-clock"> 작성시간</i></td>	

	<td><i class="fas fa-coins"> 판매 가격</i></td>	
	<td><i class="fas fa-map-marked-alt"> 거래 장소</i></td>	
	<td><i class="fas fa-history"> 사용 기간</i></td>	

	</tr>
	
	<tr>
		
		<td>${tradeData.board_Free.number }</td>	
		<td>${tradeData.board_Free.trader.name}</td>
		<td>${tradeData.board_Free.title }</td>
		<td>${tradeData.board_Free.moddate }</td>
		<td>${tradeData.board_Free.price }</td>	
		<td>${tradeData.board_Free.place }</td>	
		<td>${tradeData.board_Free.timeuse }</td>	
	</tr>

		</table>
		
		
</div>
<div class="container-fluid max-width text-center">
<table class="table table-hover">
	<tr>
		<td><i class="fas fa-file-alt">내용</i><br />
		</td>
	</tr>

	<tr>	
		<td><i class="fas fa-cube fa-2x"><br /><br />
		${tradeData.board_Content }</i></td>
	</tr>

</table>
</div>
<hr />
<div class="container-fluid max-width text-right">
<table class="table table-hover">
<c:if test="${tradeData.board_Free.trader.name == authUser.name }">
    	<a href="${root }/trade/modify.do?no=${tradeData.board_Free.number }">수정</a>
		<a href="${root }/trade/delete.do?no=${tradeData.board_Free.number }">삭제</a>
   	</c:if>
</table>
</div>
   	
<div class="container-fluid max-width text-center">
<table class="table table-hover">

	<!-- 댓글 입력 -->
<u:replyTrade replyNo="${tradeData.board_Free.number }"/>
	<!-- 댓글 리트스 보기 --><!-- 댓글 삭제 -->
<u:listReply_Trade/>
	

</table>
</div>


</body>
</html>