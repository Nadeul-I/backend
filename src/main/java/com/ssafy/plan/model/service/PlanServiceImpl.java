package com.ssafy.plan.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.plan.model.PlanDto;
import com.ssafy.util.PageNavigation;

@Service
public class PlanServiceImpl implements PlanService {

	@Override
	public int writePlan(PlanDto planDto) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PlanDto> listPlan(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageNavigation makePageNavigation(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PlanDto getPlan(int planNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modifyPlan(PlanDto planDto) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePlan(int planNo) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
