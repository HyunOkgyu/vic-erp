<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<c:import url="../include/include.jsp" />
<c:set var="emp_no_session" value="${sessionScope.emp_no}" />
<c:set var="emp_nm_session" value="${sessionScope.emp_nm}" />
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<meta charset="utf-8">

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link
	href="${path}/resources/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link
	href="${path}/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<!-- Template Stylesheet -->
<link href="${path}/resources/css/style.css" rel="stylesheet">
<link type="text/css" rel="stylesheet"
	href="${path}/resources/css/vacationStatus.css">
<link type="text/css" rel="stylesheet"
	href="${path}/resources/css/modal.css">
<link href="/resources/js/fullcalendar-5.0.1/lib/main.css"
	rel="stylesheet" />
<link type="text/css" rel="stylesheet"
	href="${path}/resources/css/calendar.css">

<script type="text/javascript" src="${path}/resources/js/vacation.js"></script>
<style>
  #srch-st-date::-webkit-datetime-edit-text,
  #srch-st-date::-webkit-inner-spin-button,
  #srch-st-date::-webkit-clear-button {
    color: transparent;
  }
  #srch-ed-date::-webkit-datetime-edit-text,
  #srch-ed-date::-webkit-inner-spin-button,
  #srch-ed-date::-webkit-clear-button {
    color: transparent;
  }

#srch-st-date, #srch-ed-date{
	border:2px solid #dee2e6;
	border-radius:5px;
	padding:0vmax 0vmax 0.1vmax 0vmax;
}
</style>
<meta charset="UTF-8">
<title>휴가현황</title>
</head>
<body style="margin:0px;">
	<div class="container" style="margin-top:100px;">
		<div class="vaca-info">
			<div class="vaca-info-i">
				<div class="vaca-nav">
					<nav>
						<ul>
							<li>
								<select id="vct-list-year"></select>
							</li>
							<li>
								<input id="srch-st-date" type="date">~<input id="srch-ed-date" type="date">
							</li>
							<li>
								<select class="vct-category">
									<option value="휴가구분">휴가구분</option>
									<option value="사용">사용</option>
									<option value="지급">지급</option>
								</select>
							</li>
							<li>
								<button class="apply_vacation" style="width: 100%/* 5vmax; */">휴가신청</button>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		<div class="card mb-4" style="width:100%; margin-top:70px; ">
			<div class="card-header">
	        <i class="fas fa-table me-1"></i>
	        	휴가현황
	        </div>
			<div class="card-body" style="width:100%; height:700px; overflow-y: scroll;">
				<table id="datatablesSimple"  style="width:100%; text-align:center;">
					<thead>
						<tr style="font-weight:bold;">
							<td>휴가</td>
							<td>시작일자</td>
							<td>종료일자</td>
							<td>휴가일수</td>
							<td>신청일자</td>
							<td>지급/사용</td>
						</tr>
					</thead>
					<tbody class="item-space-list"></tbody>
				</table>
			</div>
		</div>
	</div>
	</div>
	<!-- 모달 -->
	<div class="modal_check hidden" style="z-index:9999;">
		<div class="modal_overlay"></div>
		<div class="modal_content">
			<button class="modal_close">X</button>
			<div class="modal_content_items">
				<div >
					<h1 style="margin: 0; color: black;">휴가신청</h1>
				</div>
				<div>
					<div>
						<table style="text-align: center; border: 1px solid black; background-color:white; color:black;">
								<tr>
									<td>휴가종류</td>
									<td>전년도월차</td>
									<td>월차</td>
									<td>연차</td>
									<td>약정휴가</td>
									<td>종합</td>
								</tr>
							<tbody class="vaca-days" style="border: 1px solid black;"></tbody>
						</table>
					</div>
					<div class="tag-btn" style="margin-right:2.5vmax;margin-top:1vmax;margin-bottom:1vmax;">
						<button id="plus-tag">+</button>
						<button id="minus-tag">-</button>
					</div>
					<table class="vacation_tables" style="width: 100%; height: 100%;">
						<tbody id="vacation_table1">
							<tr style="width: 300px;">
								<td>휴가구분</td>
								<td>
									<select id="vaca-category1">
										<option value="A1" selected>연차</option>
										<option value="B1" >월차</option>
										<option value="902">약정휴가</option>
									</select>
								</td>
							</tr>
							<tr class ="ctalVactList1 hidden">
								<td>휴가내역</td>  
								<td>
									<!-- <input type="text" id="ctalVactList"> --> 
									<select id="ctalVactList1" style="width: 70%;" >
									    <!-- <option value="A1" selected>휴가1</option>
										<option value="B1" >휴가2</option>
										<option vaule="901">휴가3</option> -->
									</select> 
								</td>
							</tr>
							<tr> 
								<td>휴가기간</td>
								<td>
									<input type="date" id="vaca-start1"> ~ <input type="date" id="vaca-end1"> 
								</td>
							</tr>
							<tr>
								<td>휴가일수</td>
								<td><input id="use_vacation1" class="use_vacation"
									style="margin-right: 10px;" value="1">
									   <div id="halfVacationRadioGroup" style="display: inline-block;">
                                         <input  type="radio"  id="hdlDivCd1" name="halfVacation" value="L1"><label for="hdlDivCd1">오전</label>
                                         <input  type="radio"  id="hdlDivCd2" name="halfVacation" value="M1"><label for="hdlDivCd2">오후</label>
                                       </div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div style="text-align: center; margin-top: 1vmax;">
					<button class="apply_vaca_btn">신청</button>
					<button class="modal_close">취소</button>
				</div>
			</div>
		</div>
	</div>
	<!-- <div class="modal_check hidden">
		<div class="modal_overlay"></div>
		<div class="modal_content">
			<button class="modal_close">X</button>
			<div class="modal_content_items">
				<div >
					<h1 style="margin: 0; color: black;">휴가신청</h1>
				</div>
				<div>
					<table style="text-align: center; border: 1px solid black;">
						<thead>
							<tr>
								<td>휴가종류</td>
								<td>전년도월차</td>
								<td>월차</td>
								<td>연차</td>
								<td>약정휴가</td>
								<td>종합</td>
							</tr>
						</thead>
						<tbody class="vaca-days" style="border: 1px solid black;"></tbody>
					</table>
					<div class="tag-btn" style="margin:1vmax;margin-right:2vmax; ">
						<button id="plus-tag">+</button>
						<button id="minus-tag">-</button>
					</div>
					<table style="width: 100%; height: 100%;">
						<thead id="vacation_table">
							<tr style="width: 300px;">
								<td>휴가구분</td>
								<td>
									<select id="vaca-category1">
										<option value="A1" selected>연차</option>
										<option value="B1" >월차</option>
										<option value="902">약정휴가</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>휴가기간</td>
								<td>
									<input type="date" id="vaca-start1"> ~ <input type="date" id="vaca-end1"> 
								</td>
							</tr>
							<tr>
								<td>휴가일수</td>
								<td><input id="use_vacation1" class="use_vacation"
									style="margin-right: 10px;" value="1">
								</td>
							</tr>
						</thead>
					</table>
				</div>
				<div style="text-align: center; margin-top: 1vmax;">
					<button class="apply_vaca_btn">신청</button>
					<button class="modal_close">취소</button>
				</div>
			</div>
		</div>
	</div> -->

