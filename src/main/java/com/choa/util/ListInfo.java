package com.choa.util;

public class ListInfo {
	private int startRow;
	private int lastRow;
	
	private Integer curPage;
	private Integer perPage;
	private String search;
	private String find;
	
	//page
	private int curBlock;
	private int totalBlock;
	private int startNum;
	private int lastNum;
	

	//page
	public void makePage(int totalCount){
		//1. totalPage
		int totalPage = 0;
		int perBlock =5;
		if(totalCount%this.getPerPage() ==0){
			totalPage = totalCount/this.getPerPage();
		}else{
			totalPage = totalCount/this.getPerPage()+1;
		}
		//2. totalBlock
		if(totalPage%perBlock==0){
			totalBlock = totalPage/perBlock;
		}else{
			totalBlock=totalPage/perBlock +1;
		}
		//3. curBlock
		if(this.getCurPage()%perBlock==0){
			this.curBlock = this.getCurPage()/perBlock;
		}else{
			this.curBlock = this.getCurPage()/perBlock+1;
		}
		//4. startNum, lastNum
		this.startNum = (curBlock-1)*perBlock +1;
		this.lastNum = curBlock * perBlock;
		if(curBlock == totalBlock){
			this.lastNum = totalPage;
		}
		
	}
	
	//makeRow
	public void setRow(){
		startRow= (this.getCurPage()-1)*this.getPerPage()+1;
		lastRow = this.getCurPage()*this.getPerPage();
	}
	public int getStartRow() {
		return startRow;
	}
	public int getLastRow() {
		return lastRow;
	}
	public Integer getPerPage() {
		if(this.perPage==null){
			this.perPage=10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public Integer getCurPage() {
		if(this.curPage==null){
			this.curPage=1;
		}
		return curPage;
	}
	public void setCurPage(Integer curPage) {

		this.curPage = curPage;
		
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getFind() {
		return find;
	}
	public void setFind(String find) {
		this.find = find;
	}
	public int getCurBlock() {
		return curBlock;
	}
	
	public int getTotalBlock() {
		return totalBlock;
	}
	
	public int getStartNum() {
		return startNum;
	}
	
	public int getLastNum() {
		return lastNum;
	}
}
