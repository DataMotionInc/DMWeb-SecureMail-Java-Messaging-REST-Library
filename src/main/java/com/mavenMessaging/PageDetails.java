package com.mavenMessaging;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class PageDetails {
	@JsonProperty("CurrentPage") @Getter @Setter
	private int CurrentPage;
	
	@JsonProperty("FolderId") @Getter @Setter
	private int FolderId;
	
	@JsonProperty("OrderBy") @Getter @Setter
	private String OrderBy;
	
	@JsonProperty("PageSize") @Getter @Setter
	private int PageSize;
	
	@JsonProperty("TotalMessages") @Getter @Setter
	private int TotalMessages;
	
	@JsonProperty("TotalPages") @Getter @Setter
	private int TotalPages;
}
