/**
 * 
 */
function makeTable(param) {
 		console.log(param);
		var arrCd = param.getElementsByTagName("CD");
		console.log(arrCd);
 		var str = "<table>"
				+ "<tr><th>TITLE</th>"
				+ "<th>ARTIST</th>"
				+ "<th>COUNTRY</th>"
				+ "<th>COMPANY</th>" 
				+ "<th>PRICE</th>" 
				+ "<th>YEAR</th></tr>";
		for(var i=0; i<arrCd.length; i++){
			var obj = arrCd[i];
			
			var title = $(obj.getElementsByTagName("TITLE")).html();
			var artist = $(obj.getElementsByTagName("ARTIST")).html();
			var country = $(obj.getElementsByTagName("COUNTRY")).html();
			var company = $(obj.getElementsByTagName("COMPANY")).html();
			var price = $(obj.getElementsByTagName("PRICE")).html();
			var year = $(obj.getElementsByTagName("YEAR")).html();
			console.log(title);

			if(title == null)title = "";
			if(artist == null)artist = "";
			if(country == null)country = "";
			if(company == null)company = "";
			if(price == null)price = "";
			if(year == null)year = "";
 			str += "<tr>"
 				+  "<td>" + title + "</td>"
	 			+  "<td>" + artist + "</td>"
	 			+  "<td>" + country + "</td>"
	 			+  "<td>" + company + "</td>"
	 			+  "<td>" + price + "</td>"
	 			+  "<td>" + year + "</td>"
	 			+  "</tr>";
		}
		
		str += "</table>";
		$("#res").html(str);
	}
	function fnXmlTable() {
		$.ajax({
			url : "cd_catalog1.xml",
			dataType : "xml",
			success: function(data) {
				makeTable(data);
			},
			error: function() {
				
			}
		});
	}