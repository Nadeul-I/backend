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
	String planStartTitle;
	double planStartLat;
	double planStartLng;
	int planStart; // 여행 계획 시작점
	String planEndTitle;
	double planEndLat;
	double planEndLng;
	int planEnd; // 여행 계획 끝점

	public PlanDto() {
		super();
		listSize = NavigationSize.cardSize;
	}

	public String getPlanStartTitle() {
		return planStartTitle;
	}

	public void setPlanStartTitle(String planStartTitle) {
		this.planStartTitle = planStartTitle;
	}

	public double getPlanStartLat() {
		return planStartLat;
	}

	public void setPlanStartLat(double planStartLat) {
		this.planStartLat = planStartLat;
	}

	public double getPlanStartLng() {
		return planStartLng;
	}

	public void setPlanStartLng(double planStartLng) {
		this.planStartLng = planStartLng;
	}

	public String getPlanEndTitle() {
		return planEndTitle;
	}

	public void setPlanEndTitle(String planEndTitle) {
		this.planEndTitle = planEndTitle;
	}

	public double getPlanEndLat() {
		return planEndLat;
	}

	public void setPlanEndLat(double planEndLat) {
		this.planEndLat = planEndLat;
	}

	public double getPlanEndLng() {
		return planEndLng;
	}

	public void setPlanEndLng(double planEndLng) {
		this.planEndLng = planEndLng;
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
