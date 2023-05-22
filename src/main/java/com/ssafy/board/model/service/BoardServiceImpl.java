package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.BoardSearchDto;
import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.util.PageNavigation;

@Service
public class BoardServiceImpl implements BoardService {

	private BoardMapper boardMapper;

	public BoardServiceImpl(BoardMapper boardMapper) {
		super();
		this.boardMapper = boardMapper;
	}

	@Override
	public int writeBoard(BoardDto boardDto) throws Exception {
		boardMapper.writeBoard(boardDto);
		return boardDto.getBoardNo();
	}

	@Override
	public List<BoardDto> listBoard(BoardSearchDto boardSearchDto) throws Exception {
		int start = (boardSearchDto.getPgno() - 1) * boardSearchDto.getListSize();
		boardSearchDto.setStart(start);
		
		return boardMapper.listBoard(boardSearchDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardSearchDto boardSearchDto) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = boardSearchDto.getNavSize();
		int sizePerPage = boardSearchDto.getListSize();
		int currentPage = boardSearchDto.getPgno();

		pageNavigation.setCurrentPage(currentPage);
		pageNavigation.setNaviSize(naviSize);

		int totalCount = boardMapper.getTotalBoardCount(boardSearchDto);
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / sizePerPage + 1;
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = currentPage <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < currentPage;
		pageNavigation.setEndRange(endRange);
		int startPage = (currentPage - 1) / naviSize * naviSize + 1;
		pageNavigation.setStartPage(startPage);
		int endPage = startPage + naviSize -1;
		if(totalCount < endPage) {
			endPage = totalCount;
		}
		pageNavigation.setEndPage(endPage);

		return pageNavigation;
	}

	@Override
	public BoardDto getBoard(int boardNo) throws Exception {
		return boardMapper.getBoard(boardNo);
	}

	@Override
	public boolean updateHit(int boardNo) throws Exception {	
		return boardMapper.updateHit(boardNo);
	}

	@Override
	public boolean modifyBoard(BoardDto boardDto) throws Exception {
		return boardMapper.modifyBoard(boardDto);
	}

	@Override
	public boolean deleteBoard(int boardNo) throws Exception {
		return boardMapper.deleteBoard(boardNo);
	}

}
