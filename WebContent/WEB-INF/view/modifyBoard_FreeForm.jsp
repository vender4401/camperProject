<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<form action="${root }/board_Free/modify.do" method="post">
게시글 번호 : ${modReq.board_FreeNumber } <br />
<input type="text" name="no" value="${modReq.board_FreeNumber }" hidden />
제목 : <input type="text" name="title" value="${modReq.title }" />
		<c:if test="${errors.title }"> 제목을 입력 하세요. </c:if><br />
내용 : <br />
<textarea name="content" cols="30" rows="10">${modReq.content }</textarea>
<br />
<input type="submit" value="수정" />
</form>
</body>
</html>