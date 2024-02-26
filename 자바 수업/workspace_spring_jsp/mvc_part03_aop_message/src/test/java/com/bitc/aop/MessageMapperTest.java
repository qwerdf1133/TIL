package com.bitc.aop;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitc.mapper.MessageMapper;
import com.bitc.vo.MessageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/context/root-context.xml" })
public class MessageMapperTest {

	@Autowired
	MessageMapper mapper;

	// @Test
	public void testMapper() throws Exception {
		MessageVO vo = new MessageVO();
		vo.setTargetid("id002");
		vo.setSender("id001");
		vo.setMessage("니가 토르냐");
		mapper.create(vo);
	}

	// @Test
	public void test1Update() throws Exception {
		mapper.updateMessage(1);
	}

	@Test
	public void test2List() throws Exception {
		List<MessageVO> list = mapper.list();
		System.out.println(list);
		MessageVO read = mapper.readMessage(1);
		System.out.println(read);
	}

}
