<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<c:set var="vacationStatusUrl" value="/vacation/vacationApproval" />
<html>
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- Libraries Stylesheet -->
	<link href="${path}/resources/css/style.css" rel="stylesheet">
	<link href="${path}/resources/css/vctProvision.css" rel="stylesheet">
	<script type="text/javascript" src="${path}/resources/js/popup.js"></script>
	<script type="text/javascript" src="${path}/resources/js/ctalvacation.js"></script>
<meta charset="UTF-8">
<title>약정휴가지급</title>
</head>

<body>
<c:set var="emp_no_session" value="${sessionScope.emp_no}" />
<c:set var="emp_nm_session" value="${sessionScope.emp_nm}" />

    <div class="main">
        <div class="container">
            <div class="container-1">
                <div class="container-1-item">
                    <ul class="tree"></ul>
                </div>
            </div>
            <div class="container-2">
                <button class="emp-info-move">></button>
	               <!--  <div class="container-2">
	                     <button  class="emp-info-move_back"><</button>
	                </div> -->
            </div>
            <div class="container-3">
                <div>
                    <div class="container-3-item1">
                        <div class="container-3-items-subject">직원</div>
                        <div class="container-3-item1-div"></div>
                    </div>
                    <div class="container-3-item2">
                        <div class="container-3-items-subject">휴가</div>
                        <div>
                            <select class="container-3-item2-select">
                                <option value="J1" selected>프로젝트</option>
                                <option value="K1">장기근속</option>
                            </select>
                        </div>
                    </div>
                    <div class="container-3-item3">
                        <div class="container-3-items-subject">정보입력</div>
                        <div class="container-3-item3-form">
                            <div class='container-3-item3-div'>
                                <label>고객사명</label>
                                <div><input class='container-3-item1-input'></div>
                            </div>
                            <div class='container-3-item3-div'>
                                <label>프로젝트명</label>
                                <div><input class='container-3-item2-input'></div>
                            </div>
                            <div class='container-3-item3-div'>
                                <label>기간</label>
                                <div>
                                    <input class='container-3-item3-input-date' type='date'>~
                                    <input class='container-3-item4-input-date' type='date'>
                                </div>
                            </div>
                            <div class='container-3-item3-div'>
                                <label>휴가유효시작일</label>
                                <div><input class='container-3-item11-input-date' type='date'></div>
                            </div>
                        </div>
                    </div>
                    <div class="container-3-item4">
                        <div class="container-3-items-subject">휴가일수</div>
                        <div><input class="container-3-item4-input"></div>
                    </div>
                    <div class="container-3-item5">
                        <div class="container-3-items-subject">비고</div>
                        <div>
                            <textarea class="container-3-item5-textarea"></textarea>
                        </div>
                    </div>
                </div>
                <div class="container-3-item6">
                    <button class="container-3-item5-button">적용</button>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        var emp_no = "${sessionScope.emp_no}";
        console.log(emp_no);
    });
    var data = localStorage.getItem("emp_no_session");
    if (data) {
        console.log("<p>전달받은 데이터: " + data + "</p>");
    } else {
        console.log("<p>데이터가 전달되지 않았습니다.</p>");
    }
</script>
</html>