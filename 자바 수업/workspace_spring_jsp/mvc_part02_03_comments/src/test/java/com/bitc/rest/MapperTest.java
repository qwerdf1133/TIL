package com.bitc.rest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitc.rest.comment.model.CommentVO;
import com.bitc.rest.comment.repository.CommentMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations= {"classpath:/spring/root-context.xml"}
)
public class MapperTest {
	
	@Autowired
	CommentMapper mapper;
	
	@Test
	public void test() {
		try {
			List<CommentVO> list = mapper.commentList(2);
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end test
	
	
}













