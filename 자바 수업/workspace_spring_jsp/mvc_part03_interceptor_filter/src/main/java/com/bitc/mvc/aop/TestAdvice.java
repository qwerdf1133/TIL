package com.bitc.mvc.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect 	// AOP Advice 등록
@Component	// 스프링 bean 등록
@Slf4j		// logger 추가
public class TestAdvice {

	@Around("execution(* com.bitc.mvc.controller.HomeController.*(..))")
	public Object controllerLog(ProceedingJoinPoint pjp) throws Throwable{
		log.info("======================================================");
		log.info("===============Around Controller START ===============");
		log.info("target : {} " , pjp.getTarget());
		log.info("method : {} " , pjp.getSignature().getName());
		log.info("args : {} " , Arrays.toString(pjp.getArgs()));
		Object o = pjp.proceed();	// 실체 메소드 호출
		if(o != null) {
			log.info("Around : {} " , o);
		}
		log.info("===============Around Controller END ===============");
		log.info("====================================================");
		return o;
	}
	
}














