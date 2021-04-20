
$(document).ready(function() {
//	initSidoSelect();//시도 초기화
	
	//$("#tbZipResult tbody").dblclick(function() {
//	});
	$("#tbZipResult").on("dblclick", "tbody tr", function() {
		console.log($(this));
		console.log($(this).children);
		
		var zipcode = $(this).children("td:eq(0)").text();
		var addr = $(this).children("td:eq(1)").text();
		
		console.log(zipcode);
		console.log(addr);
		
		//메인화면(부모창)의 우편번호, 주소 input에 데이터 세팅
		$("#memZip").val(zipcode);
		$("#memAdd1").val(addr);
		
		//주소창 닫기
		$("#zipModal").modal("hide");
	});
});

//openZip
function openZip() {
	//테이블 초기화
	$("#tbZipResult tbody").empty();
	//주소창(modal) 열기 - 부트스트랩에 모달
	$("#zipModal").modal();
}

//회원 정보 저장하기
function save() {
	if($("#idChk").val() != "idChkT"){
		alert("아이디 중복검사를 해주세요!");
		$("#memId").focus();
		return false;
	}
	var resName = chkName();
	var resPass = chkPass();
	var resMail = chkMail();
	var resBD = chkBD();
	var resHP = chkHP();
	if(!resName) return;
	if(!resPass) return;
	if(!resMail) return;
	if(!resBD) return;
	if(!resHP) return;
//	if($("#nameChk").val() != "nameChkT"){
//		chkName();
//		$("#memName").focus();
//		return false;
//	}
//	if($("#passChk").val() != "passChkT"){
//		chkPass();
//		$("#memPass").focus();
//		return false;
//	}
//	if($("#mailChk").val() != "mailChkT"){
//		chkMail();
//		$("#BD").focus();
//		return false;
//	}
//	if($("#bdChk").val() != "bdChkT"){
//		chkBD();
//		$("#memName").focus();
//		return false;
//	}
//	if($("#hpChk").val() != "hpChkT"){
//		chkHP();
//		$("#memName").focus();
//		return false;
//	}
	//사용자 컨펌
	if(!confirm("저장하시겠습니까?")){
		return;
	}
	
	//db에 저장하는 ajax 호출
	$("#formFlag").val("C");
	console.log($("#fm").serialize());
	$.ajax({
		url : "/HtmlAss/MemberServlet",
		type : "post",
		data : $("#fm").serialize(),
		dataType : "json",
		success : function(data) {
			alert("저장되었습니다.");
			
			//페이지 이동
//			changePage();
		},
		error : function(xhr) {
			alert("실패. 관리자 문의 바람");
			console.log(xhr);
		}
	});
}

function changePage() {
	//방법1
	window.location.href = "/HtmlAss/html/member/memberList2.html";
	
	//방법2
	var fm = document.getElementById("fm");
	fm.action = "/HtmlAss/html/member/memberList2.html";
	fm.method = "post";
	fm.submit();
}

