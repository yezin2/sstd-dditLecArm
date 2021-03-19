/**
 * 
 */
var pop;
	function proc() {
		pop = window.open("http://google.com");
	}
	function proc2() {
		pop.close();
	}
	function showMsg() {
//		window.setTimeout();
//		setTimeout(alertMsg, 3000);
		setTimeout(function () {
			alert("타이머썼ㅇ");
		}, 3000);
		window.setTimeout(function () {
			alert("왜이래유~");
		}, 5000);
	}
	function changeBgColor() {
		setInterval(() => {
			
		}, 3000);
	}
	function changeColor() {
		//랜덤색을 p태그에 배경 넣어주기 
		//1. 랜덤색 뽑기
		//2. p태그에 배경 넣어주기
		var r=0, g=0, b=0;
		r = Math.floor(Math.random()*256)
		g = Math.floor(Math.random()*256)
		b = Math.floor(Math.random()*256)
		
		document.getElementById("pInterval").style.backgroundColor
		= "rgb(" +r+ ", " +g+ ", " +b+ ")";
		//"red", "#ff0055", "rgb(255,0,255)"
		//<p id="pInterval" style="background-color: yellow;">버튼을 누르면 3초간격으로 색이 바뀜</p>
	}
/* 	function alertMsg() {
		alert("타이머썼ㅇ");
	} */