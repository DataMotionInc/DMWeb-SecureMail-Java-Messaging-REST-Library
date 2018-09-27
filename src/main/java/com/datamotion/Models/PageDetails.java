package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Page Details Model Class
 */
public class PageDetails {
	/**
	 * The current page number of all records returned	
	 */
	@JsonProperty("CurrentPage") 
	private int CurrentPage;
	
	/**
	 * Unique identifier of folder being searched	
	 */
	@JsonProperty("FolderId") 
	private int FolderId;
	
	/**
	 * Sort column applied to the dataset	
	 */
	@JsonProperty("OrderBy") 
	private String OrderBy;
	
	/**
	 * Number of records returned per page	
	 */
	@JsonProperty("PageSize") 
	private int PageSize;
	
	/**
	 * Total number of records found	
	 */
	@JsonProperty("TotalMessages") 
	private int TotalMessages;
	
	/**
	 * Total number of pages defined by PageSize	
	 */
	@JsonProperty("TotalPages") 
	private int TotalPages;

	@JsonIgnore
	public PageDetails() {
		CurrentPage = 0;
		FolderId = 0;
		OrderBy = null;
		PageSize = 0;
		TotalMessages = 0;
		TotalPages = 0;
	}

	@JsonIgnore
	public PageDetails(int currentPage, int folderId, String orderBy, int pageSize, int totalMessages, int totalPages) {
		CurrentPage = currentPage;
		FolderId = folderId;
		OrderBy = orderBy;
		PageSize = pageSize;
		TotalMessages = totalMessages;
		TotalPages = totalPages;
	}

	@JsonIgnore
	public int getCurrentPage() {
		return CurrentPage;
	}

	@JsonIgnore
	public void setCurrentPage(int currentPage) {
		CurrentPage = currentPage;
	}

	@JsonIgnore
	public int getFolderId() {
		return FolderId;
	}

	@JsonIgnore
	public void setFolderId(int folderId) {
		FolderId = folderId;
	}

	@JsonIgnore
	public String getOrderBy() {
		return OrderBy;
	}

	@JsonIgnore
	public void setOrderBy(String orderBy) {
		OrderBy = orderBy;
	}

	@JsonIgnore
	public int getPageSize() {
		return PageSize;
	}

	@JsonIgnore
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

	@JsonIgnore
	public int getTotalMessages() {
		return TotalMessages;
	}

	@JsonIgnore
	public void setTotalMessages(int totalMessages) {
		TotalMessages = totalMessages;
	}

	@JsonIgnore
	public int getTotalPages() {
		return TotalPages;
	}

	@JsonIgnore
	public void setTotalPages(int totalPages) {
		TotalPages = totalPages;
	}
}
