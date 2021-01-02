<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<u:navbar />
<div class="text-center">
<h1>게시물 삭제</h1>
</div>
<br />
<div class="text-center">
<form action="${root }/board_Free/delete.do" method="post">
<input type="hidden" name="no" value="${param.no }" />

암호 입력 : <input type="password" name="password" />
<c:if test="${errors.invalidePassword }">
	<small class="form-text text-muted">
	암호가 일치하지 않습니다.
	</small>
</c:if>
<button type="submit">삭제</button>


</form>
</div>
</body>
</html>