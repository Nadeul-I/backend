package com.ssafy.region.model;

public class SearchDto {

	private int sido;
	private int gugun;
	private int cat;
	private String keyword;
	
	public SearchDto() {
		super();
	}
	public SearchDto(int sido, int gugun, int cat, String keyword) {
		super();
		this.sido = sido;
		this.gugun = gugun;
		this.cat = cat;
		this.keyword = keyword;
	}
	public int getSido() {
		return sido;
	}
	public void setSido(int sido) {
		this.sido = sido;
	}
	public int getGugun() {
		return gugun;
	}
	public void setGugun(int gugun) {
		this.gugun = gugun;
	}
	public int getCat() {
		return cat;
	}
	public void setCat(int cat) {
		this.cat = cat;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	

}
