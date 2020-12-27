<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<script type="text/javascript">
	alert("CAMPER에 오신것을 환영 합니다.");
</script>


<c:if test="${!empty authUser }">
${authUser.name }님, 안녕하세요.
<a href="${root }/logout.do">로그아웃</a>
<a href="${root }/changePwd.do">암호변경</a>
<a href="${root }/board_Free/write.do">자유게시판 글쓰기</a>
</c:if>




<c:if test="${empty authUser }">
<a href="${root }/join.do">회원가입</a>
<a href="${root }/login.do">로그인</a>
</c:if>

</body>
</html>