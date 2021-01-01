<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="camper" class="module.model.Camper" scope="page"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<u:navbar />

<div class="text-center">
<h1>정보 보기</h1>
<b>로그인 아이디 : </b>${authUser.id } <br />
<b>이름 : </b>${authUser.name }


</div>



</body>
</html>