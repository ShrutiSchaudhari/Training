package com.SpringDev.SpringApp.comman;



import org.springframework.stereotype.Component;

@Component

public class BaseBallCoach implements Coach{

	//constructor
	public BaseBallCoach() {
		System.out.println("In constructor " + getClass().getSimpleName());
		}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Spend 30 min in batting practice";
	}

}
