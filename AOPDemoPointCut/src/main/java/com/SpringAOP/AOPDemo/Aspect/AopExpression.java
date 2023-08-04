package com.SpringAOP.AOPDemo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpression {

	//point cut expression

		@Pointcut("execution( * com.SpringAOP.AOPDemo.DAO.*.*(..))")
		public void forDaoPackage() {
			}
		
		//create pointcut for getter 
		@Pointcut("execution( * com.SpringAOP.AOPDemo.DAO.*.get*(..))")
		public void getter() {}
		
		
		//create pointcut for setter
		@Pointcut("execution( * com.SpringAOP.AOPDemo.DAO.*.set*(..))")
		public void setter() {}
		
		
		//create pointcut : include package but exclude getter/setter
		@Pointcut("forDaoPackage() && !(getter() || setter())" )
		public void dorDaoPackageNoGetterSetter() {}
		
		
}
