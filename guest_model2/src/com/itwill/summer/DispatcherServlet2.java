package com.itwill.summer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;
import com.itwill.guest.controller.GuestViewController;


/*
 * 모든 요청의 진입점(단일 컨트롤러) // 우선 *.do 를 web.xml에 맵핑해주자
 */

public class DispatcherServlet2 extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request,response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dpGet() doPost() 모든 메소드에서 사용되는 메소드
		
		/*
		 * 1. 클라이언트의 요청 URL 사용해서 요청을 분석(구분)
		 */
		String requestURI = request.getRequestURI();
		//System.out.println("requestURI:"+requestURI);
		String contextPath = request.getContextPath();
		//System.out.println("contextPath:"+contextPath);
		String command = requestURI.substring(contextPath.length());
		//System.out.println("command: "+command);
		/*
		 * 2. 클라이언트의 요청에 따른 업무실행(XXService)
		 */
		//커맨드 패턴 요청커맨드(요구) 하나당 하나의 객체로 만드는 작업
		//각각의 command에서 controller 객체가 만들어지게끔 해야한다.
		String forwardPath="";
		Controller controller = null; //비즈니스 로직이 담겨질 controller객체
		if(command.equals("/guest_main.do")) {
			controller = new GuestMainController();
			//forwardPath = controller.handleRequest(request,response); //인자가 필요없더라도 항상 붙여줘야 한다 => 규칙임.
		}else if(command.equals("/guest_write_form.do")) {
			controller = new GuestWriteFormController();
		}else if(command.equals("/guest_list.do")) {
			controller = new GuestListController();
		}else if(command.equals("/guest_view.do")) {
			controller = new GuestViewController();
		}else if(command.equals("/guest_write_action.do")) {
			controller = new GuestWriteActionController();
		}else if(command.equals("/guest_modify_form.do")) {
			controller = new GuestModifyFormController();
		}else if(command.equals("/guest_modify_action.do")) {
			controller = new GuestModifyActionController();
		}else if(command.equals("/guest_remove_action.do")) {
			controller = new GuestRemoveActionController();
		}else {
			controller = new GuestErrorController();
		}
		
		//절대 바뀌지 않을 코드들
		//커맨드패턴을 통해서 여기서 처리된다.
		//controller에는 String 타입인 forwardPath가 반환 되어있는 상태이다.
		forwardPath = controller.handleRequest(request, response);
		/*
		 * JSP forward or redirect
		 */
		String [] pathArray = forwardPath.split(":");
		String forwardOrRedirect=pathArray[0];
		String path=pathArray[1];


		if(forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		}else {
			RequestDispatcher rd=request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
	}
}
