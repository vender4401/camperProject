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
<h1>회원 탈퇴</h1>
</div>

<div class="text-center">

		<form action="${root }/remove.do" method="post">
		 암호 : <input type="password" name="password" /> <br />
		 <c:if test="${errors.password }">
                <small class="form-text text-muted">
                  암호를 입력해주세요.
                </small>
              </c:if>
              <c:if test="${errors.idOrPwNotMatch }">
                <small class="form-text text-muted">
                  암호나 2차암호가 일치하지 않습니다.
                </small>
              </c:if>		 
		 <br />
		 2차 암호 : <input type="password" name="password2" /> <br />
		 <c:if test="${errors.password2 }">
                <small class="form-text text-muted">
                  2차 암호를 입력해주세요.
                </small>
              </c:if>
              <c:if test="${errors.idOrPwNotMatch2 }">
                <small class="form-text text-muted">
                  암호나 2차암호가 일치하지 않습니다.
                </small>
              </c:if>		 
		 <br />
		 <button type="submit" class="btn btn-primary">탈퇴 하기</button>
		 
		 
		</form>
</div>
</body>
</html>