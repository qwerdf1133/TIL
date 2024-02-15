package com.bitc.rest.comment.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.bitc.board.util.Criteria;
import com.bitc.rest.comment.model.CommentVO;

public interface CommentMapper {
	
	/**
	 * 전체 댓글 목록
	 * @param bno - 읽어올 댓글의 게시글 번호
	 * @return - 해당 게시글의 전체 게시글 목록
	 */
	@Select("SELECT * FROM tbl_comment WHERE bno = #{bno} ORDER BY cno DESC")
	List<CommentVO> commentList(int bno) throws Exception;
	
	/**
	 * 댓글 등록 
	 * @param vo - 삽입될 댓글 정보
	 * @return - 삽입된 행의 개수
	 */
	@Insert("INSERT INTO tbl_comment(bno,content,author) VALUES(#{bno},#{content},#{author})")
	int insert(CommentVO vo) throws Exception;
	
	/**
	 * 댓글 수정
	 * @param vo - 수정할 댓글 정보
	 * @return - 수정된 행의 개수
	 */
	@Update("UPDATE tbl_comment SET "
			+ " content = #{content} , "
			+ " author = #{author} , "
			+ " updatedate = now() "
			+ " WHERE cno = #{cno}")
	int update(CommentVO vo) throws Exception;
	
	/**
	 * 댓글 삭제
	 * @param cno - 삭제할 댓글 번호
	 * @return - 삭제된 행의 개수
	 */
	@Delete("DELETE FROM tbl_comment WHERE cno = #{cno}")
	int delete(int cno) throws Exception;
	
	/**
	 * @param bno - 검색할 게시글 번호
	 * @return - 해당 게시글에 등록된 전체 댓글 개수
	 */
	@Select("SELECT count(*) FROM tbl_comment WHERE bno = #{bno}")
	int totalCount(int bno) throws Exception;
	
	/**
	 * @param bno -  페이징 처리된 댓글을 검색할 게시글 번호
	 * @param criteria - 페이징 처리된 게시글 목록 검색에 필요한 정보
	 * @return - 페이징 처리된 댓글 목록
	 */
	@Select("SELECT * FROM tbl_comment "
			+ " WHERE bno = #{bno} ORDER BY cno DESC "
			+ " limit #{cri.startRow} , #{cri.perPageNum}")
	// List<CommentVO> listPage(Map<String, Object> map) throws Exception;
	List<CommentVO> listPage(@Param("bno") int bno, @Param("cri") Criteria cri) throws Exception;

}
























