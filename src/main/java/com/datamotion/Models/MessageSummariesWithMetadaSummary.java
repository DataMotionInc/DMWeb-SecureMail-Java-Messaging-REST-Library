package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageSummariesWithMetadaSummary {
	@JsonProperty("AttachmentCount")
	private int AttachmentCount;
	
	@JsonProperty("createTimeString")
	private String createTimeString;
	
	@JsonProperty("FolderId")
	private int FolderId;
	
	@JsonProperty("MessageId")
	private int MessageId;
	
	@JsonProperty("MessageSize")
	private int MessageSize;
	
	@JsonProperty("Read")
	private boolean Read;
	
	@JsonProperty("MessageStatus")
	private int MessageStatus;
	
	@JsonProperty("SenderAddress")
	private String SenderAddress;
	
	@JsonProperty("Subject")
	private String Subject;
	
	@JsonProperty("Attachments")
	private ArrayList<MessageWithMetadataAttachment> Attachments;
	
	@JsonProperty("ExpirationDate")
	private String ExpirationDate;
	
	@JsonProperty("SecurityEnvelope")
	private SecurityEnvelope SecurityEnvelope;
	
	@JsonProperty("Tracking")
	private Tracking Tracking;

	public MessageSummariesWithMetadaSummary() {
		// TODO Auto-generated constructor stub
	}

	public MessageSummariesWithMetadaSummary(int attachmentCount, String createTimeString, int folderId, int messageId,
			int messageSize, boolean read, int messageStatus, String senderAddress, String subject,
			ArrayList<MessageWithMetadataAttachment> attachments, String expirationDate,
			com.datamotion.Models.SecurityEnvelope securityEnvelope, com.datamotion.Models.Tracking tracking) {
		AttachmentCount = attachmentCount;
		this.createTimeString = createTimeString;
		FolderId = folderId;
		MessageId = messageId;
		MessageSize = messageSize;
		Read = read;
		MessageStatus = messageStatus;
		SenderAddress = senderAddress;
		Subject = subject;
		Attachments = attachments;
		ExpirationDate = expirationDate;
		SecurityEnvelope = securityEnvelope;
		Tracking = tracking;
	}

	public int getAttachmentCount() {
		return AttachmentCount;
	}

	public void setAttachmentCount(int attachmentCount) {
		AttachmentCount = attachmentCount;
	}

	public String getCreateTimeString() {
		return createTimeString;
	}

	public void setCreateTimeString(String createTimeString) {
		this.createTimeString = createTimeString;
	}

	public int getFolderId() {
		return FolderId;
	}

	public void setFolderId(int folderId) {
		FolderId = folderId;
	}

	public int getMessageId() {
		return MessageId;
	}

	public void setMessageId(int messageId) {
		MessageId = messageId;
	}

	public int getMessageSize() {
		return MessageSize;
	}

	public void setMessageSize(int messageSize) {
		MessageSize = messageSize;
	}

	public boolean isRead() {
		return Read;
	}

	public void setRead(boolean read) {
		Read = read;
	}

	public int getMessageStatus() {
		return MessageStatus;
	}

	public void setMessageStatus(int messageStatus) {
		MessageStatus = messageStatus;
	}

	public String getSenderAddress() {
		return SenderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		SenderAddress = senderAddress;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public ArrayList<MessageWithMetadataAttachment> getAttachments() {
		return Attachments;
	}

	public void setAttachments(ArrayList<MessageWithMetadataAttachment> attachments) {
		Attachments = attachments;
	}

	public String getExpirationDate() {
		return ExpirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		ExpirationDate = expirationDate;
	}

	public SecurityEnvelope getSecurityEnvelope() {
		return SecurityEnvelope;
	}

	public void setSecurityEnvelope(SecurityEnvelope securityEnvelope) {
		SecurityEnvelope = securityEnvelope;
	}

	public Tracking getTracking() {
		return Tracking;
	}

	public void setTracking(Tracking tracking) {
		Tracking = tracking;
	}
}
