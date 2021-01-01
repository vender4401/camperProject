<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<u:navbar />

<form action="${root }/board_Free/write.do" method="post">
	제목 : 
	<input type="text" name="title" value="${param.title }" />
	<c:if test="${errors.title }">제목이 비어 있습니다. </c:if>
	
	<br />
	
	내용 :
	<textarea name="content" rows="5" cols="30">${param.content }</textarea>
	<c:if test="${errors.content }">내용이 비어 있습니다. </c:if>
	
	<br />

	<input type="submit" value="글 등록" />
</form>
</body>
</html>