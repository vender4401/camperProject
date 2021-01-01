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
		<td>글번호</td>
		<td>작성자</td>
		<td>제목</td>
		<td>내용</td>	
	</tr>
	
	<tr>
		<td>${board_FreeData.board_Free.number }</td>	
		<td>${board_FreeData.board_Free.writer.name}</td>
		<td>${board_FreeData.board_Free.title }</td>
		<td>${board_FreeData.board_Content }</td>
	</tr>

		


	
		</table>
</div>
<hr />
<div class="container-fluid max-width text-right">
<table class="table table-hover">
<c:if test="${board_FreeData.board_Free.writer.name == authUser.name }">
    	<a href="${root }/board_Free/modify.do?no=${board_FreeData.board_Free.number }">수정</a>
		<a href="${root }/board_Free/delete.do?no=${board_FreeData.board_Free.number }">삭제</a>
   	</c:if>
</table>
</div>
   	
<div class="container-fluid max-width text-center">
<table class="table table-hover">

	<!-- 댓글 입력 -->
<u:replyForm replyNo="${board_FreeData.board_Free.number }"/>
	<!-- 댓글 리트스 보기 --><!-- 댓글 삭제 -->
<u:listReply_Free/>
	

</table>
</div>


</body>
</html>