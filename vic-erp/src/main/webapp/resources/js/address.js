window.daum=window.daum||{},function(a){function b(){for(var a=0,b=k.length;a<b;a++)document.write('<script charset="UTF-8" type="text/javascript" src="'+k[a]+'"></script>'),document.close();i=2}function c(){for(var a=0,b=k.length;a<b;a++){var c=document.createElement("script");q[k[a]]=!1,c.type="text/javascript",c.charset="utf-8",c.src=k[a],c.onload=function(){var b=k[a];return function(){var a=b;q[a]||(q[a]=!0),e()&&f()}}(),c.onreadystatechange=function(){var b=k[a];return function(){/loaded|complete/.test(this.readyState)&&(q[b]||(q[b]=!0),e()&&f())}}(),document.getElementsByTagName("head")[0].appendChild(c)}}function d(a){var b={};return a.replace(/[?&]+([^=&]+)=*([^&]*)/gi,function(a,c,d){b[c]=d}),b}function e(){for(var a=0,b=0,c=k.length;b<c;b++)q[k[b]]&&a++;return a===k.length}function f(){for(i=2;h[0];)h.shift()()}function g(a){for(var b in a)if("autoload"!==b){if(a.hasOwnProperty(b))return!1}else if("false"!==a[b]&&"true"!==a[b])return!1;return!0}a.postcode={_validParam_:!0};for(var h=[],i=0,j=document.getElementsByTagName("script"),k=["//t1.daumcdn.net/postcode/api/core/221018/1666013742754/221018.js"],l=0,m=j.length;l<m;++l){var n=j[l],o=n.src;if(/\/map_js_init\/postcode.v2(\.dev){0,1}(\.cbt){0,1}\.js\b/.test(o)){var p=d(o);g(p)||(a.postcode._validParam_=!1),"false"!==p.autoload&&(b(),i=2);break}}var q={};a.postcode.version="221018",a.postcode.load=function(a){if(a&&"function"==typeof a)switch(h.push(a),i){case 0:i=1,c();break;case 2:f()}},j=null}(window.daum);

   function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = ''; // 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('emp_addr_post_no').value = data.zonecode;
            document.getElementById("emp_ppst_addr").value = addr;

            // 사용자가 도로명 주소를 선택한 경우 상세주소 입력란에 추가 정보를 넣어준다.
            if (data.userSelectedType === 'R') {
                var extraAddr = ''; // 참고항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraAddr += data.bname;
                }

                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraAddr !== '') {
                    extraAddr = extraAddr;
                }

                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("emp_bpst_addr").value = extraAddr;
            } else {
                // 지번 주소일 경우 상세주소 입력란을 비운다.
                document.getElementById("emp_bpst_addr").value = '';
            }

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("emp_bpst_addr").focus();
        }
    }).open();
}
