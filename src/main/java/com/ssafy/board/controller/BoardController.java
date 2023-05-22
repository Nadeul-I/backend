package com.ssafy.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.BoardSearchDto;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.util.PageNavigation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/board")
@Api("게시판 컨트롤러  API V1")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	private BoardService boardService;

	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}

	@ApiOperation(value = "게시판 목록", notes = "조건에 맞는 게시글들을 불러온다.", response = Map.class)
	@GetMapping("/list")
	public ResponseEntity<?> boardList(@ApiParam(value = "게시글 검색 조건", required = true) BoardSearchDto boardSearchDto)
			throws Exception {
		logger.info("boardList - 호출");

		Map<String, Object> map = new HashMap<>();

		List<BoardDto> list = boardService.listBoard(boardSearchDto);
		PageNavigation pageNavigation = boardService.makePageNavigation(boardSearchDto);

		map.put("boards", list);
		map.put("navigation", pageNavigation);
		map.put("search", boardSearchDto);

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@ApiOperation(value = "게시글 상세보기", notes = "게시글 번호를 통해 게시글을 불러온다.", response = BoardDto.class)
	@GetMapping("/view/{boardNo}")
	public ResponseEntity<?> boardView(
			@PathVariable("boardNo") @ApiParam(value = "게시글 번호", required = true) int boardNo) throws Exception {
		logger.info("boardView - 호출");

		BoardDto boardDto = boardService.getBoard(boardNo);
		System.out.println(boardService.updateHit(boardNo));

		return new ResponseEntity<BoardDto>(boardDto, HttpStatus.OK);
	}

	// 게시글 비어있는 여부 생각해볼필요가 있음
	@ApiOperation(value = "게시글 쓰기", notes = "입력을 바탕으로 게시글을 작성한다", response = String.class)
	@PostMapping("/write")
	public ResponseEntity<?> boardWrite(@RequestBody @ApiParam(value = "게시글 입력", required = true) BoardDto boardDto)
			throws Exception {
		logger.info("boardWrite - 호출");

		int check = boardService.writeBoard(boardDto);
		
		if (check != 0) {
			return new ResponseEntity<Integer>(check, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	// 게시글 삭제후 검색 정보 초기화
	// redirectAttributes.addAttribute("pgno", "1");
	// redirectAttributes.addAttribute("search", "");
	// redirectAttributes.addAttribute("word", "");

	@ApiOperation(value = "게시글 삭제", notes = "현재 게시글을 삭제한다.", response = String.class)
	@DeleteMapping("/delete/{boardNo}")
	public ResponseEntity<?> boardDelete(
			@PathVariable("boardNo") @ApiParam(value = "게시글 번호", required = true) int boardNo) throws Exception {
		logger.info("boardDelete - 호출");

		if (boardService.deleteBoard(boardNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);

	}

	@ApiOperation(value = "게시글 수정", notes = "현재 게시글을 수정한다.", response = String.class)
	@PutMapping("/modify")
	public ResponseEntity<?> boardModify(
			@RequestBody @ApiParam(value = "수정할 게시글 정보", required = true) BoardDto boardDto) throws Exception {
		logger.info("boardModify - 호출 {}");

		if (boardService.modifyBoard(boardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

}
