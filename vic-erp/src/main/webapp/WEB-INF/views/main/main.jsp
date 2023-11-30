<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<c:import url="../include/include.jsp" />
<c:set var="vacationStatusUrl" value="/vacation/vacationApproval" />
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
	<link href="${path}/resources/css/style.css" rel="stylesheet">
	<!-- css -->
	<link type="text/css" rel="stylesheet" href="${path}/resources/css/board.css">
	<link type="text/css" rel="stylesheet" href="${path}/resources/css/calendar.css">
	<link type="text/css" rel="stylesheet" href="${path}/resources/css/modal.css">
	<link href="/resources/js/fullcalendar-5.0.1/lib/main.css" rel="stylesheet" />
	<!-- 자바스크립트 -->
	<script src="/resources/js/fullcalendar-5.0.1/lib/main.js"></script>
	<script src="/resources/js/fullcalendar-5.0.1/lib/locales/ko.js"></script>
	<script type="text/javascript" src="${path}/resources/js/calendar.js"></script>
	<script type="text/javascript" src="${path}/resources/js/main.js"></script>
	<script type="text/javascript" src="${path}/resources/js/vacation.js"></script>
<meta charset="UTF-8">
<title>메인페이지</title>
</head>
<body>
	<div>
		<div class="items-container" style="display:flex; 
											flex-direction:column;
											align-items:center; 
											justify-content:center; 
											width:100%; 
											margin-top:2%;">
			<!-- 메인 공지게시판 -->
			<div class="container" style="width:100%;margin:20px; ">
				<div class="card mb-4" style="width:100%; margin-top:70px;">
					<div class="card-header">
	                	<i class="fas fa-table me-1"></i>
	                    공지게시판
	                </div>
					<div class="card-body" style="width:100%;">
						<table id="datatablesSimple"  style="width:100%; text-align:center;">
							<thead>
								<tr style="font-weight:bold;">
									<td>번호</td>
									<td>게시판명</td>
									<td>제목</td>
									<td>등록자</td>
									<td>등록일</td>
									<td>조회</td>
								</tr>
							</thead>
							<!-- ajax로 가져온 데이터는 js로 태그를 생성해 tbody에서 받음 -->
							<tbody class="bd-i-i">
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<!--메인 캘린더 -->
			<div class="card mb-4" style="width:1296px; margin-top:70px;">
				<div class="card-header">
		            <i class="fas fa-table me-1"></i>
		            캘린더
	            </div>
				<div id='calendar' style="width:80%; margin:auto; margin-top:20px;"></div>
			</div>
			<!-- 캘린더 하위 휴가관련 페이지 및 모달 이동 -->
			<div style="float:right; margin-bottom:100px; margin-left:36vmax;">
				<!-- 결재 현황 페이지 이동 -->
				<a class="" href="/vicglobal/vacationApproval" style="text-decoration: none;color:black;padding:10px;border-radius:5px;"> 결재현황 바로가기 <i class="fa-solid fa-angle-right"></i></a>
				<!-- 모달 열기 -->
				<a class="main-modal-btn" href="#" style="text-decoration: none;color:black;padding:10px;border-radius:5px;margin-left:10px;"> 휴가신청 <i class="fa-solid fa-angle-right"></i></a>
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
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>
</html>

