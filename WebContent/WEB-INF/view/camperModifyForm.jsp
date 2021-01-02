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
<title>이름 변경</title>
</head>
<body>

<u:navbar />

<div class="text-center">
<h1>이름 변경</h1>
</div>


<div class="text-center">
<form action="${root }/modify.do" method="post">
	
	변경할 이름 : 
	<input type="text" name="newName" />
	<c:if test="${errors.newName }"> 변경할 이름을 입력 하세요. </c:if>
	<br />
	<br />
	패스워드 입력: 
	<input type="password" name="curPwd" /> 
	
	<c:if test="${errors.curPwd }"> 현재 암호를 입력 하세요. </c:if>
	<c:if test="${errors.badCurPwd }"> 현재 암호가 일치하지 않습니다. </c:if>
	<br />
	<br />
	<button type="submit" class="btn btn-primary">이름 변경</button>
</form>
</div>


</body>
</html>