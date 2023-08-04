package com.SpringAOP.AOPDemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticAspect {

	
	@Before("com.SpringAOP.AOPDemo.Aspect.AopExpression.dorDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n------>>Performing Api analysis");
	}
	
}
