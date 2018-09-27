package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Get Message IDs Model Class
 */
public class MessageIdGet {
	/**
	 * The folder ID to search in (must be an inbox folderID). 1 is the primary inbox folder and is the default. -1 represents all inbox folders.	
	 */
	@JsonProperty("FolderID") 
	private int FolderID;
	
	/**
	 * A search parameter. 0(All), 1(Unread), 2(CmLft). 0 is the default.	
	 */
	@JsonProperty("MessageListFilter") 
	private int MessageListFilter;
	
	/**
	 * A search parameter. If set to true, only messages with attachments will be returned	
	 */
	@JsonProperty("MustHaveAttachments") 
	private boolean MustHaveAttachments;

	@JsonIgnore
	public MessageIdGet() {
		FolderID = 0;
		MessageListFilter = 0;
		MustHaveAttachments = false;
	}

	@JsonIgnore
	public MessageIdGet(int folderID, int messageListFilter, boolean mustHaveAttachments) {
		FolderID = folderID;
		MessageListFilter = messageListFilter;
		MustHaveAttachments = mustHaveAttachments;
	}

	@JsonIgnore
	public int getFolderID() {
		return FolderID;
	}

	@JsonIgnore
	public void setFolderID(int folderID) {
		FolderID = folderID;
	}

	@JsonIgnore
	public int getMessageListFilter() {
		return MessageListFilter;
	}

	@JsonIgnore
	public void setMessageListFilter(int messageListFilter) {
		MessageListFilter = messageListFilter;
	}

	@JsonIgnore
	public boolean isMustHaveAttachments() {
		return MustHaveAttachments;
	}

	@JsonIgnore
	public void setMustHaveAttachments(boolean mustHaveAttachments) {
		MustHaveAttachments = mustHaveAttachments;
	}	
}
