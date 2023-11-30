<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<c:import url="../include/include.jsp" />
<html>
<head>
	<meta charset="UTF-8">
	<link type="text/css" rel="stylesheet" href="${path}/resources/css/employeeInfo.css">
	<script type="text/javascript" src="${path}/resources/js/address.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="${path}/resources/js/employeeInfo.js"></script>
	
<title>직원정보 확인/변경</title>
</head>
<body style="margin:0px;">
	<div class="container">
		<div class="ei-c">
			<nav>
				<ul>
					<li class="basic-info">기본정보</li>
					<li class="password-chng">패스워드변경</li>
				</ul>
			</nav>
			<div  class="ei-i">
				<div class="ei-i-1">
					<label>이름</label>
					<input type="text" disabled>
				</div>
				<div class="ei-i-1">
					<label>사원번호</label>
					<input type="text" disabled>
				</div>
				<div class="ei-i-1">
					<label>주민번호</label>
					<input type="text" disabled>
				</div>
				<div class="ei-i-1">
					<label>휴대전화</label>
					<input type="text">
				</div>
				<div class="ei-i-1">
					<label>이메일</label>
					<input type="text">
                    <span class="input-group-text">@vicglobal.co.kr</span>
				</div>
				<div class="ei-i-1">
					<label>우편번호</label>
					<input type="text">
					<button >찾기</button>
				</div>
				<div class="ei-i-1">
					<label>주소</label>
					<input type="text">
				</div>
				<div class="ei-i-1">
					<label>상세 주소</label>
					<input type="text">
				</div>
				<div class="ei-i-1">
					<label>부서</label>
					<input type="text" disabled>
				</div>
				<div class="ei-i-1">
					<label>직급</label>
					<input type="text" disabled>
				</div>
				<div class="ei-i-1">
					<label>입사일자</label>
					<input type="text" disabled>
				</div>
				<div class="ei-i-1">
					<button>수정</button>
					<button>초기화</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	var pwdChngValue = "${sessionScope.pwd_chng}";
	var empValue = "${sessionScope.emp_no}";

	
	//비밀번호 변경 ajax
	$(document).on("click", "#pwd-chng-btn", function() {
/* 		
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
         */
	    var emp_no = "${sessionScope.emp_no}";
	    pwdChng(emp_no);    
	});
	
	$(function(){
		$(".basic-info").click(function(){
			empUpdateForm(empValue);
		});

		$(".password-chng").click(function(){
			passwordChng();
		});
	});
	
	/*정보 수정 초기화*/
	$(function(){
		$(document).on("click", "#reset", function() {
			empUpdateForm(empValue);   
		});
		
		$(document).on("click", "#emp-info-chng-btn", function() {
			
			var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
			var regExp = /^[a-z]+[a-z0-9]{5,19}$/g;
			if(!V_emp_ssn()){
				return false;
			}
			if(!regExp.test($("#cmpy_email").val()))
				{
					alert("회사이메일을 확인해주세요.");
					return false;
				}
			if(!emailRegex.test($("#indd_email").val()))
				{
					alert("개인이메일을 확인해주세요.");
					return false;
				}
			empUpdate(empValue);  
		});
	});
</script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
</html>