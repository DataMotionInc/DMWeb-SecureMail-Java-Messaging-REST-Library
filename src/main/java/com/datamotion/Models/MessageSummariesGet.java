package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Get Message Summaries Model Class
 */
public class MessageSummariesGet {
	/**
	 * The ID of the Inbox folder to search (default Inbox Folder ID = 1)	
	 */
	@JsonProperty ("FolderId") 
	private int FolderId;
	
	/**
	 * The last known message ID received. If included, this method will only return messages received after this message ID.	
	 */
	@JsonProperty("LastMessageIDReceived") 
	private int LastMessageIDReceived;

	
	public MessageSummariesGet() {
		FolderId = 0;
		LastMessageIDReceived = 0;
	}

	
	public MessageSummariesGet(int folderId, int lastMessageIDReceived) {
		FolderId = folderId;
		LastMessageIDReceived = lastMessageIDReceived;
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
	public int getLastMessageIDReceived() {
		return LastMessageIDReceived;
	}

	@JsonIgnore
	public void setLastMessageIDReceived(int lastMessageIDReceived) {
		LastMessageIDReceived = lastMessageIDReceived;
	}	
}
