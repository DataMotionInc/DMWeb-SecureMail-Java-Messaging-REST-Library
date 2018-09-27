package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Move Message Model Class
 */
public class MoveMessage {
	/**
	 * The destination folder's unique identifier	
	 */
	@JsonProperty("DestinationFolderId") 
	private int DestinationFolderId;

	@JsonIgnore
	public MoveMessage() {
		DestinationFolderId = 0;
	}

	@JsonIgnore
	public MoveMessage(int destinationFolderId) {
		DestinationFolderId = destinationFolderId;
	}

	@JsonIgnore
	public int getDestinationFolderId() {
		return DestinationFolderId;
	}

	@JsonIgnore
	public void setDestinationFolderId(int destinationFolderId) {
		DestinationFolderId = destinationFolderId;
	}
}
