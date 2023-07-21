package com.SpringDev.SpringApp.comman;



import org.springframework.stereotype.Component;

//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PreDestroy;


@Component

public class CricketCoach implements Coach{

	public CricketCoach() {
		System.out.println("In constructor " + getClass().getSimpleName());
		}
//	
//	//define out init method
//		@PostConstruct
//		public void doMystartUpStuff() {
//			System.out.println("In doMystartupstuff() :" +getClass().getSimpleName());
//		}
//		
//		//define our destroy method
//		@PreDestroy
//		public void doMyCleanUpStuff() {
//			System.out.println("In doMycleanupstuff() :" +getClass().getSimpleName());
//		}
	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice 15 min fast bowling -- :)";
	}

}
