package com.datamotion.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * New Folder Id model class
 */
public class NewFolderId {
	/**
	 * The unique ID of the newly created folder	
	 */
	@JsonProperty("FolderId") 
	private int FolderId;

	public NewFolderId() {
		FolderId = 0;
	}

	public NewFolderId(int folderId) {
		FolderId = folderId;
	}

	@JsonIgnore
	public int getFolderId() {
		return FolderId;
	}

	@JsonIgnore
	public void setFolderId(int folderId) {
		FolderId = folderId;
	}
}
