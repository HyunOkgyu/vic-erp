<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 변경 페이지</title>
	<link type="text/css" rel="stylesheet" href="${path}/resources/css/login.css">
	<script type="text/javascript" src="${path}/resources/js/pwchng.js"></script>
</head>
<body>
	<div class="log-c">
		<h1>VIC Global</h1>
		<div style="font-size:1.5vmax;text-align:center;">휴가관리</div>
		<div style="margin-bottom:2vmax;">비밀번호변경</div>
		<div class="log-i">
			<div>
				<div class="lgin">새 비밀번호</div>
				<input id="lgin_pwd"  type="password" placeholder ="입력">
			</div>
			<div >
				<div class="lgin">새 비밀번호 재확인</div>
				<input id="lgin_pwd_chck"  type="password" placeholder ="입력">
			</div>
			</div>
			<div class="log-btn">
				<button id="pwd-chng-btn" style="width: 13.7vw; height: 3vh;">비밀번호변경</button>
			</div>
			<div class="log-btn">
				<button id="pwd-chng-btn2" style="width: 13.7vw; height: 3vh;" >다음에 변경</button>
				<!-- <button id="pwd-chng-btn2" style="padding: 0.3vmax 4.0vmax 0.3vmax 4.0vmax;" >다음에 변경</button> -->
			</div>
		</div>
</body>
<script>
	var empValue = "${sessionScope.emp_no}";
	
	$(document).on("click", "#pwd-chng-btn", function() {
		
 		if (!passwordRegex.test($("#lgin_pwd").val())) {
			alert("비밀번호를 확인해주세요.");
			$('#lgin_pwd').focus();
			return false;
		}

        if ($("#lgin_pwd").val() !== $("#lgin_pwd_chck").val()) {
			alert("비밀번호를 확인해주세요.");
			$('#lgin_pwd').focus();
			return false;
		} 
        
	    var emp_no = "${sessionScope.emp_no}";
	    pwdChng(emp_no);    
	});
</script>
</html>