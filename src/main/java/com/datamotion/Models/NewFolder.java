package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * New Folder Model Class
 */
public class NewFolder {
	/**
	 * The name of the folder	
	 */
	@JsonProperty("FolderName") 
	private String FolderName;
	
	/**
	 * The integer type of folder. Default is 0.	
	 */
	@JsonProperty("FolderType") 
	private int FolderType;

	@JsonIgnore
	public NewFolder() {
		FolderName = null;
		FolderType = 0;
	}

	@JsonIgnore
	public NewFolder(String folderName, int folderType) {
		FolderName = folderName;
		FolderType = folderType;
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
}
