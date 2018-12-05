package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AttachmentMetadata {
	@JsonProperty("AttachmentID")
	private String AttachmentID;
	
	@JsonProperty("ContentID")
	private String ContentID;
	
	@JsonProperty("ContentType")
	private String ContentType;
	
	@JsonProperty("FileName")
	private String FileName;
	
	@JsonProperty("Size")
	private int Size;

	public AttachmentMetadata() {
		// TODO Auto-generated constructor stub
	}

	public AttachmentMetadata(String attachmentID, String contentID, String contentType, String fileName, int size) {
		AttachmentID = attachmentID;
		ContentID = contentID;
		ContentType = contentType;
		FileName = fileName;
		Size = size;
	}

	public String getAttachmentID() {
		return AttachmentID;
	}

	public void setAttachmentID(String attachmentID) {
		AttachmentID = attachmentID;
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
