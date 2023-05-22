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
   
   <div class="center">
        <h1>로그인</h1>
        <form method="POST" action="signin">
            <div class="input">
                <input type="text" name="userId" required/>
                <span></span>
                <label>아이디</label>
            </div>
            <div class="input">
                <input type="password" name="userPwd" required/>
                <span></span>
                <label>비밀번호</label>
            </div>
            <div class="find" id="find">비밀번호를 잊으셨나요?</div>
            <div class="input">
         
                <input type="button" id="signupBtn" value="회원가입">
            </div>	
        </form>

    </div>
  
    <!-- login section end -->
  </body>
  <script>
  	document.getElementById("signupBtn").addEventListener("click", function(){
  		location.href="${root}/auth/signup";
  	})
  	document.getElementById("find").addEventListener("click", function(){
  		location.href="${root}/auth/findpw";
  	})
  </script>
</html>
