package net.koreate.board;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bitc.board.dao.BoardDAO;
import com.bitc.board.util.Criteria;
import com.bitc.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations= {"classpath:/spring/root-context.xml"}
)
public class BoardDAOTest {

	@Autowired
	BoardDAO dao;
	
	// @Test
	public void testMapper() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("첫번째 게시글");
		vo.setContent("테스트용 게시글 입니다.");
		vo.setWriter("최기근");
		int result = dao.create(vo);
		System.out.println("삽입된 행의 개수 : " + result);
	}
	
	@Test
	public void read() throws Exception {
		BoardVO vo = dao.read(1);
		System.out.println(vo);
	}
	
	@Test
	public void update() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("1번 게시글 수정");
		vo.setContent("테스트용 게시글 내용 수정");
		vo.setWriter("원빈");
		int result = dao.update(vo);
		System.out.println("수정 result " + result);
	}
	
	@Test
	public void Delete() throws Exception{
		int result = dao.delete(1);
		System.out.println("result 삭제 : " + result);
	}
	
	@Test
	public void updateCnt() throws Exception{
		dao.updateCnt(1);
	}
	
	@Test
	public void listAll() throws Exception{
		List<BoardVO> board = dao.listAll();
		System.out.println("listAll : " + board);
		
		List<BoardVO> boardList = dao.listCriteria(new Criteria());
		System.out.println("list criteria : " + boardList);
		
		int totalCount = dao.totalCount();
		System.out.println("totalCount : " + totalCount);
	}
	
}