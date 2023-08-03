package com.SpringAOP.AOPDemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging 
	
	// @before advice
	
	//point cut expression
	//@Before("execution(public void com.SpringAOP.AOPDemo.DAO.AccountDAO.addAccount())")
	//@Before("execution(public void updateAccount())")
	//@Before("execution(public void add*())")
	//@Before("execution( void add*())")
	//@Before("execution( * add*())")
	//@Before("execution( * add*(com.SpringAOP.AOPDemo.Account, ..))")
	
	//@Before("execution( * add*(Account))")//gives error of invalidabolutetypename
	@Before("execution( * add*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n------>> excecuting @Before advice on method");
	}
}
