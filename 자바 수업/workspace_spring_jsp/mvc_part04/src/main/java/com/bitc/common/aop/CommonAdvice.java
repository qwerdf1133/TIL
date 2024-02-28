package com.bitc.common.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class CommonAdvice {
	
	/**
	 * 반환타입과 매개변수에 상관 없이
	 *  com.bitc.*.controller package에 있는
	 *  모든 class를 타겟으로 지정하고
	 *  모든 method를 joinPoints로 지정
	 */
	@Around("execution(* com.bitc.*.controller.*.*(..))")
	public Object checkControllerLog(ProceedingJoinPoint pjp) throws Throwable{
		log.info("--------------  Advice CheckController START ------------");
		log.info("target : {} " , pjp.getTarget());
		log.info("method : {} ", pjp.getSignature().getName());
		log.info("Arguments : {} " , Arrays.toString(pjp.getArgs()));
		Object o = pjp.proceed();
		log.info("return : {} ", o);
		log.info("--------------  Advice CheckController END ------------");
		return o;
	}
	
	@Around("execution(* com.bitc.*.service.*.*(..))")
	public Object checkServiceLog(ProceedingJoinPoint pjp) throws Throwable{
		log.info("--------------  Advice checkServiceLog START ------------");
		log.info("target : {} " , pjp.getTarget());
		log.info("method : {} ", pjp.getSignature().getName());
		log.info("Arguments : {} " , Arrays.toString(pjp.getArgs()));
		Object o = pjp.proceed();
		log.info("return : {} ", o);
		log.info("--------------  Advice checkServiceLog END ------------");
		return o;
	}
	
}












