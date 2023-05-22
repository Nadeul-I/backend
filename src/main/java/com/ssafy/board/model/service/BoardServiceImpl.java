package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.BoardSearchDto;
import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.util.NavigationSize;
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
		return boardMapper.listBoard(boardSearchDto);
	}

	@Override
	public PageNavigation makePageNavigation(BoardSearchDto boardSearchDto) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = NavigationSize.naviSize;
		int listSize = NavigationSize.listSize;
		int currentPage = boardSearchDto.getPgno();

		pageNavigation.setCurrentPage(currentPage);
		
		// 총 글 개수
		int totalCount = boardMapper.getTotalBoardCount(boardSearchDto);

		// 시작 글
		int start = (currentPage - 1) * listSize;
		boardSearchDto.setStart(start);
		
		// 총 페이지 개수
		int totalPageCount = ((totalCount - 1) / listSize) + 1;
		pageNavigation.setTotalPageCount(totalPageCount);

		// 끝 페이지
		int endPage = (((currentPage - 1) / naviSize) + 1) * naviSize;

		//시작 페이지
		int startPage = endPage - naviSize + 1;
		if(startPage < 1) startPage = 1;

		pageNavigation.setStartPage(startPage);
		
		//끝 페이지
		if(endPage > totalPageCount) endPage = totalPageCount;
		
		pageNavigation.setEndPage(endPage);

		// 다음 버튼 활성화 해야하는가
		boolean startRange = startPage > 1;
		pageNavigation.setStartRange(startRange);
		
		// 이전 버튼 활성화 해야하는가
		boolean endRange = endPage < totalPageCount;
		pageNavigation.setEndRange(endRange);

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
