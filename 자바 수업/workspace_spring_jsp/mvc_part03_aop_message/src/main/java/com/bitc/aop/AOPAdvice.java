package com.bitc.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bitc.mapper.MessageMapper;
import com.bitc.vo.MessageVO;

import lombok.extern.slf4j.Slf4j;

/**
 * pom.xml aspectjtools 의존성 추가 
 * servlet-context.xml 
 * component-scan aop 패키지 추가
 * aop:auto-proxy 태그 추가
 */
@Aspect // AOPAdvice 클래스 임을 명시
@Slf4j
@Component
public class AOPAdvice {

	public AOPAdvice() {
		log.info("AOP Advice 생성");
	}

	/*
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

	@AfterThrowing(
			value = "execution(* com.bitc.service.*.*(..))", 
			throwing = "exception")
	public void endThrowing(JoinPoint jp, Exception exception) {
		log.info("---------------------------------------------");
		log.info("-------------START @AfterThrowing LOG-------------");
		log.info("target : {} ", jp.getTarget());
		log.info("name : {} ", jp.getSignature().getName());
		log.warn("error : {}", exception.getMessage());
		log.info("-------------END @AfterThrowing LOG-------------");
		log.info("---------------------------------------------");
	}
	
	// 타겟 메소드가 작업 수행 후 정상적으로 값을 반환 하고 난 뒤
	@AfterReturning(
		pointcut = "execution(!void com.bitc.service.MessageServiceImpl.*(..))",
		returning = "returnValue"
	)
	public void successLog(JoinPoint jp, Object returnValue) {
		log.info("---------------------------------------------");
		log.info("-------------START @AfterReturning LOG-------------");
		log.info("target : {} ", jp.getTarget());
		log.info("name : {} ", jp.getSignature().getName());
		log.warn("return : {}", returnValue);
		log.info("-------------END @AfterReturning LOG-------------");
		log.info("---------------------------------------------");
	}
	*/
	
	@Around("execution(* com.bitc.service.*.*(..))")
	public Object serviceLog(ProceedingJoinPoint pjp) throws Throwable{
		log.info("----------------------------------");
		log.info("---------- AROUND START -------------");
		log.info("target : {}" , pjp.getTarget());
		log.info("name : {}", pjp.getSignature().getName());
		log.info("parameter : {}", Arrays.toString(pjp.getArgs()));
		// Before
		// target 실체 객체의 pointcut method 호출
		Object o = pjp.proceed();
		//AFTER
		log.info("around AFTER : {} " , o);
		log.info("---------- AROUND END -------------");
		log.info("----------------------------------");
		return o;
	}
	
	@Autowired
	MessageMapper mapper;
	
	@Around(value="execution(* com.bitc.service.MessageServiceImpl.readMessage(String,int)) && args(uid, mno)")
	public Object checkReadMessage(ProceedingJoinPoint pjp, String uid, int mno) throws Throwable {
		log.info("-----------------------------------------");
		log.info("-----------checkReadMessage AROUND START-----------");
		log.info("parameters : {}", Arrays.toString(pjp.getArgs()));
		log.info("uid : " + uid);
		log.info("mno : " + mno);
		// 메세지 번호가 일치하는 메세지 정보를 MessageVO 타입으로 반환
		MessageVO vo = mapper.readMessage(mno);
		if(vo.getOpendate() != null) {
			log.info(" throw readMessage : {}" , vo);
			log.info(" throw checkReadMessage AROUND END");
			throw new NullPointerException("이미 수신한 메세지 입니다.");
		}
		log.info("Before End------------------------------------");
		Object o = pjp.proceed();
		vo = (MessageVO)o;
		vo.setMessage("Arround에서 메세지 정보 변경");
		log.info("-----------checkReadMessage AROUND END-----------");
		return vo;
		
	}
}
















