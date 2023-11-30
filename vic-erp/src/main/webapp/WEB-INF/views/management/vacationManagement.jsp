<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/locales/bootstrap-datepicker.en-GB.min.js"></script>
<link type="text/css" rel="stylesheet" href="${path}/resources/css/VctMng.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/vctManagement.js"></script>
<title>휴가관리페이지</title>
</head>
<c:import url="../include/include.jsp" />
<body style="margin:0px;">
	<div class="container-i" style="margin-top:100px;">
		<div class="item-nav">
			<div style="width:91%; display:flex; justify-content:space-between;">
				<div>
					<button id="vct-provision" onclick="openPop()">휴가지급</button>
				</div>
				<div>
					<input id="search-period" type = "date">
		<!-- 			<select id="yearSelect">
					</select> -->
					<select class="vct-slt">
						<option value="전체">월차/연차</option>
						<option value="신생년도연차">월차</option>
						<option value="근속연차">연차</option>
					</select> 
					<select class="org-slt">	
						<option value="전체">부서</option>
						<option value="DX사업부">DX사업부</option>
						<option value="DX1팀">DX1</option>
						<option value="DX2팀">DX2</option>
						<option value="99">예비부서</option>
					</select> 
					<select class="crnk-slt">
						<option value="전체">직급</option>
						<option value="대표이사">대표이사</option>
						<option value="상무">상무</option>
						<option value="이사">이사</option>
						<option value="부장">부장</option>
						<option value="차장">차장</option>
						<option value="과장">과장</option>
						<option value="대리">대리</option>
						<option value="사원">사원</option>
						<option value="수습">수습</option>
					</select> 
					<input id="keyword">
					<button id="srch-emp-nm">검색</button>
				</div>
			</div>
		</div>
		<div class="items">
			<div class="item-info">
				<table>
					<thead style="position:sticky;top:0;">
						<tr >
							<td>No</td>
							<td>부서</td>
							<td>직급</td>
							<td>성명</td>
							<td>입사일</td>
							<td>근속기간</td>
							<td>신생년도<br />연차
							</td>
							<td>근속연차<br />일수
							</td>
							<td>이월휴가</td>
							<td>가산휴가</td>
							<td>총사용휴가</td>
							<td>잔여휴가</td>
						</tr>
					</thead>
					<tbody class="item-info-list"></tbody>
				</table>
			</div>
			<div class="item-space">
				<div class="emp-user-vct"></div>
				<table>
					<thead>
						<tr>
							<td>휴가</td>
							<td>시작일자</td>
							<td>종료일자</td>
							<td>휴가일수</td>
							<td>신청일자</td>
							<td>지급/사용</td>
							<td>취소</td>
						</tr>
					</thead>
					<tbody class="item-space-list"></tbody>
				</table>
				
			</div>
		</div>
	</div>
</body>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script>
function openPop() {
    var _width = 700;
    var _height = 650;

    // 화면의 가로 및 세로 중앙 위치 계산
    var _left = Math.ceil((window.screen.width/2) / 2 - (_width/2));
    var _top = Math.ceil((window.screen.height/2) / 2 - (_height/2));
    
    var features = 'width=' + _width + ', height=' + _height + ', left=' + _left + ', top=' + _top;
    var emp_no = $("#emp_no_session").data("attr");
    localStorage.setItem("emp_no_session", emp_no);
    window.open('/vicglobal/vctProvision', '휴가지급', features);
}
</script>
</html>