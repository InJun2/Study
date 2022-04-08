package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.board.dto.BoardDto;

@Mapper
public interface BoardMapper {

	@Select("select * from board where board_deleted = 'N'")
	public List<BoardDto> selectBoard() throws Exception;

	@Update("update board_seq set seq =(select seq +1 from (select seq from board_seq)tmp)")
	public void updateBoardSeq() throws Exception;

	@Insert("insert into board values ((select seq from board_seq) , #{boardTitle}, #{boardContent}, #{boardWriter}, sysdate(), 'N')")
	public int insertBoard(BoardDto boardDto) throws Exception;

	@Select("select * from board where board_no = ${boardNo} and board_deleted = 'N'")
	public BoardDto selectBoardDetail(String boardNo) throws Exception;

	@Update("update board set board_title = #{boardTitle}, board_content = #{boardContent} where board_no = ${boardNo} and board_deleted = 'N'")
	public int updateBoard(BoardDto boardDto) throws Exception;

	@Update("update board set board_deleted = 'Y' where board_no = ${deleteNo}")
	public int deleteBoard(String deleteNo) throws Exception;
}
