package com.bitc.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


/**
 * pom.xml aspectjtools 의존성 추가
 * servlet-context.xml 
 * component-scan aop 패키지 추가
 * aop:auto-proxy 태그 추가
 */
@Aspect	// AOPAdvice 클래스 임을 명시
@Slf4j
@Component
public class AOPAdvice {
	
	public AOPAdvice() {
		log.info("AOP Advice 생성");
	}
	
	// target joinPoint(method) 가 실행 되기 전 호출
	// @Before("execution(com.bitc.vo.MessageVO )")
	@Before("execution(* com.bitc.service.*.*(..))")
	public void startLog(JoinPoint jp) {
		log.info("--------------------------------");
		log.info("--------------------------------");
		log.info("---------- START LOG ---------");
		log.info("target : {}", jp.getTarget());
		log.info("type : {}", jp.getKind());
		log.info("parameters : {}", Arrays.toString(jp.getArgs()));
		log.info("name : {}", jp.getSignature().getName());
		log.info("------- START LOG END---------");
	}
	
	@After("execution(* com.bitc.service.MessageServiceImpl.*(..))")
	public void endLog() {
		log.info("--------END AFTER LOG --------");
		log.info("-------------------------------");
	}
	
}
















