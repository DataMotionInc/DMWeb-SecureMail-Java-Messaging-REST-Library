package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Results Model Class
 */
public class Results {
	/**
	 * Date/time the message was created	
	 */
	@JsonProperty("CreateTime") 
	private String CreateTime;
	
	/**
	 * Last action taken by user. (0) None, (1) Replied, (2) Forwarded	
	 */
	@JsonProperty ("LastAction") 
	private int LastAction;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") 
	private int MessageId;
	
	/**
	 * Total size (bytes) of messages contained in folder	
	 */
	@JsonProperty("MessageSize") 
	private int MessageSize;
	
	/**
	 * Numeric indicator of the status of the message	
	 */
	@JsonProperty("MessageStatusId") 
	private int MessageStatusId;
	
	/**
	 * Hint in the form of a question that the recipient has to answer in order to access the message	
	 */
	@JsonProperty("PasswordHint") 
	private String PasswordHint;
	
	/**
	 * True/False if message was opened	
	 */
	@JsonProperty("Read") 
	private boolean Read;
	
	/**
	 * Integer referring to status of message	
	 */
	@JsonProperty("MessageStatus") 
	private int MessageStatus;
	
	/**
	 * In a plain text delivery environment, this indicator forces the recipient to access the web interface to retrieve a message, so the sender receives absolute read confirmation and detailed tracking information	
	 */
	@JsonProperty("ReadConfirmation") 
	private boolean ReadConfirmation;
	
	/**
	 * Sender's email address	
	 */
	@JsonProperty("SenderEmail") 
	private String SenderEmail;
	
	/**
	 * Unique user identifier for the sender	
	 */
	@JsonProperty("SenderId") 
	private int SenderId;
	
	/**
	 * Subject line of the message	
	 */
	@JsonProperty("Subject") 
	private String Subject;

	@JsonIgnore
	public Results() {
		CreateTime = null;
		LastAction = 0;
		MessageId = 0;
		MessageSize = 0;
		MessageStatusId = 0;
		PasswordHint = null;
		Read = false;
		MessageStatus = 0;
		ReadConfirmation = false;
		SenderEmail = null;
		SenderId = 0;
		Subject = null;
	}

	@JsonIgnore
	public Results(String createTime, int lastAction, int messageId, int messageSize, int messageStatusId,
			String passwordHint, boolean read, int messageStatus, boolean readConfirmation, String senderEmail,
			int senderId, String subject) {
		CreateTime = createTime;
		LastAction = lastAction;
		MessageId = messageId;
		MessageSize = messageSize;
		MessageStatusId = messageStatusId;
		PasswordHint = passwordHint;
		Read = read;
		MessageStatus = messageStatus;
		ReadConfirmation = readConfirmation;
		SenderEmail = senderEmail;
		SenderId = senderId;
		Subject = subject;
	}

	@JsonIgnore
	public String getCreateTime() {
		return CreateTime;
	}

	@JsonIgnore
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	@JsonIgnore
	public int getLastAction() {
		return LastAction;
	}

	@JsonIgnore
	public void setLastAction(int lastAction) {
		LastAction = lastAction;
	}

	@JsonIgnore
	public int getMessageId() {
		return MessageId;
	}

	@JsonIgnore
	public void setMessageId(int messageId) {
		MessageId = messageId;
	}

	@JsonIgnore
	public int getMessageSize() {
		return MessageSize;
	}

	@JsonIgnore
	public void setMessageSize(int messageSize) {
		MessageSize = messageSize;
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
	public String getPasswordHint() {
		return PasswordHint;
	}

	@JsonIgnore
	public void setPasswordHint(String passwordHint) {
		PasswordHint = passwordHint;
	}

	@JsonIgnore
	public boolean isRead() {
		return Read;
	}

	@JsonIgnore
	public void setRead(boolean read) {
		Read = read;
	}

	@JsonIgnore
	public int getMessageStatus() {
		return MessageStatus;
	}

	@JsonIgnore
	public void setMessageStatus(int messageStatus) {
		MessageStatus = messageStatus;
	}

	@JsonIgnore
	public boolean isReadConfirmation() {
		return ReadConfirmation;
	}

	@JsonIgnore
	public void setReadConfirmation(boolean readConfirmation) {
		ReadConfirmation = readConfirmation;
	}

	@JsonIgnore
	public String getSenderEmail() {
		return SenderEmail;
	}

	@JsonIgnore
	public void setSenderEmail(String senderEmail) {
		SenderEmail = senderEmail;
	}

	@JsonIgnore
	public int getSenderId() {
		return SenderId;
	}

	@JsonIgnore
	public void setSenderId(int senderId) {
		SenderId = senderId;
	}

	@JsonIgnore
	public String getSubject() {
		return Subject;
	}

	@JsonIgnore
	public void setSubject(String subject) {
		Subject = subject;
	}
}
