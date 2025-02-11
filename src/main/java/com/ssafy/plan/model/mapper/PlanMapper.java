package com.ssafy.plan.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.plan.model.PlanDto;

@Mapper
public interface PlanMapper {
	int writePlan(PlanDto planDto) throws SQLException;

	List<PlanDto> listPlan(PlanDto planDto) throws SQLException;
	
	int getTotalPlanCount(String planId) throws SQLException;
	
	PlanDto getPlan(int planNo) throws SQLException;
	
	boolean modifyPlan(PlanDto planDto) throws SQLException;
	
	boolean deletePlan(int planNo) throws SQLException;
}
