<%@page import="com.itwill.user.User"%>
<%@page import="com.itwill.user.exception.UserNotFoundException"%>
<%@page import="com.itwill.user.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file = 'login_check.jspf' %>
<!-- 오류는 서비스에서 확인을 먼저 하고 서비스가 잘 돌아가면 크롬 디버거(F12키 network) 확인해서 찾아내라!!!!!!!!! -->
<%
	String userId = request.getParameter("userId");
	if(userId==null|| userId.equals("")){
		response.sendRedirect("user_main.jsp");
		return;
	}
	User user=null;
	try{
	UserService userService = new UserService();
	user=userService.findUser(userId);
	}catch(UserNotFoundException e){
		out.println("<script>");
		out.println("alert('"+e.getMessage()+"');");
		//이전 리스트로 돌아가기
		//out.println("history.back()");
		out.println("location.href='user_list.jsp'");
		out.println("</script>");
		return;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<script type="text/javascript">
	function userList() {
		document.f.action = "user_list.jsp";
		document.f.submit();
		//location.href="user_list.jsp";
	}

	function userModifyForm() {
		document.f.action = "user_modify_form.jsp";
		document.f.method = "POST";
		document.f.submit();
	}

	function userRemove() {
		if (window.confirm("정말 삭제하시겠습니까?")) {
			document.f.action = "user_remove_action.jsp";
			document.f.method = "POST";
			document.f.submit();
		}
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			
<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 사용자 정보보기</b></td>
								</tr>
							</table> <!-- view Form  -->
							<form name="f" method="post">
								<input type="hidden" name="userId" value="<%=user.getUserId() %>" />
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											<%=user.getUserId() %>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											<%=user.getName() %>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이메일
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											<%=user.getEmail() %>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center>
									<input type="button" value="수정" onClick="userModifyForm()"> &nbsp; 
									<input type="button" value="삭제" onClick="userRemove()"> &nbsp; 
									<input type="button" value="목록" onClick="userList()"></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>