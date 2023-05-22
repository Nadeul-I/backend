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
        <h1>비밀번호 찾기</h1>
        <form method="POST" action="findpw">
            <div class="input">
                <input type="text" name="userId" required/>
                <span></span>
                <label>아이디를 입력하세요.</label>
            </div>
            <div class="input">
                <input type="text" name="userEmail" required/>
                <span></span>
                <label>이메일을 입력하세요.</label>
            </div>
            <div class="input">
                <input type="submit" value="찾기"/>
                <input type="button" id="homeBtn" value="메인으로">
            </div>	
        </form>

    </div>
  
    <!-- login section end -->
  </body>
  <script>
  	document.getElementById("homeBtn").addEventListener("click", function(){
  		location.href="${root}/";
  	})
  </script>
</html>
