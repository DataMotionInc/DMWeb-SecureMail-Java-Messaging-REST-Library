package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetAttachmentResponse {
	@JsonProperty("AttachmentBase64")
	private String AttachmentBase64;
	
	@JsonProperty("ContentID")
	private String ContentID;
	
	@JsonProperty("ContentType")
	private String ContentType;
	
	@JsonProperty("FileName")
	private String FileName;
	
	@JsonProperty("Size")
	private int Size;

	public GetAttachmentResponse() {
		// TODO Auto-generated constructor stub
	}

	public GetAttachmentResponse(String attachmentBase64, String contentID, String contentType, String fileName,
			int size) {
		AttachmentBase64 = attachmentBase64;
		ContentID = contentID;
		ContentType = contentType;
		FileName = fileName;
		Size = size;
	}

	public String getAttachmentBase64() {
		return AttachmentBase64;
	}

	public void setAttachmentBase64(String attachmentBase64) {
		AttachmentBase64 = attachmentBase64;
	}

	public String getContentID() {
		return ContentID;
	}

	public void setContentID(String contentID) {
		ContentID = contentID;
	}

	public String getContentType() {
		return ContentType;
	}

	public void setContentType(String contentType) {
		ContentType = contentType;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}
}
