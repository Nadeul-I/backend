package com.ssafy.board.model;

import com.ssafy.util.NavigationSize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "게시판 검색 정보", description = "게시판 검색, 페이지 등등..")
public class BoardSearchDto {

	@ApiModelProperty(value = "검색 분류")
	private String search;
	@ApiModelProperty(value = "검색 단어")
	private String word;
	@ApiModelProperty(value = "현재 페이지 번호")
	private int pgno;
	@ApiModelProperty(value = "시작 번호")
	private int start;
	@ApiModelProperty(value = "글 개수")
	private int listSize;

	public BoardSearchDto() {
		listSize = NavigationSize.listSize;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
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

}
