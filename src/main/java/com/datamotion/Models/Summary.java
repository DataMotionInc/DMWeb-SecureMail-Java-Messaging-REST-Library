package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Summary Model Class
 */
public class Summary {
	/**
	 * The number of attachments sent with the message	
	 */
	@JsonProperty("AttachmentCount") 
	private int AttachmentCount;
	
	/**
	 * Date/time the message was created	
	 */
	@JsonProperty("createTimeString") 
	private String createTimeString;
	
	/**
	 * Unique folder identifier	
	 */
	@JsonProperty("FolderId") 
	private int FolderId;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") 
	private int MessageId;
	
	/**
	 * Size of message (bytes)	
	 */
	@JsonProperty("MessageSize") 
	private int MessageSize;
	
	/**
	 * True/False if message was opened	
	 */
	@JsonProperty("Read") 
	private boolean Read;
	
	/**
	 * Numeric indicator of the status of the message	
	 */
	@JsonProperty("MessageStatus") 
	private int MessageStatus;
	
	/**
	 * Sender's email address
	 */
	@JsonProperty("SenderAddress") 
	private String SenderAddress;
	
	/**
	 * Subject of the message
	 */
	@JsonProperty("Subject") 
	private String Subject;

	public Summary() {
		AttachmentCount = 0;
		this.createTimeString = null;
		MessageId = 0;
		MessageSize = 0;
		Read = false;
		MessageStatus = 0;
		SenderAddress = null;
		Subject = null;
	}

	
	public Summary(int attachmentCount, String createTimeString, int folderId, int messageId, int messageSize,
			boolean read, int messageStatus, String senderAddress, String subject) {
		AttachmentCount = attachmentCount;
		this.createTimeString = createTimeString;
		FolderId = folderId;
		MessageId = messageId;
		MessageSize = messageSize;
		Read = read;
		MessageStatus = messageStatus;
		SenderAddress = senderAddress;
		Subject = subject;
	}

	@JsonIgnore
	public int getAttachmentCount() {
		return AttachmentCount;
	}

	@JsonIgnore
	public void setAttachmentCount(int attachmentCount) {
		AttachmentCount = attachmentCount;
	}

	@JsonIgnore
	public String getCreateTimeString() {
		return createTimeString;
	}

	@JsonIgnore
	public void setCreateTimeString(String createTimeString) {
		this.createTimeString = createTimeString;
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
	public String getSenderAddress() {
		return SenderAddress;
	}

	@JsonIgnore
	public void setSenderAddress(String senderAddress) {
		SenderAddress = senderAddress;
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
