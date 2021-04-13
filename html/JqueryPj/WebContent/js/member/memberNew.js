/**
 * 
 */
$(document).ready(function() {
	
});
//[중복검사] 버튼에 클릭 이벤트
function chkId() {
	var memId = $("#memId").val();
	
	//빈 값 확인
	if(isEmpty(memId)){
		alert("ID를 입력해주세요.");
		$("#memId").focus();
		return;
	}
	
	//유효성 검사 - 영어소문자와 숫자로 구성, 3~10글자
	var regExp = /[a-z0-9]{3,10}/;
	if(regExp.test(memId)){ //맞지않으면 들어옴
		alert("ID값이 유효하지 않습니다.");
		$("#memId").focus();
		$("#spMemId").show();
		return;
	}
	
	//DB에서 중복검사 수행
	$.ajax({
		url : "",
		type : "post",
		data : {"memId" : memId,
				"flag" : "CHKID"},
		dataType : "json",
		success : function(data) {
			console.log(data);
			$("#spMemId").hide();
		},
		error : function(xhr) {
			console.log(xhr);
			alert("ID 중복검사중 오류가 발생했습니다.")
		}
	});
}