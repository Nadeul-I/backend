package com.ssafy.util;

public class PageNavigation {

	private int naviSize; // 페이지 사이즈
	private int listSize; // 글 개수
	private int currentPage; // 현재 페이지 번호
	private int totalPageCount; // 총 페이지 개수
	private boolean startRange; // 이전 버튼 활성화 여부
	private boolean endRange; // 다음 버튼 활성화 여부
	private int startPage; // 시작 페이지
	private int endPage; // 끝나는 페이지
	private int start; // 시작 번호

	public PageNavigation() {
		naviSize = NavigationSize.naviSize;
		listSize = NavigationSize.listSize;
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

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public boolean isStartRange() {
		return startRange;
	}

	public void setStartRange(boolean startRange) {
		this.startRange = startRange;
	}

	public boolean isEndRange() {
		return endRange;
	}

	public void setEndRange(boolean endRange) {
		this.endRange = endRange;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

}
