// 약정휴가지급
$(document).ready(function() {
    // "적용" 버튼 클릭 이벤트 처리
    $(".container-3-item5-button").click(function() {
        
        // 입력한 데이터 수집
        function getEmpNos() {
            //직원 번호 담겨있는 div태그 
            var container = $(".container-3-item1-div");
            //해당 태그에 담겨있는 모든 emp_no 가져오기 
            var empHoverElements = container.find('.emp-hover'); //emp-hover = 사원
            // 가져온 사원을 담을 배열 생성
            var empNos = [];

            //가져온 사원번호의 데이터 값을 변수에 담기
            empHoverElements.each(function() {
                var empNo = $(this).data("attr");
                empNos.push(empNo);
            });

            return empNos;
        }


        var empNo =  getEmpNos(); // 배열 형태로 받아옴
        var empNos =  getEmpNos(); // 배열 형태로 받아옴
        console.log(empNo);
        var vactPayUseDivDtlCd = $(".container-3-item2-select").val();
        var custNm = $(".container-3-item1-input").val() || null;
        var pjtNm = $(".container-3-item2-input").val() || null;
        var pjtStDt = $(".container-3-item3-input-date").val() ? formatDateToString(new Date($(".container-3-item3-input-date").val())) : null;
        var pjtEdDt = $(".container-3-item4-input-date").val() ? formatDateToString(new Date($(".container-3-item4-input-date").val())) : null;
        var vactDcnt = $(".container-3-item4-input").val();
        var remark = $(".container-3-item5-textarea").val() || null;
        var yosYcnt = calculateYears(new Date($(".container-3-item8-input-date").val()), new Date($(".container-3-item9-input-date").val())) || null; //근속년수(int)
        //var yosYcnt = $(".container-3-item8-input-date").val() - $(".container-3-item9-input-date").val() || null; //근속년수(int)
        var vactPayStDt = formatDateToString(new Date($(".container-3-item11-input-date").val())); //휴가유효시작일

        // 날짜 계산(근속년수)


        // DATE 타입 String으로 변환
        function formatDateToString(date) {
            if (!date) {
                return null;
            }
            const year = date.getFullYear().toString();
            let month = (date.getMonth() + 1).toString().padStart(2, '0'); // 월은 0부터 시작하므로 1을 더합니다.
            let day = date.getDate().toString().padStart(2, '0');

            return year + month + day;
        }




        // 각 사원별로 프로시저 호출
        empNos.forEach(function(empNo) {
            var requestData = {
                payEmpNo: data, // 로그인된 사원 번호(임원_세션)
                empNo: empNo, // 지급받은 사원 번호
                vactPayUseDivDtlCd: vactPayUseDivDtlCd,
                custNm: custNm,
                pjtNm: pjtNm,
                pjtStDt: pjtStDt,
                pjtEdDt: pjtEdDt,
                vactDcnt: vactDcnt,
                remark: remark,
                yosYcnt : yosYcnt, 
                vactPayStDt : vactPayStDt
            };
            console.log(requestData);

        // 서버로 데이터 전송 (AJAX 요청)
        $.ajax({
            type: "POST",
            url: "/vicglobal/pay/ctalVact",  // 컨트롤러의 URL에 맞게 변경해야 함
            contentType: "application/json",
		    dataType : "html",
            data: JSON.stringify(requestData),
            success: function(response) {
                if(response!=null){
                	alert("휴가지급완료");
                }
                 location.reload();
            },
            error: function(error) {
                // 오류 처리
                console.error(error);
            }
        });
  });  
});


		//근속년수 계산
        function calculateYears(startDate, endDate) {
            var diffTime = Math.abs(endDate - startDate);
            var diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
            return Math.floor(diffDays / 365);
        }	



$(document).on('change', '.container-3-item9-input-date', function() {
	$(".container-3-item10-input-date").val(calculateYears(new Date($(".container-3-item8-input-date").val()), new Date($(".container-3-item9-input-date").val())));
  });
});












