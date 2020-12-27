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
<title>로그인</title>
</head>
<body>

<h1>로 그 인</h1>
<form action="${root }/login.do" method="post">

<c:if test="${errors.idOrPwNotMatch }">
<small class="form-text text-muted">
              아이디와 암호가 일치하지 않습니다.
</small>
</c:if>
<br />
<input type="text" value="${param.id }" name="id" /> <br />

<c:if test="${errors.id }">
                  <small class="form-text text-muted">
                    아이디 미입력.
                  </small>
                </c:if>	
비밀번호 <br />
<input type="password" value="${param.password }" name="password" /> <br />
<c:if test="${errors.password }">
                  <small class="form-text text-muted">
                    비밀번호 미입력.
                  </small>
                </c:if>	

<input type="submit" value="로그인" />
</form>
</body>
</html>