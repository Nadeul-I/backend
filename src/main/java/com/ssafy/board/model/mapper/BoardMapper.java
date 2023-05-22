package com.ssafy.board.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.BoardSearchDto;

@Mapper
public interface BoardMapper {
	int writeBoard(BoardDto boardDto) throws SQLException;

	List<BoardDto> listBoard(BoardSearchDto boardSearchDto) throws SQLException;
	
	int getTotalBoardCount(BoardSearchDto boardSearchDto) throws SQLException;
	
	BoardDto getBoard(int boardNo) throws SQLException;
	
	boolean updateHit(int boardNo) throws SQLException;
	
	boolean modifyBoard(BoardDto boardDto) throws SQLException;
	
	boolean deleteBoard(int articleNo) throws SQLException;
}
