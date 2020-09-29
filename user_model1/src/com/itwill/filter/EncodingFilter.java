package com.itwill.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class EncodingFilter implements Filter {
	private String encoding = null;
	/**
	 * web.xml에서 전달된 인코딩 값을 초기화하는 메써드.
	 * <filter>
		<filter-name>Encoding Filter</filter-name>
		<filter-class>com.itwill.filter.EncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name> 라인 23의 filterConfig.getInitParameter 에 들어가는 이름
			<param-value>UTF-8</param-value>
		</init-param>
	   </filter>
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		this.encoding = filterConfig.getInitParameter("encoding");
		System.out.println("생성직후 단한번호출 init(): encoding parameter-->"
					+ encoding);
	}
	

	/**
	 * ServletRequest객체에 web.xml에서 전달된 인코딩을 설정하는 메써드.
	 */
	public void doFilter(
		ServletRequest request,
		ServletResponse response,
		FilterChain chain)
		throws IOException, ServletException {
		//System.out.println("요청시마다 호출 doFilter()");
		// 요래 하믄 요청할 때마다 인코딩이 된당 
		//근데 getinitParameter를 통해서 이렇게 할 필요 없어짐
		//request.setCharacterEncoding("UTF-8");
		
		
		if (request.getCharacterEncoding() == null) {
			if (encoding != null) {
				request.setCharacterEncoding(encoding);
			}
		}
		chain.doFilter(request, response);
	}
	public void destroy() {
		//System.out.println("필터객체가 메모리에서 해지될때호출 destroy()");
		this.encoding = null;
	}
	
}
