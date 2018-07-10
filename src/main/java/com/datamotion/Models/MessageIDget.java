package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Get Message IDs Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MessageIDget {
	/**
	 * The folder ID to search in (must be an inbox folderID). 1 is the primary inbox folder and is the default. -1 represents all inbox folders.	
	 */
	@JsonProperty("FolderID") @Getter @Setter
	private int FolderID;
	
	/**
	 * A search parameter. 0(All), 1(Unread), 2(CmLft). 0 is the default.	
	 */
	@JsonProperty("MessageListFilter") @Getter @Setter
	private int MessageListFilter;
	
	/**
	 * A search parameter. If set to true, only messages with attachments will be returned	
	 */
	@JsonProperty("MustHaveAttachments") @Getter @Setter
	private boolean MustHaveAttachments;	
}
