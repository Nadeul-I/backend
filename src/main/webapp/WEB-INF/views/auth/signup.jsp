<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="../include/head.jsp"%>
 </head>
<body>
	<div class="center">
        <h1>회원가입</h1>
        <form method="POST" action="signup" id="form" onsubmit="return checkAll()">
            <div class="input dupCheck">
                <input type="text" id="userId" name="userId" required/>
                <label>아이디</label>
                <input type="button" id="dupCheckId" name="dupCheckId" value="아이디 중복 확인"/>
            </div>
            <label></label>
            <div class="input">
                <input type="password" id="userpwd" name="userPwd" required/>
                <span></span>
                <label>비밀번호</label>
            </div>
            <div class="input">
                <input type="password" id="userpwdCheck" required/>
                <span></span>
                <label>비밀번호 확인</label>
            </div>
            <div class="input">
                <input type="text" name="userName" required/>
                <span></span>
                <label>이름</label>
            </div>
            <div class="input">
                <input type="text" name="userGender" required/>
                <span></span>
                <label>성별</label>
            </div>
            <div class="input">
                <input type="text" name="userEmail" required/>
                <span></span>
                <label>이메일</label>
            </div>
            <div class="input">
                <input type="submit" id="signupBtn" value="회원가입"/>
                <input type="button" id="cancel" value="돌아가기"/>
            </div>
        </form>

    </div>
</body>
<script>
	document.getElementById("dupCheckId").addEventListener("click", function(){
		let userId = document.getElementById("userId").value;
    	let config = {
    		method:"GET",
    		headers:{
    			"Content-Type": "application/json",
    		},
    		body: JSON.stringify(value),
    	};
    	fetch(`${root}/search/${userId}`, config)
    	.then((response) => response.json())
    	.then((data) => idCheck(data))
	});

	function idCheck(){
		
	}

	function checkAll(){
		let pwd = document.getElementById("userpwd").value;
		let pwdCheck = document.getElementById("userpwdCheck").value;
		console.log(pwd)
		console.log(pwdCheck)
		if(pwd!=pwdCheck){
			alert("비밀번호 재확인")
			pwdCheck.focus;
			return false;
		}
		
		
	}
	let cancelBtn = document.getElementById("cancel").addEventListener("click", function(){
		location.href="${root}/";
	})
</script>	
</html>
