package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Search Model Class
 */
public class Search {
	/**
	 * The search criteria	
	 */
	@JsonProperty("Filter")
	private String Filter;
	
	/**
	 * Unique ID of the Inbox folder to search (default Inbox Folder ID = 1)	
	 */
	@JsonProperty("FolderId")
	private int FolderId;
	
	/**
	 * Setting this to true will only return unread messages (Default is false)	
	 */
	@JsonProperty("GetInboxUnReadOnly")
	private boolean GetInboxUnReadOnly;
	
	/**
	 * Setting this to true will search retracted messages as well (Default is false)	
	 */
	@JsonProperty("GetRetractedMsgs")
	private boolean GetRetractedMsgs;
	
	/**
	 * Field by which to sort the result set	
	 */
	@JsonProperty("OrderBy")
	private String OrderBy;
	
	/**
	 * Order descending (Default is false)	
	 */
	@JsonProperty("OrderDesc")
	private boolean OrderDesc;
	
	/**
	 * Page number to return	
	 */
	@JsonProperty("PageNum")
	private int PageNum;
	
	/**
	 * Number of records returned per page	
	 */
	@JsonProperty("PageSize")
	private int PageSize;

	@JsonIgnore
	public Search() {
		Filter = null;
		FolderId = 0;
		GetInboxUnReadOnly = false;
		GetRetractedMsgs = false;
		OrderBy = null;
		OrderDesc = false;
		PageNum = 0;
		PageSize = 0;
	}

	@JsonIgnore
	public Search(String filter, int folderId, boolean getInboxUnReadOnly, boolean getRetractedMsgs, String orderBy,
			boolean orderDesc, int pageNum, int pageSize) {
		Filter = filter;
		FolderId = folderId;
		GetInboxUnReadOnly = getInboxUnReadOnly;
		GetRetractedMsgs = getRetractedMsgs;
		OrderBy = orderBy;
		OrderDesc = orderDesc;
		PageNum = pageNum;
		PageSize = pageSize;
	}

	@JsonIgnore
	public String getFilter() {
		return Filter;
	}

	@JsonIgnore
	public void setFilter(String filter) {
		Filter = filter;
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
	public boolean isGetInboxUnReadOnly() {
		return GetInboxUnReadOnly;
	}

	@JsonIgnore
	public void setGetInboxUnReadOnly(boolean getInboxUnReadOnly) {
		GetInboxUnReadOnly = getInboxUnReadOnly;
	}

	@JsonIgnore
	public boolean isGetRetractedMsgs() {
		return GetRetractedMsgs;
	}

	@JsonIgnore
	public void setGetRetractedMsgs(boolean getRetractedMsgs) {
		GetRetractedMsgs = getRetractedMsgs;
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
	public boolean isOrderDesc() {
		return OrderDesc;
	}

	@JsonIgnore
	public void setOrderDesc(boolean orderDesc) {
		OrderDesc = orderDesc;
	}

	@JsonIgnore
	public int getPageNum() {
		return PageNum;
	}

	@JsonIgnore
	public void setPageNum(int pageNum) {
		PageNum = pageNum;
	}

	@JsonIgnore
	public int getPageSize() {
		return PageSize;
	}

	@JsonIgnore
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}
}