</body>
<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="${path}/resources/lib/easing/easing.min.js"></script>
<script src="${path}/resources/lib/waypoints/waypoints.min.js"></script>
<script src="${path}/resources/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="${path}/resources/lib/tempusdominus/js/moment.min.js"></script>
<script
	src="${path}/resources/lib/tempusdominus/js/moment-timezone.min.js"></script>
<script
	src="${path}/resources/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Template Javascript -->
<script src="${path}/resources/js/main.js"></script>
<script>
	// 시작년과 현재 년도 구하기
	var startYear = 2016; // 시작 년도 설정
	var currentYear = new Date().getFullYear();
	var yearDropdown = document.getElementById("vct-list-year");

	// 시작년부터 현재 년도까지 옵션 생성
	for (var year = currentYear; year >= startYear; year--) {
		var option = document.createElement("option");
		option.text = year;
		option.value = year;
		yearDropdown.appendChild(option);
	}
	  // 시작일로 사용할 날짜를 설정합니다.
	  var startDate = new Date(); // 현재 날짜로 설정, 필요에 따라 다른 날짜로 설정 가능
	  var endDate = new Date();

	  // 시작일을 1월 1일로 변경합니다.
	  startDate.setMonth(0); // 0은 1월을 나타냅니다
	  startDate.setDate(1);   // 1은 1일을 나타냅니다
	  endDate.setMonth(11);
	  endDate.setDate(31);
	  // 시작일을 "YYYY-MM-DD" 형식으로 변환합니다.
	  var startDateString = startDate.toISOString().slice(0, 10);
	  var endDateString = endDate.toISOString().slice(0, 10);
	  // input 요소를 찾고 시작일로 설정합니다.
	  var startDateInput = document.getElementById('srch-st-date');
	  startDateInput.value = startDateString;
	  var endDateInput = document.getElementById('srch-ed-date');
	  endDateInput.value = endDateString;
</script>
</html>