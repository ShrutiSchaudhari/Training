package com.concerto.Test1;

import org.springframework.stereotype.Component;

@Component
public class Command1 implements Task{

	public void execute() {
		System.out.println("I am in command 1");
		
	}

}
