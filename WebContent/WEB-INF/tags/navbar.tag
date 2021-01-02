<%@ tag language="java" pageEncoding="UTF-8"%>
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
<title>나만의 씨에이엠피이알(CAMPER)</title>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
        <ul class="navbar-nav mr-auto">
            
            <li class="nav-item active">
            <button type="button" class="btn btn-dark" >
            	<a class="nav-link" href="${root }/index.jsp"> CAMPER</a>
            </button>
            </li>	
            <li class="nav-item">
            <button type="button" class="btn btn-dark">
                <a class="nav-link" href="#"><i class="far fa-building"></i>INTRO</a>
            </button>
            </li>
            <li class="nav-item">
            <button type="button" class="btn btn-dark">
                <a class="nav-link" href="${root }/board_Free/list.do"><i class="fas fa-list"></i>자유 게시판</a>
            </button>            
            </li>
            <li class="nav-item">
            <button type="button" class="btn btn-dark">
                <a class="nav-link" href="${root }/trade/list.do"><i class="fas fa-recycle"></i>중고 장터</a>
                </button>
            </li>
        </ul>
    </div>
    <div class="mx-auto order-0">
    <a class="py-2 navbar-brand mx-auto" href="${root }/index.jsp" aria-label="Product">
    <span style="color:silver;">
    <i class="fas fa-mountain fa-2x"></i>
    </span>    
    </a>
    </div>
    
<div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
        <ul class="navbar-nav ml-auto">
        <c:if test="${empty authUser }">
            <li class="nav-item active" >
            <button type="button" class="btn btn-dark">
                <a class="nav-link" href="${root }/login.do"><i class="fas fa-sign-in-alt"></i></a>
            </button>                
            </li>
            <li class="nav-item active" >
            <button type="button" class="btn btn-dark">
                <a class="nav-link" href="${root }/join.do">회원 가입</a>
            </button>
            </li>
        </c:if>
        
        <c:if test="${!empty authUser }">   
          
        <li class="nav-item active" >
        <button type="button" class="btn btn-dark">
        
                <a class="nav-link" href="${root }/userInfo.do"><i class="far fa-address-card"></i>내정보</a>
                </button>
        </li>   
        <li class="nav-item active" >
        <button type="button" class="btn btn-dark">
                <a class="nav-link" href="${root }/modify.do"><i class="fas fa-signature"></i>이름변경</a>
                </button>
        </li>   
                      
        <li class="nav-item active" >
        <button type="button" class="btn btn-dark">
                <a class="nav-link" href="${root }/changePwd.do"><i class="fas fa-key"></i>암호변경</a>
                </button>
        </li>
        
        <li class="nav-item active" >
        <button type="button" class="btn btn-dark">
                <a class="nav-link" href="${root }/logout.do"><i class="fas fa-sign-out-alt"></i>로그아웃</a>
                </button>
        </li>
        
        <li class="nav-item active" >
        <button type="button" class="btn btn-dark">
                <a class="nav-link" href="${root }/remove.do"><i class="fas fa-user-slash"></i>회원탈퇴</a>
                </button>
        </li>             
        
        </c:if>
        
        </ul>
    </div>
    
</nav>








 

      
  










</body>
</html>
