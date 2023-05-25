package com.ssafy.plan.model.service;

import java.util.List;

import com.ssafy.plan.model.PlanDto;
import com.ssafy.util.PageNavigation;

public interface PlanService {
	int writePlan(PlanDto planDto) throws Exception;

	List<PlanDto> listPlan(String userId, int pgno) throws Exception;

	PageNavigation makePageNavigation(String userId, int pgno) throws Exception;

	PlanDto getPlan(int planNo) throws Exception;

	boolean modifyPlan(PlanDto planDto) throws Exception;

	boolean deletePlan(int planNo) throws Exception;
}
