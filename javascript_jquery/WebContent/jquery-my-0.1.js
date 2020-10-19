/** jQuery라는 속성을 정의*/
window.jQuery=function(selector){
	if( typeof selector=='string'){
		
	}else if(typeof selector=='function'){
		window.addEventListener('load',selector);
	}else if(typeof selector=='object'){
		
	}
	var elementNodeList = document.querySelectorAll(selector);
	var elementNode = document.querySelector(selector);
	var jQueryWrapperObject={
		'elementNodeList':elementNodeList,
		'elementNode':elementNode,
		'css':function(colorArg){
			for(var i=0;i<elementNodeList.length;i++){
				this.elementNodeList.item(i).style.color=colorArg;
			}
		},
		'text':function(textArg){
			if(textArg){ //있으면 set
				for(var i=0; i<elementNodeList.length;i++){
				elementNode.item(i).firstChild.nodeValue=textArg; //jQueryWrapperObject의 elementNode
				}
			}else{ //없으면 get
				return this.elementNode.firstChild.nodeValue;
			}
		}
	};
	return jQueryWrapperObject;
};
/*window.jQuery => window.$  같은거다.*/
window.$=window.jQuery;
