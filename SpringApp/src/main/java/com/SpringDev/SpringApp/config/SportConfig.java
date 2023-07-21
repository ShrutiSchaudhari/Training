package com.SpringDev.SpringApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.SpringDev.SpringApp.comman.Coach;
import com.SpringDev.SpringApp.comman.SwimCoach;

@Configuration
public class SportConfig {

	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
		
	}
}
