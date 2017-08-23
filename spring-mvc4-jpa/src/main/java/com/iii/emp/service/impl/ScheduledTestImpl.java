package com.iii.emp.service.impl;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.iii.emp.service.ScheduledTest;

@Service
public class ScheduledTestImpl implements ScheduledTest {

	// private static final Logger LOG =
	// LoggerFactory.getLogger(ScheduledTestImpl.class);
	private int i;

	public ScheduledTestImpl() {
		// LOG.info("ScheduledTestImpl...START");
	}

	// when instance create, delay 1 seconds, this method execute once every 10
	// seconds
	@Scheduled(initialDelay = 1000, fixedDelay = 10000)
	public void print() {
		System.out.println(++i + "******************************************************");
	}

}
