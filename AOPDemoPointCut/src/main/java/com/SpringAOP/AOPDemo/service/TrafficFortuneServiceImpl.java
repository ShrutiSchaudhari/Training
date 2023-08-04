package com.SpringAOP.AOPDemo.service;

import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortuneService{

	@Override
	public String getFortune() {
		
		//simulate delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		// return a fortune 
		
		
		return "Expect heavy traffic this morning";
	}

}
