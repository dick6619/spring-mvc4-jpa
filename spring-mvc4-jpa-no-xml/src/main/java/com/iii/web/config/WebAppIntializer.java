package com.iii.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.iii.app.config.DatabaseConfig;

public class WebAppIntializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		//
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		// DB
		webContext.register(DatabaseConfig.class);
		// 
		webContext.register(WebMVCConfig.class);
		webContext.setServletContext(container);
		ServletRegistration.Dynamic reg = container.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
		reg.setLoadOnStartup(1);
		reg.addMapping("/");
	}

}
