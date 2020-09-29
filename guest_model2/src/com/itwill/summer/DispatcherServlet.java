package com.itwill.summer;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

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

public class DispatcherServlet extends HttpServlet {

	public DispatcherServlet() {
		
	}
	
	private HashMap<String, Controller> controllerMap;
	
	public void init(ServletConfig config) throws ServletException { //최초실행시 한 번 호출되는 메소드
		
		
		/*
		 * <<The First Step>>
		super.init(config); // 이거 선언 해줘야 함
		controllerMap=new HashMap<String, Controller>();
		
		controllerMap.put("/guest_main.do", new GuestMainController());
		controllerMap.put("/guest_write_form.do", new GuestWriteFormController());
		controllerMap.put("/guest_write_action.do", new GuestWriteActionController());
		controllerMap.put("/guest_list.do", new GuestListController());
		controllerMap.put("/guest_view.do", new GuestViewController());
		controllerMap.put("/guest_modify_form.do", new GuestModifyFormController());
		controllerMap.put("/guest_modify_action.do", new GuestModifyActionController());
		controllerMap.put("/guest_remove_action.do", new GuestRemoveController());
		controllerMap.put("/guest_error.do", new GuestErrorController());
		*/
		//controllerMap.put() 내용을 web-inf에 프로퍼티 파일로 빼내는 작업이 필요함
		
		//<<The Second Step>>
		/*
		 * Controller객체들을 저장하는 맵
		 */
		super.init(config); // 이거 선언 해줘야 함
		controllerMap=new HashMap<String, Controller>();
		//web.xml load on startup
		//System.out.println(configFileRealPath);
		
		/*
		 * web.xml에설정된 파라메타값가져오기
		 * <servlet>
				<servlet-name>controller</servlet-name>
				<servlet-class>com.itwill.summer.DispatcherServlet</servlet-class>
				<init-param>
					<param-name>configFile</param-name>
					<param-value>/WEB-INF/guest_controller_mapping.properties</param-value>
				</init-param>
			</servlet>
		 */
		String confileFile=config.getInitParameter("configFile");
		String configFileRealPath = this.getServletContext().getRealPath(confileFile);
		//String configFileRealPath = this.getServletContext().getRealPath("WEB-INF/guest_controller_mapping.properties");
		
		try {
			FileInputStream pIn = new FileInputStream(configFileRealPath);
			Properties controllerMappingProperties = new Properties(); //properties는 맵의 자식이다. => 특징은 Key와 Value가 모두 String이다!!
			controllerMappingProperties.load(pIn);
			Set commandKeySet = controllerMappingProperties.keySet();
			Iterator commandIterator = commandKeySet.iterator(); //키셋은 인덱스가 없어서 iterator필요
			while(commandIterator.hasNext()) {
				String command=(String)commandIterator.next();
				String controllerClassName = controllerMappingProperties.getProperty(command);
				Class controllerClass=Class.forName(controllerClassName);
				Controller controllerObject = (Controller)controllerClass.newInstance();
				System.out.println(command+"=>"+controllerObject);
				controllerMap.put(command, controllerObject);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
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
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		/*
		 * 2. 클라이언트의 요청에 따른 업무실행(XXService)
		 */
		String forwardPath="";
		Controller controller = controllerMap.get(command); //비즈니스 로직이 담겨질 controller객체
		
		
		//절대 바뀌지 않을 코드들
		//커맨드패턴을 통해서 여기서 처리된다.
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
