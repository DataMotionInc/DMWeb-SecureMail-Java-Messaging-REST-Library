package com.datamotion.Models;

import lombok.AllArgsConstructor;
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
	@JsonProperty ("FolderId") @Getter @Setter
	private int FolderId;
	
	/**
	 * The last known message ID received. If included, this method will only return messages received after this message ID.	
	 */
	@JsonProperty("LastMessageIDReceived") @Getter @Setter
	private int LastMessageIDReceived;	
}
