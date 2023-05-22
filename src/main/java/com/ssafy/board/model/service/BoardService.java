package com.ssafy.board.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.BoardSearchDto;
import com.ssafy.util.PageNavigation;

public interface BoardService {
	int writeBoard(BoardDto boardDto) throws Exception;

	List<BoardDto> listBoard(BoardSearchDto boardSearchDto) throws Exception;

	PageNavigation makePageNavigation(BoardSearchDto boardSearchDto) throws Exception;

	BoardDto getBoard(int boardNo) throws Exception;

	boolean updateHit(int boardNo) throws Exception;

	boolean modifyBoard(BoardDto boardDto) throws Exception;

	boolean deleteBoard(int boardNo) throws Exception;

}
