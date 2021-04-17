
$(document).ready(function() {
	initJobSelect();//직업코드 초기화
	initMemorialSelect();//기념일코드 초기화
	initHobbySelect();//취미코드 초기화
	initSidoSelect();//시도 초기화
	
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
	//시 셀렉박스 조회하고 초기화
	initSidoSelect();//시도 초기화
	//테이블 초기화
	$("#tbZipResult tbody").empty();
	//주소창(modal) 열기 - 부트스트랩에 모달
	$("#zipModal").modal();
}

//회원 정보 저장하기
function save() {
	//회원 정보 유효성 체크
//	var result = validate();
//	if(!result){
//		return;
//	}
	
	//사용자 컨펌
	if(!confirm("저장하시겠습니까?")){
		return;
	}
	
	//db에 저장하는 ajax 호출
	$("#formFlag").val("C");
	$.ajax({
		url : "/JqueryPj/MemberServlet",
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
	window.location.href = "/JqueryPj/html/member/memberList2.html";
	
	//방법2
	var fm = document.getElementById("fm");
	fm.action = "/JqueryPj/html/member/memberList2.html";
	fm.method = "post";
	fm.submit();
}

function validate() {
	//...
//	return false;
	
	//체크가 끝나면
	return true;
}

//[ID중복검사] 버튼에 클릭 이벤트
function chkId() {
	var memId = $("#memId").val();
	console.log(memId);
	//빈 값 확인
	if(isEmpty(memId)){
		alert("ID를 입력해주세요.");
		$("#memId").focus();
		$("#spMemId").show();
		return;
	}
	
	//유효성 검사 - 영어소문자와 숫자로 구성, 3~10글자
	var regExp = /^[a-z0-9]{3,10}$/;
	if(!regExp.test(memId)){ //맞지않으면 들어옴
		alert("ID값이 유효하지 않습니다.");
		$("#memId").focus();
		$("#spMemId").show();
		return;
	}
	
	//DB에서 중복검사 수행
	$.ajax({
		url : "/JqueryPj/MemberServlet",
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
			$("#id")
			$("#spMemId").hide();
		},
		error : function(xhr) {
			console.log(xhr);
			alert("ID 중복검사실패");
		}
	});
}

//job코드 초기화
function initJobSelect() {
	//1. '직업코드' 세팅
	$.ajax({
		url : "/JqueryPj/CodeServlet",
		type : "post",
		data : {"groupCode" : "A02"},//직업코드 조회
		dataType : "json",
		success : function(data) {
			console.log("Job");
			console.log(data);
			makeJobSelect(data);
		},
		error : function(xhr) {
			console.log(xhr);
			alert("직업 코드를 불러오는 중 오류가 발생했습니다."); 
		}
	});
}
//job코드 생성
function makeJobSelect(data) {
	//방법1
//	var strHtml = "";
//	$("#memJob").html(strHtml);
	
	//방법2
//	$("#memJob").empty();
//	$("#memJob").append(ele1);
//	$("#memJob").append(ele2);
	
	var strHtml = '<option>선택하세요</option>';
	for(var i=0; i<data.length; i++){
		strHtml += '<option value="' + data[i].value + '">' + data[i].name + '</option>';
	}
//	<option value="07">군인</option>
	$("#memJob").html(strHtml);
}

//기념일 코드 초기화
function initMemorialSelect() {
	//2. '기념일 코드' 세팅
	$.ajax({
		url : "/JqueryPj/CodeServlet",
		type : "post",
		data : {"groupCode" : 'A03'},//기념일 코드 조회
		dataType : "json",
		success : function(data) {
			console.log("Memorial");
			console.log(data);
			makeMemorialSelect(data);
		},
		error : function(xhr) {
			console.log(xhr);
			alert("기념일 코드를 불러오는 중 오류가 발생했습니다."); 
		}
	});
}
//기념일 코드 생성
function makeMemorialSelect(data) {
	var strHtml = '<option>선택하세요</option>';
	for(var i=0; i<data.length; i++){
		strHtml += '<option value="' + data[i].value + '">' + data[i].name + '</option>';
	}
//	<option value="07">군인</option>
	$("#memMri").html(strHtml);
}

//취미 코드 초기화
function initHobbySelect() {
	$.ajax({
		url : "/JqueryPj/CodeServlet",
		type : "post",
		data : {"groupCode" : 'A01'},//취미코드 조회
		dataType : "json",
		success : function(data) {
			console.log("Hobby");
			console.log(data);
			makeHobbySelect(data);
		},
		error : function(xhr) {
			console.log(xhr);
			alert("취미 코드를 불러오는 중 오류가 발생했습니다."); 
		}
	});
}
//취미 코드 생성
function makeHobbySelect(data) {
	var strHtml = "";
	for(var i=0; i<data.length; i++){
		strHtml += '<label class="checkbox-inline" id="memHob">'
				+'<input type="checkbox" value="' + data[i].value + '">' + data[i].name + '</label>';
	}
//	<label class="checkbox-inline" id="memHob">
//	<input type="checkbox" value="02">수영
//	</label>
	$("#divMemHob").html(strHtml);
}

/*$(document).ready(function() {
	
	//3. '광고메일' 세팅
	$("#recvEmailYnN").prop("checked", true);
	
});*/

//시도 초기화
function initSidoSelect() {
	$.ajax({
		url : "/JqueryPj/ZipServlet",
		type : "post",
		data : {"flag" : "SI"},
		dataType : "json",
		success : function(data) {
			console.log(data);
			makeSidoSelect(data);
		},
		error : function(xhr) {
			console.log(xhr);
			alert("오류가 발생"); 
		}
	});
}
//시도 생성
function makeSidoSelect(data) {
	var strHtml = '<option>선택하세요</option>';
	for(var i=0; i<data.length; i++){
		strHtml += '<option value="' + data[i].sido + '">' + data[i].sido + '</option>';
	}
	console.log(strHtml);
//	<label class="checkbox-inline" id="memHob">
//	<input type="checkbox" value="02">수영
//	</label>
	$("#sido").html(strHtml);
	setGugun();
}

//방법2)setGu();
//방법3)trigger로 change 이벤트 호출

//gugun세팅
function setGugun() {
	var param = {'sido' : $("#sido").val(),'flag' : 'GU'};
	
	$.ajax({
		url : "/JqueryPj/ZipServlet",
		type : "post",
		data : param,//구군 조회
		dataType : "json",
		success : function(data) {
			console.log("GU");
			console.log(data);
			makeGugunSelect(data);
		},
		error : function(xhr) {
			console.log(xhr);
			alert("오류발생 - setGugun"); 
		}
	});
}
//gugun생성
function makeGugunSelect(data) {
	var strHtml = '<option>선택하세요</option>';
	for(var i=0; i<data.length; i++){
		strHtml += '<option value="' + data[i].gugun + '">' + data[i].gugun + '</option>';
	}
	console.log(strHtml);
//	<label class="checkbox-inline" id="memHob">
//	<input type="checkbox" value="02">수영
//	</label>
	$("#gugun").html(strHtml);
	$("#gugun").prop("disabled", false);
	
	setDong();
}

//dong세팅
function setDong() {
	var param = {'sido' : $("#sido").val(), 'gugun' : $("#gugun").val(),'flag' : 'DONG'};
	
	$.ajax({
		url : "/JqueryPj/ZipServlet",
		type : "post",
		data : param,//동 조회
		dataType : "json",
		success : function(data) {
			console.log("DONG");
			console.log(data);
			makeDongSelect(data);
		},
		error : function(xhr) {
			console.log(xhr);
			alert("오류발생 - setDong"); 
		}
	});
}

//dong생성
function makeDongSelect(data) {
	var strHtml = '<option>선택하세요</option>';
	for(var i=0; i<data.length; i++){
		strHtml += '<option value="' + data[i].dong + '">' + data[i].dong + '</option>';
	}
	console.log(strHtml);
//	<label class="checkbox-inline" id="memHob">
//	<input type="checkbox" value="02">수영
//	</label>
	$("#dong").html(strHtml);
	$("#dong").prop("disabled", false);
}

//zip세팅
function searchZipCode() {
	var param = {'sido' : $("#sido").val(), 
				'gugun' : $("#gugun").val(), 
				'dong' : $("#dong").val(), 
				'flag' : 'ZIP'};
	
	$.ajax({
		url : "/JqueryPj/ZipServlet",
		type : "post",
		data : param,//동 조회
		dataType : "json",
		success : function(data) {
			console.log("ZIP");
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