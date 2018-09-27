package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Tracking Model Class
 */
public class Tracking {
	/**
	 * The date/time string that the message was opened. Note: If year = 1900, then there is no DateOpened associated with the current message status.	
	 */
	@JsonProperty("DateOpened") 
	private String DateOpened;
	
	/**
	 * The email address of the recipient	
	 */
	@JsonProperty("Email") 
	private String Email;
	
	/**
	 * Status represented as string description	
	 */
	@JsonProperty("MessageStatusDescription") 
	private String MessageStatusDescription;
	
	/**
	 * Numeric indicator of the status of the individual recipient	
	 */
	@JsonProperty("MessageStatusId") 
	private int MessageStatusId;
	
	/**
	 * Indicates whether this recipient was the TO, CC, or BCC of the message	
	 */
	@JsonProperty("ReceiverField") 
	private String ReceiverField;

	@JsonIgnore
	public Tracking() {
		DateOpened = null;
		Email = null;
		MessageStatusDescription = null;
		MessageStatusId = 0;
		ReceiverField = null;
	}

	@JsonIgnore
	public Tracking(String dateOpened, String email, String messageStatusDescription, int messageStatusId,
			String receiverField) {
		DateOpened = dateOpened;
		Email = email;
		MessageStatusDescription = messageStatusDescription;
		MessageStatusId = messageStatusId;
		ReceiverField = receiverField;
	}

	@JsonIgnore
	public String getDateOpened() {
		return DateOpened;
	}

	@JsonIgnore
	public void setDateOpened(String dateOpened) {
		DateOpened = dateOpened;
	}

	@JsonIgnore
	public String getEmail() {
		return Email;
	}

	@JsonIgnore
	public void setEmail(String email) {
		Email = email;
	}

	@JsonIgnore
	public String getMessageStatusDescription() {
		return MessageStatusDescription;
	}

	@JsonIgnore
	public void setMessageStatusDescription(String messageStatusDescription) {
		MessageStatusDescription = messageStatusDescription;
	}

	@JsonIgnore
	public int getMessageStatusId() {
		return MessageStatusId;
	}

	@JsonIgnore
	public void setMessageStatusId(int messageStatusId) {
		MessageStatusId = messageStatusId;
	}

	@JsonIgnore
	public String getReceiverField() {
		return ReceiverField;
	}

	@JsonIgnore
	public void setReceiverField(String receiverField) {
		ReceiverField = receiverField;
	}
}
