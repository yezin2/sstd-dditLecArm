/**
 * 
 */
//strUrl = http://localhost/JqueryPj/html/jquery9/jquery_03_submit.html
//strKey = "userId";
function getValue(strUrl, strKey) {
	var val = "";
	//strUrl에서 strKey에 해당하는 값을 추출해서
	val = "~";
	return val;
}

function isEmpty(val) {
	//val이 빈값이거나 null이거나 undefined이거나 ""
	return true;
	//reurn false;
}

function format(val, type) {
	//010-1234-1234, 01012341234, 010-12341234, 010 1234 1234
	if(type == "hpno"){
		val = val.replaceAll("-","").replaceAll(" ", "");
		val.replace(/(\d{3})(\d{3,4})(\d{4})/, "#1-$2-$3");
		
		//2020-04-08		
		val.replace(/()()()/, "#1-$2-$3");
		//2020/04/08
		val.replace(/()()()/, "#1-$2-$3");
		//2020년04월08일
		val.replace(/()()()/, "#1-$2-$3");
		val = 010-1234-1234;
	}
}
function chkRegExp() {
	
}