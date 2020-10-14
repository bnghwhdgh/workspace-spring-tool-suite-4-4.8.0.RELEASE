<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function displayMessage(msg){
		
	}
	function inlineEventHandler(e){
		
	}
	function button2EventHandler(e){
		
	}
	function button3EventHandler1(e){
		
	}
	function button3EventHandler2(e){
		
	}
	function event_regist(){
		/***DOM LEVEL-0****/
		
		/***DOM LEVEL-2****/
		
		
	
		
		
	}
	/*
	 window.onload 이벤트발생시점
	  - DOM트리로딩직후 랜더링(image)전에호출
	*/
	
	
	
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














