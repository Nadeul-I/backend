<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!-- header start-->
<header class="header-container">
  <nav class="header-nav">
    <a href="${root}/">나들이</a>
    <div>
      <ul class="header-inner">
        <li><a href="">공지사항</a></li>
        <li><a href="${root}/region">여행 계획</a></li>
        <li><a href="${root }/board/list?pgno=1&search=&word=">여행 후기</a></li>
        <li><a href="${root }/board/list?pgno=1&search=&word=">자유 게시판</a></li>
      </ul>
    </div>
    <div>
      <ul class="header-inner">
      	<c:if test="${userDto eq null}"> 
        	<li><a href="${root}/auth/signin">로그인</a></li>
        	<li><a href="${root}/auth/signup">회원가입</a></li>
        </c:if>
        <c:if test="${userDto ne null}">
        	<li><a href="${root}/user/mypage">마이페이지</a>
        	<li><a href="${root}/auth/logout">로그아웃</a>
        </c:if> 
      </ul>
    </div>

    <input type="checkbox" id="nav-menu" />
    <label class="hamburger" for="nav-menu">
      <span></span>
      <span></span>
      <span></span>
    </label>
  </nav>
</header>
<!-- header end-->
