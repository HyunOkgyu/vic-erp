<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<c:import url="../include/include.jsp" />
<c:set var="emp_no_session" value="${sessionScope.emp_no}" />
<c:set var="emp_nm_session" value="${sessionScope.emp_nm}" />
<c:set var="boardPageUrl" value="/vicglobal/board" />
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/board.css">
<link type="text/css" rel="stylesheet" href="${path}/resources/css/modal.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/board.js"></script>
<title>게시판</title>
</head>
<body style="margin:0px;">
	<div class="container" style="width:88%; margin-top:100px;">
		<div class="bd-nav">
			<nav>
				<ul>
					<li>
						<input class="search-bar" type="text">
						<button class="search-keyword">검색</button>
					</li>
					<li>
						<select class="category">
							<option value="boms_title">제목</option>
							<option value="make_emp_no">등록자</option>
							<option value="boms_desc">내용</option>
						</select>
					</li>
					<li>
						<input type="date"> ~ <input type="date">
					</li>
				</ul>
			</nav>
		</div>
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
					<tbody class="bd-i-i"></tbody>
				</table>
			</div>
		</div>
		<div class="bd-f" style="display:flex; justify-content:center; margin-left:520px;">
			<div class="pageNum"
				style="display:flex; justify-content:center; text-align: center; padding-top: 0.5vmax; width: 100%; ">
			</div>
			<div class="wr-bd-btn" style="margin-left:500px;">
				<button class="brd-wrt-btn">등록</button>
			</div>
		</div>
	</div>
	<!-- 모달 -->
	<form method="post" enctype="multipart/form-data">
	<div class="modal_check hidden">
		<div class="modal_overlay"></div>
		<div class="modal_content">
			<button class="modal_close">X</button>
			<div class="modal_content_items">
				<div>
					<h1 style="margin: 0; color: #009CFF;">게시글 작성</h1> 
				</div>
				<div>
					<table style="width: 100%; height: 100%;">
						<tr style="width: 300px;">
							<td>제목</td>
							<td><input id="boms_title"></td>
						</tr>
						<tr>
							<td>카테고리</td>
							<td><select id="brd_id">
									<option value="01">공지게시판</option>
									<option value="02">신청</option>
									<option value="03">자료제출</option>
									<option value="04">정보공유</option>
									<option value="05">기타</option>
							</select></td>
						</tr>
						<tr>
							<td>이름</td>
							<td><input id="make_emp_nm" value="${emp_nm_session}"
								disabled></td>
						</tr>
						<tr>
							<td>파일업로드</td>
							<td>
								<div class="brd_AddFile">
									<label for="file">첨부파일</label>
										<input type="hidden" name="addedFileName"/>
										<input type="text" name="addedFile" style="display:none;" readonly />
										<input type="file" id="addfile" class="addfile" name="fileName"
										multiple  style="border: none;" />
									<div id="file-list" class="file-list"></div>
								</div>
							</td>
						</tr>
						<tr>
							<td>전사여부</td>
							<td>
								<label>전체사원</label> 
								<input id="total_emp_tg_y" type="radio" name="total_emp_tg" value="y"> 
								<label>일부사원</label>
								<input id="total_emp_tg_n" type="radio" name="total_emp_tg" value="n">
							</td>
						</tr>
						<tr class="slct-emp">
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea id="boms_desc" style="width: 98.5%; height: 20vmax;"></textarea></td>
						</tr>
					</table>
				</div>
				<div style="text-align: center; margin-top: 1vmax;">
					<button class="create_brd_btn">등록</button>
					<button class="modal_close">취소</button>
				</div>
			</div>
		</div>
	</div>
	</form>
		<div class="modal_check1 hidden">
		<div class="modal_overlay1"></div>
		<div class="modal_content1">
			<button class="modal_close">X</button>
			<div class="modal_content_items1">
				<div>
					제목
				</div>
				<div>
					게시판
				</div>
				<div>
					이름
				</div>
				<div>
					파일
				</div>
				<div>
					내용
				</div>
			</div>
			<div>
				<button>수정</button>
				<button>삭제</button>
			</div>
			<div>
				<button>닫기</button>
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
	var board = "${boardPageUrl}";
	var emp_no = "${sessionScope.emp_no}";
	var authority = "${sys_pmss_div_cd_session}";
	
	
</script>
</html>