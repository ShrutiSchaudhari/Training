package com.SpringAOP.AOPDemo.Aspect;

import java.util.List;

import javax.sound.midi.Soundbank;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.SpringAOP.AOPDemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.SpringAOP.AOPDemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint ) throws Throwable{
		
		//print the method
		String  method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n----------->> executing @Around advice  method  "+ method);
		// begin time stamp
		long begin = System.currentTimeMillis();
		
		//execute method
		Object result = theProceedingJoinPoint.proceed();
		//get end time stamp
		
		//compute duration and display it
		
				return null;
		
	}
			
	
	
	
	
	
	@After("execution(* com.SpringAOP.AOPDemo.DAO.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		
		String  method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n----------->> executing @after advice  method  "+ method);
		
	}
	
	
	@AfterThrowing(
			pointcut = "execution(* com.SpringAOP.AOPDemo.DAO.AccountDAO.findAccount(..))" ,
			throwing ="theExe"
			
			)
	
	public void afterThrowingFindAccountAdvice(
			JoinPoint theJoinPoint ,Throwable theExe)
	{
		//print
		String  method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n----------->> executing @afterThrowing advice  method  "+ method);
	
		System.out.println("\n----------->>execption "+ theExe);
		//log
		
		
		
	}
	
	
	
	
	//add new advice for after returning advice
	@AfterReturning(
			pointcut = "execution(* com.SpringAOP.AOPDemo.DAO.AccountDAO.findAccount(..))",
			returning = "result"
			//returning value should be same value as a parameter
			)
	public void afterreturningFindAccountAdvice(JoinPoint theJoinPoint ,List<Account> result) {
		
		//print which method we are advicing on
		
		String  method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n----------->> executing @afterreturning advice  method  "+ method);
		// print results
		System.out.println("\n----------->> executing @afterreturning advice  result "+ result);
		
		//modify the data / post process the data
		
		//concert the acoount name to uppercase
		
		convertAccountNametoUpperCase(result);
		System.out.println("\n-------->> result is :" + result);
	}
	
	

	

	private void convertAccountNametoUpperCase(List<Account> result) {
		
		
		for(Account tempAccount : result) {
			
			String theUpperName = tempAccount.getName().toUpperCase();
			
			tempAccount.setName(theUpperName);
		}
		
	}





	// this is where we add all of our related advices for logging 
	
	// @before advice
	
	
	@Before("com.SpringAOP.AOPDemo.Aspect.AopExpression.dorDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n------>> excecuting Logging advice method");
	//display the method signature
	MethodSignature theMethodSignature= (MethodSignature) theJoinPoint.getSignature();
	System.out.println("Method :" +theMethodSignature);
	
		//display method arguements
	
	
	//get args
	Object[] args = theJoinPoint.getArgs();
	
	//loop through args
	for (Object tempArgs : args)	
	{
		System.out.println(tempArgs);
		
		if(tempArgs instanceof Account) {
			
			//downcast and print account spcific stuff
			
			Account theAccount = (Account) tempArgs;
			System.out.println(" Account Name: "+ theAccount.getName());
			System.out.println(" Account level: "+ theAccount.getLevel());
			
		}
	}
	
	}

	
	
}
