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
<title>로그인</title>
</head>
<body>

<u:navbar />

<div class="text-center">
<h1>LOGIN</h1>
</div>

<div class="text-center">
<form action="${root }/login.do" method="post">
  <div class="form-group">
    <label for="id">CAMPER ID</label> <br />
    <input type="text" value="${param.id }" name="id" placeholder="아이디 입력">
    <c:if test="${errors.id }">
	<small class="form-text text-muted">
              아이디 미입력.
	</small>
	</c:if>
    
    
    <c:if test="${errors.idOrPwNotMatch }">
	<small class="form-text text-muted">
              아이디와 암호가 일치하지 않습니다.
	</small>
	</c:if>
  </div>
  
  <div class="form-group">
    <label for="password">CAMPER PASSWORD</label> <br />
    <input type="password" value="${param.password }" name="password" placeholder="패스워드 입력" id="password">
    <c:if test="${errors.password }">
                  <small class="form-text text-muted">
                    비밀번호 미입력.
                  </small>
                </c:if>	
  </div>
  
  <div class="form-group form-check">
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox"> Remember me
    </label>
  </div>
  
  <button type="submit" class="btn btn-primary">LOGIN</button>
</form>
</div>
 



</body>
</html>