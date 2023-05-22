<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="../include/head.jsp"%>
  </head>
  <body>
    <!-- header nav start -->
    <c:import url="../include/nav.jsp" />
   
   <div class="lump"></div>
   <form>
   <div class="center">
        <h1>비밀번호 찾기</h1>
            <div class="input findpw">
                <input type="text" name="userPwd" value="${userPwd}" disabled />
                <span></span>
                <label>회원님의 비밀번호입니다.</label>
            </div>
            <div class="input">
                <input type="button" id="loginBtn" value="로그인">
            </div>	

    </div>
  	</form>
    <!-- login section end -->
  </body>
  <script>
  	document.getElementById("loginBtn").addEventListener("click", function(){
  		location.href="${root}/auth/login";
  	})
  	
  </script>
</html>
