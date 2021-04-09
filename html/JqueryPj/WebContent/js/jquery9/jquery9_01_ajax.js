/**
 * 
 */
	function makeTitleList(param) {
// 		console.log(param);//param>>document
		var arr = param.getElementsByTagName("TITLE");
		console.log(arr);
// 		console.log(arr[0].innerHTML);
		console.log($(arr[0]).html());
	//		for(arr){
			
	//		}
	function fnXmlT() {
		$.ajax({
			url: "cd_catalog.xml",
// 			type: "get"//"post",
// 			data: {},
			dataType: "xml",
			success: function(data) {
				makeTitleList(data);
			},
			error: function(xhr) {
				console.log(xhr);
				alert("ERROR");
			}
		});
	}
	}
	function makeArtistList(param) {
		console.log(param);//param>>document
		var arr = param.getElementsByTagName("ARTIST");
		console.log(arr);
		console.log(arr[0]);
		console.log(arr[0].innerHTML);
// 		for(arr){
			
// 		}
	}
	function fnXmlA() {
		$.ajax({
			url: "cd_catalog.xml",
// 			type: "get"//"post",
// 			data: {},
			dataType: "xml",
			success: function(data) {
 				makeArtistList(data);
			},
			error: function(xhr) {
				console.log(xhr);
				alert("ERROR");
			}
		});
	}
	function fnJsonListTable() {
		$.ajax({
			url : "/JqueryPj/html/sample/data_json_list.txt",
			dataType : "json",
			success: function(data) {
				console.log(data);
				
				var str = "<table>"
						+ "<tr><th>이름</th>"
						+ "<th>나이</th>"
						+ "<th>성별</th>"
						+ "<th>직업</th></tr>";
				for(var i=0; i<data.length; i++){
					str += "<tr><td>" + data[i].name + "</td>"
						 + "<td>" + data[i].age + "</td>"
						 + "<td>" + data[i].gender + "</td>"
						 + "<td>" + data[i].job + "</td></tr>";
				}
				
				str += "</table>";
				$("#res").html(str);
			},
			error: function() {
				
			}
		});
	}
	function fnJsonList() {
		$.ajax({
			url : "/JqueryPj/html/sample/data_json_list.txt",
			dataType : "json",
			success: function(data) {
				console.log(data);
				
				var str = "배우목록<br><br>";
				for(var i=0; i<data.length; i++){
					str += "이름 : " + data[i].name + "<br>"
						 + "나이 : " + data[i].age + "<br>"
						 + "성별 : " + data[i].gender + "<br>"
						 + "직업 : " + data[i].job + "<br>";
					str += "<br>";
				}
// 				$.each(data, function(idx) {
// 					str += "<li>" + data[idx] + "</li>";
// 				});
// 				str += "</ol>";
				$("#res").html(str);
			},
			error: function() {
				
			}
		});
	}
	function fnJsonArr() {
		$.ajax({
			url : "/JqueryPj/html/sample/data_json_arr.txt",
			dataType : "json",
			success: function(data) {
				console.log(data);
				
				var str = "<ol>";
				for(var i=0; i<data.length; i++){
					str += "<li>" + data[i] + "</li>"
				}
// 				$.each(data, function(idx) {
// 					str += "<li>" + data[idx] + "</li>";
// 				});
				str += "</ol>";
				
				$("#res").html(str);
				
			}
		});
	}
	function fnJson() {
		$.ajax({
			url : "/JqueryPj/html/sample/data_json_obj.txt",
			dataType : "json",
			success: function(data) {
// 				$("#res").html(data);
				console.log(data);
				console.log(data.name);
				
				var str = "";
				str += "이름 : " + data.name + "<br>"
					+ "나이 : " + data.age + "<br>"
					+ "성별 : " + data.gender + "<br>"
					+ "직업 : " + data.job;
				
				$("#res").html(str);
				
			},
			error: function() {
				
			}
		});
	}
	function fnText() {
		$.ajax({
			url : "/JqueryPj/html/sample/data_text.txt",
			type : "GET",
// 			data :,
// 			dataType:,
			success: function(data) {
				$("#res").html(data);
			},
			error: function() {
				
			}
		});
	}
	function fnAjax() {
		$.ajax({
			url : "intro.html",
// 			type : "GET",
// 			data : {},
			dataType: "text",
			success: function(data) {
				$("#res").html(data);
			},
			error: function() {
				
			}
		});
	}
	function fnGet() {
		//submit실행
		var fm = $("fm");//<form>
		fm.action = "ex1.html?userId=test01&password=asdf";//url세팅
		fm.method = "post";
		fm.submit();
	}
