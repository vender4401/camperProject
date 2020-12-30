<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${root }/board_Free/delete.do" method="post">
<input type="text" name="no" value="${param.no }" hidden/>

암호 입력 : <input type="password" name="password" />
<c:if test="${errors.invalidePassword }">
	<small class="form-text text-muted">
	암호가 일치하지 않습니다.
	</small>
</c:if>
<button type="submit">삭제</button>


</form>
</body>
</html>