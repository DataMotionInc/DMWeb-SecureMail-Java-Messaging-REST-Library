package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMessageSummariesWithMetadata {
	@JsonProperty("FolderId")
	private int FolderId;
	
	@JsonProperty("LastMessageIdReceived")
	private int LastMessageIdReceived;

	public GetMessageSummariesWithMetadata() {
		// TODO Auto-generated constructor stub
	}

	public GetMessageSummariesWithMetadata(int folderId, int lastMessageIdReceived) {
		FolderId = folderId;
		LastMessageIdReceived = lastMessageIdReceived;
	}

	public int getFolderId() {
		return FolderId;
	}

	public void setFolderId(int folderId) {
		FolderId = folderId;
	}

	public int getLastMessageIdReceived() {
		return LastMessageIdReceived;
	}

	public void setLastMessageIdReceived(int lastMessageIdReceived) {
		LastMessageIdReceived = lastMessageIdReceived;
	}
}
