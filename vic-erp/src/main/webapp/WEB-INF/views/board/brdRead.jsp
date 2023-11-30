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
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${path}/resources/css/modal.css">
	<script type="text/javascript" src="${path}/resources/js/boardRead.js"></script>
<title>게시글페이지</title>
</head>
<style>
.container{
	display:flex;
	flex-direction:row;
}
.read-post{
	display:flex;
	flex-direction:column;
	align-items:center;
	justify-content:center;
	width:70%;
}
.post-subject{
	margin-top:2vmax;
	width:50vmax;
	height:5vmax;
	border-bottom:2px solid #35B62C;
}
.post-subject-category{
	font-weight:bold;
	font-size:0.7vmax;
	padding:0.2vmax;
	margin-left:0.7vmax;
}
.post-subject-content{
	margin-top:1vmax;
	font-weight:bold;
	font-size:1.5vmax;
	margin-left:1vmax;
	display:flex;
	justify-content:space-between;
}
.post-subject-content span> span{
	color:red;
}
.post-subject-content span:nth-child(3){
	margin-top:1vmax;
	font-size:0.9vmax;
	font-weight:300;
}
.post-subject-n{
	font-size:0.8vmax;
	padding:0.2vmax;
	margin-left:1.2vmax;
}
.brd-attachments{
	display:flex;
	justify-content: space-between;
	margin-top:0.6vmax;
	width:50vmax;
	height:3vmax;
	max-height:3vmax;
	overflow: auto; 
	text-align:right;
}
.brd-download{
	cursor:pointer;
}
.post-download>div{
	margin-right:0.6vmax;	
}
.post-content{
	margin-top:0.6vmax;	
	width:50vmax;
	height:20vmax;
	border-top:2px solid #35B62C;
}
.post-content>div{
	margin-top:0.6vmax;	
	margin-left:0.6vmax;
	max-height:23vmax;
}
.post-text{
	position:relative;
	margin-top:0.6vmax;	
	width:50vmax;
	height:8vmax;
	max-height:23vmax;
	margin-bottom:1vmax;
}
.post-text>textarea{
	margin-top:0.2vmax;
	margin-left:0.2vmax;
	width:49vmax;
	height:7vmax;
}
.post-text-send{
	position: absolute;
	bottom:2.5px;
    right: 2px;
    background-color:black;
    border:1px solid black;
    border-radius:5px;
    color:#fff;
    cursor:pointer;
    padding:0.4vmax 0.7vmax 0.2vmax 0.7vmax;
    
}
textarea {
  border: 4px solid #35B62C; /* 테두리 두께, 스타일 및 색상 설정 */
  border-radius: 5px; /* 테두리의 모서리를 둥글게 만들 수 있음 (선택사항) */
  padding: 5px; /* 텍스트와 테두리 사이의 여백 설정 (선택사항) */
}
.post-btn{
	float:right;

}

.post-btn>div>button{
	border:1px solid black;
	margin-left:0.3vmax;
	border-radius:5px;
	background-color:black;
	color:#fff;
	cursor:pointer;
	width:3vmax;
	height:1.4vmax;
}
.read-comment{
	margin-top:2vmax;
	width:25vmax;
	height:48;
	border:2px solid #35B62C;
}
.attachments-icon{
	margin-left:0.7vmax;
	font-size:0.8vmax;
	font-weight:bold;
}
.comment-info{
	margin-left:0.6vmax;
	margin-top:2vmax;
}
.comment-info-i{
	border-bottom: 2px solid #35B62C;
	font-size:1vmax;
	font-weight:600;
	margin:0.5vmax;
}
.comment-info-crnk{
	font-size: 0.8vmax;
	margin-right:0.5vmax;
	background-color: black;
	border: 1px solid black;
	border-radius:5px;
	padding: 0.3vmax 0.3vmax 0.1vmax 0.3vmax;
	color:white;
}
.comment-content{
	margin-left:1vmax;
}
.comment-date{
	margin-left:1vmax;
	margin-top:0.7vmax;
	font-size:0.7vmax;
}

</style>
<body style="margin:0px;">
	<div class="container">
		<div class="read-post">
			<div class="post-items"></div>
		</div>
		<div class="read-comment"></div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/scripts.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>
</html>