<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<meta content="" name="keywords">
	<meta content="" name="description">
	<meta charset="utf-8">
	<!-- Icon Font Stylesheet -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<!-- JavaScript Libraries -->
	
	<!-- Customized Bootstrap Stylesheet -->
	<!-- Template Stylesheet -->
	<script type="text/javascript" src="${path}/resources/js/include.js"></script>
	
	<link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
	<link href="${path}/resources/css/styles.css" rel="stylesheet" />
	<meta charset="UTF-8">
<title>헤더(include)</title>
</head>
<body class="sb-nav-fixed">
	<c:set var="brd_id" value="${sessionScope.brd_id}" />
	<c:set var="emp_no_session" value="${sessionScope.emp_no}" />
	<c:set var="emp_nm_session" value="${sessionScope.emp_nm}" />
	<c:set var="sys_pmss_div_cd_session" value="${sessionScope.sys_pmss_div_cd}" />
	<c:set var="pwd_chng" value="${sessionScope.pwd_chng}" />
	<c:set var="employeeInfoPageUrl" value="/vicglobal/employeeInfo" />
	<c:set var="boardPageUrl" value="/vicglobal/board" />
	<c:set var="employeeManagementPageUrl" value="/vicglobal/admin/employeeManagement" />
	<c:set var="vacationManagementPageUrl" value="/vicglobal/admin/vacationManagement" />
	<c:set var="vacationStatusUrl" value="/vicglobal/vacationStatus" />
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="/vicglobal/main">VIC GLOBAL</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle"><i class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <div class="input-group" id="emp_no_session" data-attr="${emp_no_session}" style="color:white; display:flex; flex-direction:row-reverse;">
                ${emp_nm_session}
            </div>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="${employeeInfoPageUrl}">MyPage</a></li>
                        <li><a class="dropdown-item" href="${vacationStatusUrl}">휴가현황</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="/logout">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<nav class="sb-sidenav accordion sb-sidenav-dark"
				id="sidenavAccordion">
				<div class="sb-sidenav-menu">
					<div class="nav">
						<div class="sb-sidenav-menu-heading"><i class="fas fa-table"></i>  게시판</div>
							<div class="nav-board-menu"></div>
						<div class="sb-sidenav-menu-heading"><i class="fa-solid fa-umbrella-beach"></i>  휴가</div>
							<div>
								<a class="nav-link" href="${vacationStatusUrl}">휴가현황</a>
							</div>
							<div>
								<a class="nav-link test">연차사용계획</a>
							</div>
					<c:if test="${sys_pmss_div_cd_session eq '702'}">
					    <div class="sb-sidenav-menu-heading"><i class="fa-solid fa-umbrella-beach"></i>  경영관리</div>
						    <div>
						        <a class="nav-link" href="${employeeManagementPageUrl}">직원관리</a>
						    </div>
						    						    <div>
						        <a class="nav-link" href="${vacationManagementPageUrl}">휴가관리</a>
						    </div>
					</c:if>
					</div>
				</div>
				<div class="sb-sidenav-footer">
					<div class="small">Logged in as:</div>
					Start Bootstrap
				</div>
			</nav>
		</div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="${path}/resources/template/js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"></script>

<script>
	var board = "${boardPageUrl}";
	var emp_no = "${sessionScope.emp_no}";
	var brd_id = "${sessionScope.brd_id}";
	$(document).ready(function() {
		console.log(emp_no);
	});
	$(document).ready(function() {
        $('.dropdown-toggle').dropdown();
    });
</script>

</html>