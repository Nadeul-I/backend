package com.ssafy.plan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.service.PlanService;
import com.ssafy.util.PageNavigation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/plan")
@Api("게시판 컨트롤러  API V1")
public class PlanController {

	private static final Logger logger = LoggerFactory.getLogger(PlanController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	private PlanService planService;
	
	public PlanController(PlanService planService) {
		super();
		this.planService = planService;
	}

	@ApiOperation(value = "여행 계획 목록", notes = "조건에 맞는 게시글들을 불러온다.", response = Map.class)
	@PostMapping("/list")
	public ResponseEntity<?> planList(@RequestBody @ApiParam(value = "유저 아이디", required = true) String userId, @RequestBody @ApiParam(value = "현재 페이지", required = true) int pgno)
			throws Exception {
		logger.info("planList - 호출");
		logger.info("검색 요건  확인 : {}", pgno);

		Map<String, Object> map = new HashMap<>();

		PageNavigation pageNavigation = planService.makePageNavigation(userId, pgno);
		List<PlanDto> list = planService.listPlan(userId, pgno);

		map.put("plans", list);
		map.put("navigation", pageNavigation);

		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}

	@ApiOperation(value = "여행 계획 상세보기", notes = "여행 계획 번호를 통해 정보를 불러온다.", response = PlanDto.class)
	@GetMapping("/view/{planNo}")
	public ResponseEntity<?> planView(
			@PathVariable("planNo") @ApiParam(value = "게시글 번호", required = true) int planNo) throws Exception {
		logger.info("planView - 호출");

		PlanDto planDto = planService.getPlan(planNo);

		return new ResponseEntity<PlanDto>(planDto, HttpStatus.OK);
	}

	// 게시글 비어있는 여부 생각해볼필요가 있음
	@ApiOperation(value = "여행 계획 쓰기", notes = "입력을 바탕으로 여행 계획을 작성한다", response = String.class)
	@PostMapping("/write")
	public ResponseEntity<?> planWrite(@RequestBody @ApiParam(value = "여행 계획 입력", required = true) PlanDto planDto)
			throws Exception {
		logger.info("planWrite - 호출");

		int check = planService.writePlan(planDto);
		
		if (check != 0) {
			return new ResponseEntity<Integer>(check, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@ApiOperation(value = "여행 계획 삭제", notes = "현재 여행 계획을 삭제한다.", response = String.class)
	@DeleteMapping("/delete/{planNo}")
	public ResponseEntity<?> planDelete(
			@PathVariable("planNo") @ApiParam(value = "게시글 번호", required = true) int planNo) throws Exception {
		logger.info("planDelete - 호출");

		if (planService.deletePlan(planNo)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);

	}

	@ApiOperation(value = "여행 계획 수정", notes = "여행 계획을 수정한다.", response = String.class)
	@PutMapping("/modify")
	public ResponseEntity<?> planModify(
			@RequestBody @ApiParam(value = "수정할 여행 계획 정보", required = true) PlanDto planDto) throws Exception {
		logger.info("planModify - 호출 {}");

		if (planService.modifyPlan(planDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}

	
}
