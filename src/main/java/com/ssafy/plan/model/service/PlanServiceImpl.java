package com.ssafy.plan.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.plan.model.PlanDto;
import com.ssafy.plan.model.mapper.PlanMapper;
import com.ssafy.util.NavigationSize;
import com.ssafy.util.PageNavigation;

@Service
public class PlanServiceImpl implements PlanService {

	PlanMapper planMapper;
	
	public PlanServiceImpl(PlanMapper planMapper) {
		super();
		this.planMapper = planMapper;
	}
	
	@Override
	public int writePlan(PlanDto planDto) throws Exception {
		return planMapper.writePlan(planDto);
	}

	@Override //String userId, int pgno
	public List<PlanDto> listPlan(PlanDto planDto) throws Exception {
		return planMapper.listPlan(planDto);
	}

	@Override
	public PageNavigation makePageNavigation(String userId, int pgno) throws Exception {
		PageNavigation pageNavigation = new PageNavigation();

		int naviSize = NavigationSize.naviSize;
		int listSize = NavigationSize.listSize;
		int currentPage = pgno;

		pageNavigation.setCurrentPage(currentPage);
		
		// 총 글 개수
		int totalCount = planMapper.getTotalPlanCount(userId);

		// 시작 글
		int start = (currentPage - 1) * listSize;
		pageNavigation.setStart(start);
		
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
	public PlanDto getPlan(int planNo) throws Exception {
		return planMapper.getPlan(planNo);
	}

	@Override
	public boolean modifyPlan(PlanDto planDto) throws Exception {
		return planMapper.modifyPlan(planDto);
	}

	@Override
	public boolean deletePlan(int planNo) throws Exception {
		return planMapper.deletePlan(planNo);
	}

}
