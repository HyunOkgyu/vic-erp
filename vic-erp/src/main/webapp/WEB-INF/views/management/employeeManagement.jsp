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
<!-- css --> 
<link type="text/css" rel="stylesheet" href="${path}/resources/css/modal.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/employeeManagement.css">
<!-- javascript -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/employeeManagement.js"></script>
<script type="text/javascript" src="${path}/resources/js/address.js"></script>
<title>직원관리페이지</title>

</head>

<body style="margin:0px;">
	<div class="container">
		<div class="em-nav">
			<ul>
				<li>
					<select class="search-category">
						<option value="emp_nm">이름</option>
						<option value="crnk_cd">직급</option>
						<option value="blng_org_no">부서</option>
						<option value="hffc_div_cd">재직상태</option>
					</select> 
					<input type="text" class="search-bar">
					<button class="search-btn">Search</button></li>
				<li><i class="fa-solid fa-user create_employee create_employee" style="font-size:30px;"></i></li>
			</ul>
		</div>
		<div class="card mb-4" style="width:100%; margin-top:70px;">
			<div class="card-header">
	         	<i class="fas fa-table me-1"></i>
	            직원관리
	    	</div>
			<div class="card-body" style="width:100%;">
				<table id="datatablesSimple"  style="width:100%; text-align:center;">
					<thead>
						<tr style="font-weight:bold;">
						<td>사원번호</td>
						<td>사원명</td>
						<td>부서</td>
						<td>직급</td>
						<td>이메일</td>
						<td>재직상태</td>
						<td>입사일자</td>
						<td>연락처</td>
						<td></td>
						<td></td>
						</tr>
					</thead>
					<tbody class="show-employee-list">
					</tbody>
				</table>
			</div>
		</div>
		<div class="em-table">
			<div class="pageNum"></div>
			</div>
	</div>

	<!-- 모달 -->
	<div class="modal_check hidden">
		<div class="modal_overlay"></div>
		<div class="modal_content">
			<button class="modal_close">X</button>
			<div class="modal_content_items">
				<div>
					<h1 style="margin:0;">직원생성</h1>
				</div>
				<div>
					<table style="width:100%;height:100%;">
						<tr style="width:300px;">
							<td>사원명</td>
							<td><input id="emp_nm" style="width:5vmax;"><span name="emp_nm"></span></td>
						<tr>
						<tr>
							<td>사원번호</td>
							<td><input id="emp_no" name="emp_no" style="width:5vmax;"><span name="emp_no"></span></td>
						<tr>

						<tr>
							<td>회사이메일</td>
							<td><input id="cmpy_email" style="width:5vmax;"><span class="input-group-text"> @ vicglobal.co.kr</span><div name="cmpy_email"></div></td>
						<tr>

						<tr>
							<td>연락처</td>
							<td>
								<input id="hp_tel_no" oninput="hypenTel(this)" maxlength="13"> 
							</td>
						<tr>
						<tr>
							<td>근무형태</td>
							<td>
								<select id="wrk_shap_cd">
									<option value="001">정규직</option>
									<option value="002">계약직</option>
									<option value="003">수습</option>
								</select>
							</td>						
						<tr>
						<tr>
							<td>직급</td>
							<td>
								<select id="crnk_cd">
									<option value="ADMIN">관리자</option>
									<option value="01">대표이사</option>
									<option value="02">상무</option>
									<option value="03">이사</option>
									<option value="04">부장</option>
									<option value="05">차장</option>
									<option value="06">과장</option>
									<option value="07">대리</option>
									<option value="08">사원</option>
									<option value="09">수습</option>
								</select>
							</td>
						<tr>
						<tr>
							<td>부서</td>
							<td>
								<select id="blng_org_no">
									<option value="00">VICGLOBAL</option>
									<option value="01">DX사업부</option>
									<option value="0101">DX1팀</option>
									<option value="0102">DX2팀</option>
									<option value="99">예비부서</option>
								</select>
							</td>
						</tr>

						<tr>
							<td>입사일</td>
							<td><input id="entr_dt" type="date" ></td>
						<tr>
						<tr>
							<td>수습만료일</td>
							<td><input id="prba_expr_dt" type="date" disabled></td>
						<tr>
					</table>
				</div>
				<div style="text-align:center; margin-top: 1vmax;">
					<button class="create_emp_btn">생성</button>
					<button class="modal_close">취소</button>
				</div>
			</div>
		</div>
	</div>
</body>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
        <script src="js/datatables-simple-demo.js"></script>
  <script>
  	//모달 연락처 input 값에 숫자를 입력했을 시 000-0000-0000으로 변경
    function hypenTel(input) {
      // 입력된 값에서 하이픈(-)을 모두 제거
      var value = input.value.replace(/-/g, '');
      
      // 하이픈이 없는 숫자 문자열을 다시 하이픈이 있는 형식으로 변환
      if (value.length >= 4 && value.length <= 7) {
        value = value.slice(0, 3) + '-' + value.slice(3);
      } else if (value.length >= 8) {
        value = value.slice(0, 3) + '-' + value.slice(3, 7) + '-' + value.slice(7);
      }
      
      // 변환된 값을 다시 입력 필드에 설정
      input.value = value;
    }
  </script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</html>