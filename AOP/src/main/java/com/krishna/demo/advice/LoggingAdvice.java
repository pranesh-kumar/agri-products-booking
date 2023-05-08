package com.krishna.demo.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);

	@Before("execution(* com.krishna.demo.*.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("Executing method: " + joinPoint.getSignature().getName());
	}

	@After("execution(* com.krishna.demo.*.*.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("Completed Executing method: " + joinPoint.getSignature().getName());
	}

	@Around("execution(* com.krishna.demo.*.*.*(..))")
	public void logAround(JoinPoint joinPoint) {
		System.out.println("Started and Completed Executing method: " + joinPoint.getSignature().getName());
	}

	/* Point cut */

	@Pointcut(value = "execution(* com.krishna.demo.*.*.*(..) )")
	public void myPointcut() {

	}

	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(array));
		Object object = pjp.proceed();
		log.info(className + " : " + methodName + "()" + "Response : " + mapper.writeValueAsString(object));
		return object;
	}

}
