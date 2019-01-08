package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageWithMetadataAttachment {
	@JsonProperty("AttachmentId")
	private int AttachmentId;
	
	@JsonProperty("ContentID")
	private String ContentID;
	
	@JsonProperty("FileName")
	private String FileName;
	
	@JsonProperty("Size")
	private Size Size;
	
	@JsonProperty("SecurityEnvelope")
	private SecurityEnvelope SecurityEnvelope;
	
	@JsonProperty("Tracking")
	private MetaTracking Tracking;

	public MessageWithMetadataAttachment() {
		// TODO Auto-generated constructor stub
	}

	public MessageWithMetadataAttachment(int attachmentId, String contentID, String fileName,
			com.datamotion.Models.Size size, com.datamotion.Models.SecurityEnvelope securityEnvelope,
			MetaTracking tracking) {
		AttachmentId = attachmentId;
		ContentID = contentID;
		FileName = fileName;
		Size = size;
		SecurityEnvelope = securityEnvelope;
		Tracking = tracking;
	}

	public int getAttachmentId() {
		return AttachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		AttachmentId = attachmentId;
	}

	public String getContentID() {
		return ContentID;
	}

	public void setContentID(String contentID) {
		ContentID = contentID;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public Size getSize() {
		return Size;
	}

	public void setSize(Size size) {
		Size = size;
	}

	public SecurityEnvelope getSecurityEnvelope() {
		return SecurityEnvelope;
	}

	public void setSecurityEnvelope(SecurityEnvelope securityEnvelope) {
		SecurityEnvelope = securityEnvelope;
	}

	public MetaTracking getTracking() {
		return Tracking;
	}

	public void setTracking(MetaTracking tracking) {
		Tracking = tracking;
	}
}
