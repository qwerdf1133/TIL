package com.bitc.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitc.user.mapper.UserMapper;
import com.bitc.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = "classpath:context/root/root-context.xml"
)
public class MapperTest {
	
	@Autowired
	UserMapper mapper;
	
	@Test
	public void mapperTest() throws Exception{
		UserVO vo = new UserVO();
		vo.setUid("id005");
		vo.setUpw("pw005");
		vo.setUname("Spider Man");
		
		mapper.signUp(vo);
		
	}

}













