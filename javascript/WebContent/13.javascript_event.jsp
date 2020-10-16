<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function displayMessage(msg){
		document.getElementById('result').innerHTML += msg+"<br>";
	}
	function inlineEventHandler(e){
		var msg = 'inlineEventHandler:'+e.target+","+e.type+","+"this: "+this; //여기서 this는 window 소속이다.
		displayMessage(msg);
	}
	function button2EventHandler(e){
		var msg = 'button2EventHandler:'+e.target+","+e.type+","+"this: "+this+"this.value: "+this.value; //호출의 주체가 button이 된다.
		displayMessage(msg);
	}
	function button3EventHandler1(e){
		var msg = 'button3EventHandler1:'+e.target+","+e.type+","+"this: "+this+"this.value: "+this.value; //호출의 주체가 button이 된다.
		displayMessage(msg);
	}
	function button3EventHandler2(e){
		var msg = 'button3EventHandler2:'+e.target+","+e.type+","+"this: "+this+"this.value: "+this.value; //호출의 주체가 button이 된다.
		displayMessage(msg);
	}
	//이벤트 등록작업
	function event_regist(){
		/***DOM LEVEL-0****/
		
		/**********case1*********/
		var button2E = document.f.button2;  //id가 아닌 name으로 접근, name이 2개 이상이다 하면 [0] ,[1] ...이런식으로 Array처럼 써주자
		
		/**********case2*********/
		//var button2E = document.getElementById('button2');
		
		/**********case3*********/
		//var button2ENodeList = document.getElementsByName('button2');
		//var button2E =button2ENodeList.item(0);



		button2E.onclick = button2EventHandler; //()쓰지마라, 실행후의 결과를 호출하면 안됨!
		/*button2E.onclick = function(){
		}*/

		/***DOM LEVEL-2****/
		var buttonE3 = document.f.button3;
		buttonE3.addEventListener('click',button3EventHandler1); //addEventListener(이벤트의 타입, 함수)
		buttonE3.addEventListener('click',button3EventHandler2); 
		buttonE3.addEventListener('mouseover',function(e){
			var msg = 'button3익명EventHandler1:'+e.target+","+e.type+","+"this: "+this+"this.value: "+this.value; //호출의 주체가 button이 된다.
			displayMessage(msg);
		}); //addEventListener(이벤트의 타입, 함수)
		buttonE3.addEventListener('mouseout',function(e){
			var msg = 'button3익명EventHandler2:'+e.target+","+e.type+","+"this: "+this+"this.value: "+this.value; //호출의 주체가 button이 된다.
			displayMessage(msg);
		}); //addEventListener(이벤트의 타입, 함수)
		
		document.f.button4.addEventListener('click',function(){
			//돔 레벨 0,1은 이렇게 지우자
			document.f.button1.onclick=null;
			document.f.button2.onclick=null;
			//돔레벨2는 이런식으로 지우기
			document.f.button3.removeEventListener('click',button3EventHandler1)
			document.f.button3.removeEventListener('click',button3EventHandler2)
		});

		var olistE = document.getElementById('movie_rank');
		var liNodeList = olistE.getElementsByTagName('li'); //document.getElementsByTagName('li'); 이렇게 하면 'li' 전부 뜸
		for(var i=0;i<liNodeList.length;i++){
			liNodeList.item(i).addEventListener('click',function(e){ //이때 e에 우리가 클릭한 놈이 들어온다.
				var clickMovieName = e.target.innerHTML;
				displayMessage("클릭한 영화는 "+clickMovieName);
				
			})
		}
		
		
		
		
	}
	/*
	 window.onload 이벤트발생시점
	  - DOM트리로딩직후 랜더링(image)전에호출
	*/
	window.onload = event_regist;
	//window.onload =ui_init; // 이렇게 하면 최후에 선언된  window.onload 만 출력
	window.onload = function(){
			event_regist();
			//ui_init(); 익명함수를 써서 두개 이상의 함수를 사용할 수 있게 됨
		}
	
</script>
</head>
<body>
<h1>javascript event</h1><hr/>
<form name="f">
	<input onclick="inlineEventHandler(event)" 
			name="button1" 
			type="button" 
			value="event model[inline]"/>
	<input id="button2" name="button2" type="button" value="event model[DOM level0]"/>
	<input name="button3" type="button" value="event model[DOM level2]"/>
	<input name="button4" type="button" value="event remove"/>
</form>
<ol id='movie_rank'>
	<li>조커</li>
	<li>람보</li>
	<li>AI</li>
	<li>알라딘</li>
	<li>체르노빌</li>
</ol>
<div id="result">
	
</div>
<script type="text/javascript">
	//event_regist();
</script>
</body>
</html>














