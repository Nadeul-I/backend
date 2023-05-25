package com.ssafy.plan.model;

import com.ssafy.util.NavigationSize;

public class PlanDto {
	int planNo; // 여행 계획 번호
	String planTitle; // 여행 계획 이름
	int pgno; // 있었던 페이지
	int start; // 리스트 시작
	int listSize; // 리스트 크기
	String planId; // 여행 계획 쓴이
	String planImg; // 여행 계획 이미지
	int planStart; // 여행 계획 시작점
	int planEnd; // 여행 계획 끝점

	public PlanDto() {
		super();
		listSize = NavigationSize.listSize;
	}

	public int getPlanNo() {
		return planNo;
	}

	public void setPlanNo(int planNo) {
		this.planNo = planNo;
	}

	public String getPlanTitle() {
		return planTitle;
	}

	public void setPlanTitle(String planTitle) {
		this.planTitle = planTitle;
	}

	public int getPgno() {
		return pgno;
	}

	public void setPgno(int pgno) {
		this.pgno = pgno;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getPlanImg() {
		return planImg;
	}

	public void setPlanImg(String planImg) {
		this.planImg = planImg;
	}

	public int getPlanStart() {
		return planStart;
	}

	public void setPlanStart(int planStart) {
		this.planStart = planStart;
	}

	public int getPlanEnd() {
		return planEnd;
	}

	public void setPlanEnd(int planEnd) {
		this.planEnd = planEnd;
	}

	
}
