<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../include/head.jsp"%>
 </head>
<body>
 <c:import url="../include/nav.jsp" />
	<div class="center">
	<form method="GET" action="modify">
        <h1>마이페이지</h1>
            <div class="input">
                <input type="text" name="userId" value="${userInfo.userId}" disabled />
                <span></span>
                <label>아이디</label>
            </div>
            <div class="input">
                <input type="password" name="userPwd" value="${userInfo.userPwd}" disabled/>
                <span></span>
                <label>비밀번호</label>
            </div>

            <div class="input">
                <input type="text" name="userName" value="${userInfo.userName}" disabled/>
                <span></span>
                <label>이름</label>
            </div>
            <div class="input">
                <input type="text" name="userGender" value="${userInfo.userGender}" disabled/>
                <span></span>
                <label>성별</label>
            </div>
            <div class="input">
                <input type="text" name="userEmail" value="${userInfo.userEmail}" disabled/>
                <span></span>
                <label>이메일</label>
            </div>
            <div class="input">
                <input type="submit" id="modifyBtn" value="정보수정"/>
                <input type="button" class="btn btn-primary" id="withdraw" value="회원탈퇴"/>
                <input type="button" id="cancel" value="돌아가기"/>
            </div>
		</form>
    </div>
</body>
<script>
	document.getElementById("cancel").addEventListener("click", function(){
		location.href="${root}/";
	})
	/* document.getElementById("modifyBtn").addEventListener("click",function(){
		location.href="${root}/user/modify";
	}) */
	document.getElementById("withdraw").addEventListener("click", function(){
		alert("탈퇴");
		location.href="${root}/auth/withdraw";
	})
</script>	
</html>
