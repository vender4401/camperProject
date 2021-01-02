<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="list_reply" type="java.lang.Integer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>

  <c:forEach items="${replyTrade_List }" var="reply">  
  <hr />
    <i class="fas fa-comment-alt fa-2x">Reply : ${reply.body } </i>
    <br />
    <i class="fas fa-user-check">${reply.writerId }</i>
    <i class="fas fa-id-card">${reply.camperId }</i>


    
	<br />

    <c:if test="${reply.camperId == authUser.id }">
    <a href="${root }/reply_Trade/delete.do?id=${reply.id }&no=${param.no }&pageNo=${param.pageNo } "><i class="fas fa-times"></i>삭제</a>
  <hr />
    </c:if>
      <br />

    

  </c:forEach>

</div>