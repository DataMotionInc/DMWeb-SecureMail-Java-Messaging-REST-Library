package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Page Details Model Class
 */
@NoArgsConstructor
@AllArgsConstructor
public class PageDetails {
	/**
	 * The current page number of all records returned	
	 */
	@JsonProperty("CurrentPage") @Getter @Setter
	private int CurrentPage;
	
	/**
	 * Unique identifier of folder being searched	
	 */
	@JsonProperty("FolderId") @Getter @Setter
	private int FolderId;
	
	/**
	 * Sort column applied to the dataset	
	 */
	@JsonProperty("OrderBy") @Getter @Setter
	private String OrderBy;
	
	/**
	 * Number of records returned per page	
	 */
	@JsonProperty("PageSize") @Getter @Setter
	private int PageSize;
	
	/**
	 * Total number of records found	
	 */
	@JsonProperty("TotalMessages") @Getter @Setter
	private int TotalMessages;
	
	/**
	 * Total number of pages defined by PageSize	
	 */
	@JsonProperty("TotalPages") @Getter @Setter
	private int TotalPages;
}
