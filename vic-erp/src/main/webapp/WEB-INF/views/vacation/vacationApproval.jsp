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
<link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="${path}/resources/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="${path}/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<!-- Template Stylesheet -->
<link href="${path}/resources/css/style.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/vacationStatus.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/modal.css">
<link href="/resources/js/fullcalendar-5.0.1/lib/main.css" rel="stylesheet" />
<link type="text/css" rel="stylesheet" href="${path}/resources/css/calendar.css">
<script type="text/javascript" src="${path}/resources/js/vacationApproval.js"></script>
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
#srch-st-date{
	border:1px solid black;
	border-radius:5px;
	padding:0.2vmax 0vmax 0.25vmax 0vmax;
}
#srch-ed-date{
	border:1px solid black;
	border-radius:5px;
	padding:0.2vmax 0vmax 0.25vmax 0vmax;
}
.vaca-nav{
	margin-left:70%;
}
</style>
<meta charset="UTF-8">
<title>사용X</title>
</head>
<body style="margin:0px;">
	<div class="container">
		<div class="vaca-info">
			<div class="vaca-info-i">
				<div class="vaca-nav">
					<nav>
						<ul>
							<li><input id="srch-st-date" type="date">~<input id="srch-ed-date" type="date"></li>
							<li>
								<select id="vct-list-year"></select>
							</li>
						</ul>
					</nav>
				</div>
			</div>
			<div class="vaca-table">
				<table style="width:79%; margin-left:205px;">
					<thead class="vaca-List-head">
						<tr>
							<td>휴가</td>
							<td>시작일자</td>
							<td>종료일자</td>
							<td>휴가일수</td>
							<td>신청일자</td>
							<td>지급/사용</td>
							<td></td>
						</tr>
					</thead>
					<tbody class="item-space-list"></tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<!-- JavaScript Libraries -->
<!-- Template Javascript -->
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