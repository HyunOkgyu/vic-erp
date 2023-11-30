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
<title>휴가정보 및 기능(include)</title>
</head>
<body class="sb-nav-fixed">
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