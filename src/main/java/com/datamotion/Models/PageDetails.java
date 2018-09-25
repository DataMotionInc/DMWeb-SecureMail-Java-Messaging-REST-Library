package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty("CurrentPage") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int CurrentPage;
	
	/**
	 * Unique identifier of folder being searched	
	 */
	@JsonProperty("FolderId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int FolderId;
	
	/**
	 * Sort column applied to the dataset	
	 */
	@JsonProperty("OrderBy") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String OrderBy;
	
	/**
	 * Number of records returned per page	
	 */
	@JsonProperty("PageSize") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int PageSize;
	
	/**
	 * Total number of records found	
	 */
	@JsonProperty("TotalMessages") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalMessages;
	
	/**
	 * Total number of pages defined by PageSize	
	 */
	@JsonProperty("TotalPages") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalPages;
}
