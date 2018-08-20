package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Search Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class Search {
	/**
	 * The search criteria	
	 */
	@JsonProperty("Filter") //@Getter @Setter
	private String Filter;
	
	/**
	 * Unique ID of the Inbox folder to search (default Inbox Folder ID = 1)	
	 */
	@JsonProperty("FolderId") //@Getter @Setter
	private int FolderId;
	
	/**
	 * Setting this to true will only return unread messages (Default is false)	
	 */
	@JsonProperty("GetInboxUnReadOnly") //@Getter @Setter
	private boolean GetInboxUnReadOnly;
	
	/**
	 * Setting this to true will search retracted messages as well (Default is false)	
	 */
	@JsonProperty("GetRetractedMsgs") //@Getter @Setter
	private boolean GetRetractedMsgs;
	
	/**
	 * Field by which to sort the result set	
	 */
	@JsonProperty("OrderBy") //@Getter @Setter
	private String OrderBy;
	
	/**
	 * Order descending (Default is false)	
	 */
	@JsonProperty("OrderDesc") //@Getter @Setter
	private boolean OrderDesc;
	
	/**
	 * Page number to return	
	 */
	@JsonProperty("PageNum") //@Getter @Setter
	private int PageNum;
	
	/**
	 * Number of records returned per page	
	 */
	@JsonProperty("PageSize") //@Getter @Setter
	private int PageSize;
}
