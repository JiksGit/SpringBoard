package com.board.paging;

public class PaginationInfo {
	private Criteria criteria;
	private int totalRecordCount;
	private int totalPageCount;
	private int firstPage;
	private int lastPage;
	private int firstRecordIndex;
	private int lastRecordIndex;
	private boolean hasPreviousPage;
	private boolean hasNextPage;
	
	public PaginationInfo(Criteria criteria) {
		if (criteria.getCurrentPageNo() < 1) {
			criteria.setCurrentPageNo(1);
		}
		if(criteria.getRecordsPerPage() < 1 || criteria.getRecordsPerPage() > 100) {
			criteria.setRecordsPerPage(10);
		}
		if(criteria.getPageSize() < 5 || criteria.getPageSize() > 20) {
			criteria.setPageSize(10);
		}
		this.criteria = criteria;
	}
	
	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
		if(totalRecordCount > 0) {
			calculation();
		}
	}

	private void calculation() {
		// TODO Auto-generated method stub
		totalPageCount = ((totalRecordCount - 1) / criteria.getRecordsPerPage()) + 1;
		if(criteria.getCurrentPageNo() > totalPageCount) {
			criteria.setCurrentPageNo(totalPageCount);
		}
		
		firstPage = ((criteria.getCurrentPageNo() - 1) / criteria.getPageSize()) * criteria.getPageSize() + 1;
		
		lastPage = firstPage + criteria.getPageSize() - 1;
		if ( lastPage > totalPageCount ) {
			lastPage = totalPageCount;
		}
		
		firstRecordIndex = (criteria.getCurrentPageNo() - 1) * criteria.getRecordsPerPage();
		lastRecordIndex = criteria.getCurrentPageNo() * criteria.getRecordsPerPage();
		
		hasPreviousPage = firstPage != 1;
		hasNextPage = (lastPage * criteria.getRecordsPerPage()) < totalRecordCount;
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getFirstRecordIndex() {
		return firstRecordIndex;
	}

	public void setFirstRecordIndex(int firstRecordIndex) {
		this.firstRecordIndex = firstRecordIndex;
	}

	public int getLastRecordIndex() {
		return lastRecordIndex;
	}

	public void setLastRecordIndex(int lastRecordIndex) {
		this.lastRecordIndex = lastRecordIndex;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}
}
