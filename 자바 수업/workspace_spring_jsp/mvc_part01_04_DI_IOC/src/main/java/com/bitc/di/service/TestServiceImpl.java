package com.bitc.di.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service("ts")
@Slf4j
public class TestServiceImpl implements TestService {
	
	public TestServiceImpl() {
		log.info("testService Impl »ý¼º");
	}
	
	@Override
	public void testService(String message) {
		log.info("test service message : {} ",message);
	}

}
