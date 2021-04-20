/**
 * 
 */
$(document).ready(function(){
   $("#btnSearch").click(function search() {
	   var userId = $("#memberId").val();
	   var userName = $("#memberName").val();
	   var param = {memId : userId,
			   		memName : userName,
			   		flag : "L"};
      $.ajax({
         url : "/HtmlAss/MemberServlet"
         ,type : "post"
         ,data : param
         ,dataType:"json"
         ,success : function (data) {
            console.log(data);
            alert("성공")
            resTable(data);
         }
         ,error : function(xhr) {
            console.log(xhr);
            alert("오류발생");
         }
      });
   });
});
  
function resTable(data) {
	console.log(">>makeTable");
	console.log(data);
	var cnt = 0;
	var str = "";
	for(var i=0; i<data.length; i++){
		str += "<tr><td>" + cnt++ + "</td>"
			 + "<td>" + data[i].memId + "</td>"
			 + "<td>" + data[i].memName + "</td>"
			 + "<td>" + data[i].memBir + "</td>"
//			 + "<td>" + data[i].hp + "</td>"
			 + "<td>" + formatHp(data[i].memHp) + "</td>"
			 + "<td>" + data[i].memAddr + "</td>"
			 + "<td>" + data[i].memMail + "</td>"
			 + "<td>" + data[i].memJob + "</td>"
			 + "<td>" + data[i].memJobName + "</td>"
			 + "<td>" + data[i].memMileage + "</td></tr>";
	}
	$("#res-table-tboby").html(str);
}

