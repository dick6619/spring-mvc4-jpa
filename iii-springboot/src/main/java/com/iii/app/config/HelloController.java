package com.iii.app.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springboot")
public class HelloController {
	
	@GetMapping(value = "/say")
	public String sayHello() {
		return "hello, world!";
	}

}
