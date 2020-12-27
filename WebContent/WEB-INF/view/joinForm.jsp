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
<title>회원 가입</title>


</head>
<body>
<h1>회 원 가 입</h1>

<form action="${root }/join.do" method="post">
아이디 <br />
<input type="text" value="${param.id }" name="id" /> <br />
<c:if test="${errors.id }">
            <small class="form-text text-muted">
              아이디를 입력하세요.
            </small>
          </c:if> 
<c:if test="${equals.id }">
            <small class="form-text text-muted">
              같은 아이디가 존재 합니다.
            </small>
</c:if> 
<hr />
비밀번호 <br />
<input type="password" value="${param.password }" name="password" /> <br />
<c:if test="${errors.password }">
            <small class="form-text text-muted">
              비밀번호 미입력.
            </small>
          </c:if> 
          
비밀번호 확인 <br />
<input type="password" value="${param.passwordCheck }" name="passwordCheck" /> <br />
<c:if test="${errors.password }">
            <small class="form-text text-muted">
              비밀번호 확인 미입력.
            </small>
          </c:if> 
          <c:if test="${errors.notMatch }">
            <small class="form-text text-muted">
              비밀번호가 일치하지 않습니다.
            </small>
          </c:if>
<hr />
2차 비밀번호 <br />
<input type="password" value="${param.password2 }" name="password2" /> <br />
<c:if test="${errors.password2 }">
            <small class="form-text text-muted">
              2차 비밀번호 미입력.
            </small>
          </c:if> 
<hr />
이름 <br />
<input type="text" value="${param.name }" name="name" /> <br />
<c:if test="${errors.name }">
            <small class="form-text text-muted">
              암호를 입력 하세요.
            </small>
          </c:if> 
성별 <br />
<select name="gender">
	<option value="">성별 선택</option>
    <option value="male">남자</option>
    <option value="female">여자</option>
</select>
<c:if test="${errors.gender }">           
              성별 미입력.           
          </c:if> 
<br />

생년 월일 <br />
<input type="date" value="${param.birth }" name="birth" />
<c:if test="${errors.birth }">           
              생년 월일 미입력.          
          </c:if> 
<br />

핸드폰 번호 <br />
<select name="phone1">
    <option value="">앞번호 입력</option>
    <option value="010">010</option>
    <option value="011">011</option>
    <option value="017">017</option>
    <option value="019">019</option>
</select>
<input type="text" value="${param.phone2 }" name="phone2" />
<input type="text" value="${param.phone3 }" name="phone3" />
<small class="form-text text-muted">            
<c:if test="${errors.phone1 }">           
              첫번째 핸드폰 미입력.           
          </c:if> 
<c:if test="${errors.phone2 }">           
              두번째 핸드폰 미입력.     
          </c:if> 
<c:if test="${errors.phone3 }">           
              세번째 핸드폰 미입력.         
          </c:if>           
</small>
<br />
이메일 <br />
<input type="text" value="${param.email1 }" name="email1" />
@
<select name="email2">
    <option value="">도메인 입력</option>
    <option value="gmail.com">gmail.com</option>
    <option value="naver.com">naver.com</option>
    <option value="daum.ner">daum.net</option>
</select>
<small class="form-text text-muted">            
<c:if test="${errors.email1 }">           
              이메일 미입력.        
          </c:if> 
<c:if test="${errors.email2 }">           
              도메인 미입력.
          </c:if> 
</small>
<br />
<input type="submit" value="등록" />
</form>
</body>
</html>