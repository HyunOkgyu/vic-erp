<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
<link type="text/css" rel="stylesheet" href="${path}/resources/css/login.css">
</head>
<style>
</style>
<body>
	<div class="log-c">
		<h1>VIC Global</h1>
		<div style="font-size:1.5vmax;text-align:center;margin-bottom:2vmax;">휴가관리</div>
		<form action="/login/loginForm" method="post">
			<div class="log-i">
				<div>
					<div class="lgin">아이디</div>
					<input id="lgin_id" name="lgin_id" type="text" placeholder=" ID">
				</div>
				<div >
					<div class="lgin">비밀번호</div>
					<input id="lgin_pwd" name="lgin_pwd" type="password" placeholder=" PW">
				</div>
				<div class="log-btn">
					<button>Log in</button>
				</div>
			</div>
		 </form>
	 </div>
</body>
<script>
        // 로그인 실패 시 알림 창 띄우기
        <% if (request.getParameter("loginFailed") != null && request.getParameter("loginFailed").equals("true")) { %>
            alert("로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요.");
        <% } %>
    </script>
</html>