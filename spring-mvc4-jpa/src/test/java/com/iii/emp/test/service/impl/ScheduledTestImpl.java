package com.iii.emp.test.service.impl;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.iii.emp.test.service.ScheduledTest;

@Service
public class ScheduledTestImpl implements ScheduledTest {

	// private static final Logger LOG = LoggerFactory.getLogger(ScheduledTestImpl.class);

	public ScheduledTestImpl() {
	}

	// when instance create, delay 1 seconds, this method execute once every 10 seconds
	@Scheduled(initialDelay = 1000, fixedDelay = 10000)
	public void print() {
		 System.out.println("******************************************************");
	}

}
