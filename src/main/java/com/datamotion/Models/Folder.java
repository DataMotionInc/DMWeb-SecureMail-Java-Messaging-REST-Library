package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Folder Model Class
 */

public class Folder {
	/**
	 * Unique folder identifier	
	 */
	@JsonProperty ("FolderId")
	private int FolderId;
	
	/**
	 * Name description of the folder	
	 */
	@JsonProperty ("FolderName")
	private String FolderName;
	
	/**
	 * Type of folder: either 0(Inbox) or 1 (Outbox)	
	 */
	@JsonProperty("FolderType")
	private int FolderType;
	
	/**
	 * FolderType represented as a String description	
	 */
	@JsonProperty("FolderTypeDescription")
	private String FolderTypeDescription;
	
	/**
	 * Indicates whether folder is system folder or user-defined folder	
	 */
	@JsonProperty("IsSystemFolder")
	private boolean IsSystemFolder;
	
	/**
	 * Total messages contained in folder	
	 */
	@JsonProperty("TotalMessages")
	private int TotalMessages;
	
	/**
	 * Total size (bytes) of messages contained in folder	
	 */
	@JsonProperty("TotalSize")
	private int TotalSize;
	
	public Folder() {
		FolderId = 0;
		FolderName = null;
		FolderType = 0;
		FolderTypeDescription = null;
		IsSystemFolder = false;
		TotalMessages = 0;
		TotalSize = 0;
	}

	
	public Folder(int folderId, String folderName, int folderType, String folderTypeDescription, boolean isSystemFolder,
			int totalMessages, int totalSize) {
		FolderId = folderId;
		FolderName = folderName;
		FolderType = folderType;
		FolderTypeDescription = folderTypeDescription;
		IsSystemFolder = isSystemFolder;
		TotalMessages = totalMessages;
		TotalSize = totalSize;
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
	public String getFolderName() {
		return FolderName;
	}

	@JsonIgnore
	public void setFolderName(String folderName) {
		FolderName = folderName;
	}

	@JsonIgnore
	public int getFolderType() {
		return FolderType;
	}

	@JsonIgnore
	public void setFolderType(int folderType) {
		FolderType = folderType;
	}

	@JsonIgnore
	public String getFolderTypeDescription() {
		return FolderTypeDescription;
	}

	@JsonIgnore
	public void setFolderTypeDescription(String folderTypeDescription) {
		FolderTypeDescription = folderTypeDescription;
	}

	@JsonIgnore
	public boolean getIsSystemFolder() {
		return IsSystemFolder;
	}

	@JsonIgnore
	public void setIsSystemFolder(boolean isSystemFolder) {
		IsSystemFolder = isSystemFolder;
	}

	@JsonIgnore
	public int getTotalMessages() {
		return TotalMessages;
	}

	@JsonIgnore
	public void setTotalMessages(int totalMessages) {
		TotalMessages = totalMessages;
	}

	@JsonIgnore
	public int getTotalSize() {
		return TotalSize;
	}

	@JsonIgnore
	public void setTotalSize(int totalSize) {
		TotalSize = totalSize;
	}
}
