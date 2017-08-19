package com.iii.framework.listener;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class empListener
 *
 */
@WebListener
public class empListener implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public empListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext sc = event.getServletContext();
		
		Enumeration<String> em = sc.getAttributeNames();
		while(em.hasMoreElements()) {
			Object attributeName = sc.getAttribute(em.nextElement());
			System.out.println("AttributeName : " + attributeName);
		}
		
		Enumeration<String> em1 = sc.getInitParameterNames();
		while(em1.hasMoreElements()) {
			String initParameterName = sc.getInitParameter(em1.nextElement());
			System.out.println("InitParameterName : " + initParameterName);
		}
		
		Map<String, ?> map = sc.getServletRegistrations();
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next() + ": " + map.get(it.next()));
		}
		
	}

}
