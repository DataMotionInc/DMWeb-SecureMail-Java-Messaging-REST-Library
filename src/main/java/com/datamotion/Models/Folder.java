package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Folder Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class Folder {
	/**
	 * Unique folder identifier	
	 */
	@JsonProperty ("FolderId") @Getter @Setter
	private int FolderId;
	
	/**
	 * Name description of the folder	
	 */
	@JsonProperty ("FolderName") @Getter @Setter
	private String FolderName;
	
	/**
	 * Type of folder: either 0(Inbox) or 1 (Outbox)	
	 */
	@JsonProperty("FolderType") @Getter @Setter
	private int FolderType;
	
	/**
	 * FolderType represented as a String description	
	 */
	@JsonProperty("FolderTypeDescription") @Getter @Setter
	private String FolderTypeDescription;
	
	/**
	 * Indicates whether folder is system folder or user-defined folder	
	 */
	@JsonProperty("IsSystemFolder") @Getter @Setter
	private boolean IsSystemFolder;
	
	/**
	 * Total messages contained in folder	
	 */
	@JsonProperty("TotalMessages") @Getter @Setter
	private int TotalMessages;
	
	/**
	 * Total size (bytes) of messages contained in folder	
	 */
	@JsonProperty("TotalSize") @Getter @Setter
	private int TotalSize;
}
