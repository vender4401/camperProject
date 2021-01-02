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

<div class="text-center">
<h1>중 고 장 터</h1>
<p>중고 물품을 거래 할수 있습니다.</p>
</div>


<div class="text-center">
<form action="${root }/trade/write.do" method="post">
	제목 : 
	<input type="text" name="titleTrade" value="${param.title }" />
	
	<c:if test="${errorsTrade.title }">
	<small class="form-text text-muted">
                    제목이 비어 있습니다.
                  </small>
                  </c:if>
	<br />
	<br />
	
	내용 :
	<textarea name="contentTrade" rows="5" cols="30">${param.content }</textarea>
	<c:if test="${errorsTrade.content }">
	<small class="form-text text-muted">
                    내용이 비어 있습니다.
                  </small>
				</c:if>
	
	<br />
	
	판매 가격 : 
	<textarea name="price" rows="5" cols="30">${param.price }</textarea>
	<c:if test="${errorsTrade.price }">
	<small class="form-text text-muted">
                    원하시는 가격을 입력 하세요.
                  </small>
				</c:if>
	
	<br />
	거래 지역 : 
	<textarea name="place" rows="5" cols="30">${param.place }</textarea>
	<c:if test="${errorsTrade.place }">
	<small class="form-text text-muted">
                    거래하실 지역을 적어주세요.
                  </small>
				</c:if>
	
	<br />
	사용 기간 : 
	<textarea name="timeuse" rows="5" cols="30">${param.timeuse }</textarea>
	<c:if test="${errorsTrade.timeuse }">
	<small class="form-text text-muted">
                    사용 기간을 적어주세요.
                  </small>
				</c:if>
	
	<br />
	<input type="submit" value="글 등록" />
</form>
</div>
</body>
</html>
