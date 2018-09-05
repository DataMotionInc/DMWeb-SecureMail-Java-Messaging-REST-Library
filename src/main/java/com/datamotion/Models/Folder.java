package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty ("FolderId")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int FolderId;
	
	/**
	 * Name description of the folder	
	 */
	@JsonProperty ("FolderName")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String FolderName;
	
	/**
	 * Type of folder: either 0(Inbox) or 1 (Outbox)	
	 */
	@JsonProperty("FolderType")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int FolderType;
	
	/**
	 * FolderType represented as a String description	
	 */
	@JsonProperty("FolderTypeDescription")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String FolderTypeDescription;
	
	/**
	 * Indicates whether folder is system folder or user-defined folder	
	 */
	@JsonProperty("IsSystemFolder")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private boolean IsSystemFolder;
	
	/**
	 * Total messages contained in folder	
	 */
	@JsonProperty("TotalMessages")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalMessages;
	
	/**
	 * Total size (bytes) of messages contained in folder	
	 */
	@JsonProperty("TotalSize")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalSize;

	@Override
	public String toString() {
		return "\nFolder [\nFolderId=" + FolderId + "\nFolderName=" + FolderName + "\nFolderType=" + FolderType
				+ "\nFolderTypeDescription=" + FolderTypeDescription + "\nIsSystemFolder=" + IsSystemFolder
				+ "\nTotalMessages=" + TotalMessages + "\nTotalSize=" + TotalSize + "]";
	}
}
