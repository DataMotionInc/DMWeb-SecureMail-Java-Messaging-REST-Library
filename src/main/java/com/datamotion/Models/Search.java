package com.datamotion;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Search {
	@JsonProperty("Filter") @Getter @Setter
	private String Filter;
	
	@JsonProperty("FolderId") @Getter @Setter
	private int FolderId;
	
	@JsonProperty("GetInboxUnReadOnly") @Getter @Setter
	private boolean GetInboxUnReadOnly;
	
	@JsonProperty("GetRetractedMsgs") @Getter @Setter
	private boolean GetRetractedMsgs;
	
	@JsonProperty("OrderBy") @Getter @Setter
	private String OrderBy;
	
	@JsonProperty("OrderDesc") @Getter @Setter
	private boolean OrderDesc;
	
	@JsonProperty("PageNum") @Getter @Setter
	private int PageNum;
	
	@JsonProperty("PageSize") @Getter @Setter
	private int PageSize;
}
