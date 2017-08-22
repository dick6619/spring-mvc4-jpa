package com.iii.emp.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTest {
	
	private int i;
	// when instance new, this method being print
	@Scheduled(initialDelay = 10000, fixedDelay = 10000)
	public void print() {
		System.out.println(i++ + "******************************************************");
	}

}
