package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Delete Message Response Class
 */
	public class DeleteMessageResponse {
	/**
	 * New trash folder's ID
	 */
	@JsonProperty("NewFolderId")
	private int NewFolderId;
	
	/**
	 * Message regarding delete request results
	 */
	@JsonProperty("Result")
	private String Result;

	@JsonIgnore
	public DeleteMessageResponse() {
		NewFolderId = 0;
		Result = null;

	}

	@JsonIgnore
	public DeleteMessageResponse(int newFolderId, String result) {
		NewFolderId = newFolderId;
		Result = result;
	}

	@JsonIgnore
	public int getNewFolderId() {
		return NewFolderId;
	}

	@JsonIgnore
	public void setNewFolderId(int newFolderId) {
		NewFolderId = newFolderId;
	}

	@JsonIgnore
	public String getResult() {
		return Result;
	}

	@JsonIgnore
	public void setResult(String result) {
		Result = result;
	}
}
