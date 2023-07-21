package com.SpringDev.SpringApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringDev.SpringApp.comman.Coach;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;



@RestController
public class DemoController {
	
	//no need for constructor or setters

	private Coach coachName;
	//private Coach anothercoachName;
	
	@Autowired
	public DemoController(@Qualifier("aquatic") Coach coach){
		coachName= coach;
	}
	
	  
	//Bean Scope 
//	@Autowired
//	public DemoController(
//			@Qualifier("tennisCoach") Coach coach ,
//			@Qualifier("tennisCoach") Coach anothercoach )
//	{
//		System.out.println("In constructor " + getClass().getSimpleName());
//		coachName= coach;
//		anothercoachName =anothercoach;
//	}
	
	
	
	//for primary annotation we mention @primary to the class 
//	@Autowired
//	public DemoController( Coach coach){
//		coachName= coach;
//	}
	
	
	//Qualifiers
//	@Autowired
//	public DemoController(@Qualifier("tennisCoach") Coach coach){
//		coachName= coach;
//	}
	
	//constructor injection
//	@Autowired
//	public DemoController(Coach coach){
//		coachName= coach;
//	}
//	
	
	//Setter Injection 
	//@Autowired
	//we can set any name for setter injection because of autowired 
//	public void setCoach(Coach coachName) {
//		this.coachName = coachName;
//	}
	
	
	@GetMapping("/dailyworkout")
		
		public String getDailyWorkout() {
			return coachName.getDailyWorkout();
		}

	//for bean scope checking
//	@GetMapping("/check")
//	public String check() {
//		return "Comparing beans: coachName == anothercoachName," + (coachName == anothercoachName);
//	}
	
//	@Value("${coach.name}")
//	private String coachName;
//	
//	@Value("${team.name}")
//	private String teamName;
//	
//	
//	@GetMapping("/getinfo")
//	public String GetInfo()
//	{
//		return "Info " + coachName + teamName ;
//		
//	}
	}
