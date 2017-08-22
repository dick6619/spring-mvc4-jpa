package com.iii.emp.service.impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.iii.emp.service.ScheduledTest;

@Service
public class ScheduledTestImpl implements ScheduledTest {

	private int i;

	// when instance create, delay 1 seconds, this method execute once every 10 seconds
	@Scheduled(initialDelay = 1000, fixedDelay = 10000)
	public void print() {
		System.out.println(++i + "******************************************************");
	}

}