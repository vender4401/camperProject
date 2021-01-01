<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="replyNo" type="java.lang.Integer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${!empty sessionScope.authUser }">
  <div>
    <form action="${root }/reply/add.do" method="post">
      <input type="hidden" value="${param.no }" name="no" />
      <input type="hidden" value="${param.pageNo }" name="pageNo" />
    
      <div class="input-group mb-3">
        <input type="text" name="body" class="form-control" placeholder="새로운 댓글을 입력해주세요.">
          <button class="btn btn-outline-secondary" type="submit"><i class="fas fa-fw fa-comment-dots"></i>등록</button>
        <div class="input-group-append">
        </div>
      </div>
    </form>
  </div>
</c:if>