<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
<u:navbar />


<h1>게시글을 수정 하였습니다.</h1> <br />

<a href="${root }/board_Free/list.do">[게시글목록보기]</a>
<a href="${root }/board_Free/read.do?no=${modReq.board_FreeNumber}">[게시글내용보기]</a>

</body>
</html>