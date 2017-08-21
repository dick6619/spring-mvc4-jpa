package com.iii.framework.core.tools.listener;
//package com.iii.framework.listener;
//
//import java.net.MalformedURLException;
//import java.util.Enumeration;
//import java.util.Iterator;
//import java.util.Map;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
///**
// * Application Lifecycle Listener implementation class empListener
// *
// */
//@WebListener
//public class empListener implements ServletContextListener {
//
//	/**
//	 * Default constructor.
//	 */
//	public empListener() {
//		// TODO Auto-generated constructor stub
//	}
//
//	/**
//	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
//	 */
//	public void contextDestroyed(ServletContextEvent arg0) {
//		// TODO Auto-generated method stub
//	}
//
//	/**
////	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
//	 */
//	public void contextInitialized(ServletContextEvent event) {
//
//		// 每個Web應用程式都會有一個相對應的ServletContext, 大家都看的到的
//		ServletContext sc = event.getServletContext();
//
//		// ServletContext Attribute
//		Enumeration<String> em = sc.getAttributeNames();
//		while (em.hasMoreElements()) {
//			Object attributeName = sc.getAttribute(em.nextElement());
//			System.out.println("Context Attribute : " + attributeName);
//		}
//
//		// ServletContext InitParameter <context-param>
//		Enumeration<String> em1 = sc.getInitParameterNames();
//		while (em1.hasMoreElements()) {
//			String initParameterName = sc.getInitParameter(em1.nextElement());
//			System.out.println("InitParameter : " + initParameterName);
//		}
//
//		// registrations servlet
//		Map<String, ?> map = sc.getServletRegistrations();
//		Iterator<String> it = map.keySet().iterator();
//		while (it.hasNext()) {
//			String servletName = it.next();
//			System.out.println(servletName + ": " + map.get(servletName));
//		}
//
//		// webapp resource paths
//		for (String resourcePaths : sc.getResourcePaths("/")) {
//			System.out.println("webapp 底下所有第一層 + / : " + resourcePaths);
//		}
//		//
//		try {
//			System.out.println(sc.getResource("/WEB-INF/mvcConfig/mvcConfig.xml"));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}
//
//		// contextPath
//		System.out.println("通訊地址:埠號下 [專案名稱 path] 沒/ : " + sc.getContextPath());
//		// server name
//		System.out.println("server is : " + sc.getServerInfo());
//		// project name
//		System.out.println("project name is : " + sc.getServletContextName());
//
//	}
//
//}
