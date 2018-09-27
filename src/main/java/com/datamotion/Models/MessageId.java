package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Message ID Model Class
 */
public class MessageId {
	/**
	 * The unique message identifier for the newly created message	
	 */
	@JsonProperty("MessageId") 
	private int MessageId;

	
	public MessageId() {
		MessageId = 0;
	}

	
	public MessageId(int messageId) {
		MessageId = messageId;
	}

	@JsonIgnore
	public int getMessageId() {
		return MessageId;
	}

	@JsonIgnore
	public void setMessageId(int messageId) {
		MessageId = messageId;
	}
}
