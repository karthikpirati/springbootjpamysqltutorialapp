package com.springboot.SpringBootProject.springcore.interceptor;

import java.util.Enumeration;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * Interceptors will be use when we check something before accessing http request
 * Interceptor can use this for authentication,authorization
 * 
 * 
 */

@Component
public class TutorialAppInterceptor1 implements HandlerInterceptor{
	
	
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//	
//	
//			throws Exception {
//		
//		
//		System.out.println(request.getRequestURI());
//		/*
//		 * whenever client makes a request for the first time
//		 * server creates the cookie with name JsessionId cookie 
//		 * and send the response with this cookie
//		 * So next when same client makes request again we know that he is logged in user or not
//		*/
//		
//		/*
//		 * request params
//		 */
//		
//		Enumeration<?> params=request.getParameterNames();
//		while(params.hasMoreElements()) {
//			System.out.println(params.nextElement());
//		}
//		
//		/*
//		 * session params
//		 */
//		HttpSession session=request.getSession();
//		if(session!=null) {
//			// logic to get session info
//			Enumeration<String> attributes=session.getAttributeNames();
//			while(attributes.hasMoreElements()) {
//				System.out.println(attributes.nextElement());
//			}
//		}
//		
//		/*
//		 *cookie information
//		 */
//		Cookie[] ca=request.getCookies();
//		if(ca!=null) {
//			for(Cookie c:ca) {
//				System.out.println(c.getName());
//				System.out.println(c.getValue());
//			}
//		}
//		
//		
////		ca[ca.length+1]=new Cookie("", "");
//		
//		if(request.getRequestURI().equals("/post")) {
//			return false;
//		}else {
//			return true;
//		}
//				
//	}
	
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getRequestURI());
		return true;
	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		System.out.println("post handle");
	}
	
	
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable Exception ex) throws Exception {
		System.out.println("after completion");
	}

}