//[ID중복&유효성검사] 버튼에 클릭 이벤트
function chkId() {
	var memId = $("#memId").val();
	console.log(memId);
	//빈 값 확인
	if(isEmpty(memId)){
		alert("ID를 입력해주세요.");
		$("#memId").focus();
		$("#spMemId").show();
		return false;
	}
	
	//유효성 검사 - 영어소문자와 숫자로 구성, 3~10글자
	var regExp = /^[a-z0-9]{4,12}$/;
	if(!regExp.test(memId)){ //맞지않으면 들어옴
		alert("ID값이 유효하지 않습니다.");
		$("#memId").focus();
		$("#spMemId").show();
		return false;
	}
	
	//DB에서 중복검사 수행
	$.ajax({
		url : "/HtmlAss/MemberServlet",
		type : "post",
		data : {"memId" : memId,
				"flag" : "CHKID"},
		dataType : "json",
		success : function(data) {
			console.log(data);
			//data ==> {"resultCnt" : "0"}
			//data ==> {"resultCnt" : "1"}
			
			// if //중복된 ID이면
			if(data.resultCnt == 1){
				alert("아이디가 중복됩니다. 다시 입력하셈");
				$("#id").focus();
			}
			// else //중복된 ID가 아니면
			else {
				alert("사용가능한 ID입니다.");
			}
			$("#btnMemId").css("background-color", "#ccdef4");
			$("#spMemId").hide();
			$("#idChk").val("idChkT");
			
		},
		error : function(xhr) {
			console.log(xhr);
			alert("ID 중복검사실패");
		}
	});
	return true;
}
//[PW유효성검사]
function chkPass() {
	var memPass = $("#memPass").val();
	console.log(memPass);
	
	//빈값 확인
	if(isEmpty(memPass)){
		alert("비밀번호를 입력해주세요.");
		$("#memPass").focus();
		$("#spMemPass").show();
		return false;
	}
	
	//유효성 검사 - 영문 소문자, 영문 대문자, 숫자, 특수문자가 각각 1개 이상씩 포함된 8~12 글자
	var regExp = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+])(?!.*[^a-zA-Z0-9$`~!@$!%*#^?&\\(\\)\-_=+]).{8,12}$/;
	if(!regExp.test(memPass)){//맞지 않으면 들어옴
		alert("비밀번호를 확인해 주세요");
		$("#memPass").focus();
		$("#spMemPass").show();
		return false;
	}
	
	//비밀번호 확인과 같은지 쳌키라웃!
	var memPassC = $("#memPass1").val();
	if(memPass != memPassC){
		alert("비밀번호가 일치하지 않습니다.");
		$("#memPass1").focus();
		$("#spMemPass1").show();
		return false;
	}
	console.log("비밀번호 유효성 검사 성공!");
	$("#passChk").val("passChkT");
	return true;
}
//[이름 유효성 검사]
function chkName() {
	var memName = $("#memName").val();
	console.log(memName);
	//빈 값 확인
	if(isEmpty(memName)){
		alert("이름을 입력해주세요.");
		$("#memName").focus();
		$("#spMemName").show();
		return false;
	}
	
	//유효성 검사 - 한글만 2~5자리
	var regExp = /^[가-힣]{2,5}$/;
	if(!regExp.test(memName)){ //맞지않으면 들어옴
		alert("이름을 다시 확인해 주세요.");
		$("#memName").focus();
		$("#spMemName").show();
		return false;
	}
	
	//이름은 DB에서 중복검사 불필요(중복 가능)
	console.log("이름 유효성 성공");
	$("#nameChk").val("nameChkT");
	return true;
}
//[이메일 유효성 검사]
function chkMail() {
	var memMail = $("#memMail").val();
	console.log(memMail);
	
	//빈값 확인
	if(isEmpty(memMail)){
		alert("이메일을 입력해주세요.");
		$("#memMail").focus();
		$("#spMemMail").show();
		return false;
	}
	
	//유효성 검사 - 올바른 이메일 형식
	var regExp = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
	if(!regExp.test(memMail)){//맞지 않으면 들어옴
		alert("이메일을 확인해 주세요");
		$("#memMail").focus();
		$("#spMemMail").show();
		return false;
	}
	
	console.log("이메일 유효성 검사 성공!");
	$("#mailChk").val("mailChkT");
	return true;
}
//[생일 유효성 검사]
function chkBD() {
	var BD = $("#memBD").val();
	console.log(BD);
	
	//빈값 확인
	if(isEmpty(BD)){
		alert("생일을 입력해주세요.");
		$("#memBD").focus();
		$("#spBD").show();
		return false;
	}
	
	//10살 이하는 가입 불가
	var today = new Date();
	var year = today.getFullYear();
	var yearBD = BD.split("-",3);
	
	
	if((year-yearBD[0]+1) < 10){//10살 이하면 가입 불가
		alert("10세 이하는 가입이 불가능 합니다.");
		$("#memBD").focus();
		$("#spBD").show();
		return false;
	}
	
	console.log("생일 유효성 검사 성공!");
	$("#bdChk").val("bdChkT");
	return true;
}
//[휴대폰 번호 유효성 검사]
function chkHP() {
	var memHp = $("#memHp").val();
	console.log(memHp);
	//빈 값 확인
	if(isEmpty(memHp)){
		alert("이름을 입력해주세요.");
		$("#memHp").focus();
		$("#spMemHp").show();
		return false;
	}
	var regExp = /^(010)[-](\d{4})[-](\d{4})$/;
	if(!regExp.test(memHp)){
		alert("휴대폰 번호가 형식에 맞지 않습니다.");
		$("#memHp").focus();
		$("#spMemHp").show();
		return false;
	}
	console.log("휴대폰 번호 유효성 검사 성공!");
	$("#hpChk").val("hpChkT");
	return true;
}

//우편번호 검색
function searchZipCode() {
	var param = {'dong' : $("#dong").val(), 
				'flag' : 'ZIP'};
	
	$.ajax({
		url : "/HtmlAss/ZipServlet",
		type : "post",
		data : param,//동 조회
		dataType : "json",
		success : function(data) {
			console.log("ADDR");
			console.log(data);
			makeZipTable(data);
		},
		error : function(xhr) {
			console.log(xhr);
			alert("오류발생 - searchZipCode"); 
		}
	});
}

//dong생성
function makeZipTable(data) {
	console.log("makeZipTable");
	var strHtml = '';
	for(var i=0; i<data.length; i++){
		strHtml += '<tr><td>' + data[i].zipCode + '</td>' 
				+ '<td>' + data[i].sido + ' '
				+ data[i].gugun + ' '
				+ data[i].dong + ' '
				+ data[i].bunji + '</td></tr>'
				;
	}
	console.log(strHtml);
//	<label class="checkbox-inline" id="memHob">
//	<input type="checkbox" value="02">수영
//	</label>
	$("#tbZipResult tbody").html(strHtml);
	$("#divZipResult").show();
}