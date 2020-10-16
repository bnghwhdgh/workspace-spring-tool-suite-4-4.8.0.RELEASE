/*
생성자함수
*/
function AjaxRequest(url,params,callback,method){
	this.xhr=this.getXMLHttpRequest();
	this.url=url;
	this.params=params;
	this.callback=callback;
	this.method=method;
	//this.sendRequest();
}
AjaxRequest.prototype={
		'getXMLHttpRequest':function(){
			if(window.XMLHttpRequest){
				return new XMLHttpRequest();
			}else{
				return null;
			}
		},
		'sendRequest':function(){
			//this.xhr = this.getXMLHttpRequest();
			var httpMethod = this.method ? this.method : 'GET';
			if (httpMethod != 'GET' && httpMethod != 'POST') {
				httpMethod = 'GET';
			}
			var httpParams = (this.params == null || this.params == '') ? null : this.params;
			var httpUrl = this.url;
			if (httpMethod == 'GET' && httpParams != null) {
				httpUrl = httpUrl + "?" + httpParams;
			}
			//this.xhr.onreadystatechange=this.callback;
			var ajaxRequest =this;
			this.xhr.onreadystatechange=function(){ //onreadystatechange에 속한 function => 호출의 주체는 xhr
				//this.callback('어렵네여') 에러뜸 왜냐면 여기서 this는 AjaxRequest 가 아니라 xhr 이다.
				ajaxRequest.callback(this) //여기서 괄호의 this는 xhr이다..
			};
			this.xhr.open(httpMethod, httpUrl, true);
			this.xhr.setRequestHeader(
				'Content-Type', 'application/x-www-form-urlencoded');
			this.xhr.send(httpMethod == 'POST' ? httpParams : null);
		}
};

