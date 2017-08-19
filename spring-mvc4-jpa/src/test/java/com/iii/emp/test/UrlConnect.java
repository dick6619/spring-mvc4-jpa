package com.iii.emp.test;

import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnect {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://localhost:8080/spring-mvc4-jpa/restWS/testDefault");
			HttpURLConnection urlConnetion = (HttpURLConnection) url.openConnection();
			urlConnetion.setRequestMethod("OPTIONS");
			System.out.println(urlConnetion.getHeaderField("Allow"));
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
