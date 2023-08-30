package com.concerto.Test1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.concerto.Test1") 
public class AppConfig {

	@Bean
	public Command1 command1() {
		return new Command1();
	}
	
	@Bean
	public Command2 command2() {
		return new Command2();
	}
	
}
