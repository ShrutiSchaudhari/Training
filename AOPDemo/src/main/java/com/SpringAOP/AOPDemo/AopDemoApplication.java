package com.SpringAOP.AOPDemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SpringAOP.AOPDemo.DAO.AccountDAO;
import com.SpringAOP.AOPDemo.DAO.MembershipDAO;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
		
		return runner ->{
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO  theMembershipDAO) {
		
		//call the bussiness method
		Account myAccount = new Account();
		
		System.out.println("\n account \n");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		//do it again!
		
		System.out.println("\n membership \n");
		
		//call the bussiness method again
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		}
	
}
