package com.datamotion.Models;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Get Message Summaries Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MessageSummariesGet {
	/**
	 * The ID of the Inbox folder to search (default Inbox Folder ID = 1)	
	 */
	@JsonProperty ("FolderId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int FolderId;
	
	/**
	 * The last known message ID received. If included, this method will only return messages received after this message ID.	
	 */
	@JsonProperty("LastMessageIDReceived") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int LastMessageIDReceived;	
}
