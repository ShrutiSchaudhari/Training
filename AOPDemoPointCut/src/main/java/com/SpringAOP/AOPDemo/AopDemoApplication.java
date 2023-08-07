package com.SpringAOP.AOPDemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.SpringAOP.AOPDemo.DAO.AccountDAO;
import com.SpringAOP.AOPDemo.DAO.MembershipDAO;
import com.SpringAOP.AOPDemo.service.TrafficFortuneService;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, 
			MembershipDAO theMembershipDAO,
			TrafficFortuneService theTrafficFortuneService) {
		
		return runner ->{
			//demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
			//demoTheAfterReturnAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(theTrafficFortuneService);
			//demoTheAroundAdviceHandleException(theTrafficFortuneService);
			demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}

	private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {
System.out.println("\n Main prgm :Around  demoTheAroundAdviceRethrowException");
		
		System.out.println("Calling getFortune ");
		
		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\n My fortune is: "+data);
		System.out.println("Finished");
		
		
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {
System.out.println("\n Main prgm :Around  demoTheAroundAdviceHandleException");
		
		System.out.println("Calling getFortune ");
		
		boolean tripWire = true;
		String data = theTrafficFortuneService.getFortune(tripWire);
		
		System.out.println("\n My fortune is: "+data);
		System.out.println("Finished");
		
	}

	private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {
		
		System.out.println("\n Main prgm :Around  advice");
		
		System.out.println("Calling getFortune ");
		String data = theTrafficFortuneService.getFortune();
		
		System.out.println("\n My fortune is: "+data);
		System.out.println("Finished");
	}

	private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = null;
		try {
				boolean tripWire = false;
				
				theAccounts= theAccountDAO.findAccount(tripWire);
		}
		catch (Exception e) {
			System.out.println("\n main program : caught exception" + e);
		}
	//display the account
	System.out.println("\n main program : after throwing advice");
	System.out.println(theAccounts);
		
	}

	private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {
			List<Account> theAccounts = null;
			try {
					boolean tripWire = true;
					
					theAccounts= theAccountDAO.findAccount(tripWire);
			}
			catch (Exception e) {
				System.out.println("\n main program : caught exception" + e);
			}
		//display the acc
		System.out.println("\n main program : after throwing advice");
		System.out.println(theAccounts);
		
	}

	private void demoTheAfterReturnAdvice(AccountDAO theAccountDAO) {
		List<Account> theAccounts = theAccountDAO.findAccount();
		
		//display the acc
		System.out.println("\n main program : after return advice");
		System.out.println(theAccounts);
		
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO,MembershipDAO  theMembershipDAO) {
		
		//call the bussiness method
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinium");
		
		
		System.out.println("\n account \n");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		//do it again!
		//call get set from account
		theAccountDAO.setName("John");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		
		System.out.println("\n membership \n");
		
		//call the bussiness method again
		
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		}
	
}
