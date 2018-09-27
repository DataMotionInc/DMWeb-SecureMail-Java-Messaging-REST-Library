package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * MetaAttachment Model Class
 */
public class MetaAttachment {
	/**
	 * Attachment unique identifier	
	 */
	@JsonProperty("AttachmentId") 
	private int AttachmentId;
	
	/**
	 * Attachment file name	
	 */
	@JsonProperty("FileName") 
	private String FileName;
	
	/**
	 * Security Envelope Object
	 * See SecurityEnvelope Model Class
	 */
	@JsonProperty("SecurityEnvelope") 
	private SecurityEnvelope SecurityEnvelope;
	
	/**
	 * Attachment size (b)	
	 */
	@JsonProperty("Size") 
	private Size Size;
	
	/**
	 * Array of Recipient objects
	 * See Recipient model class
	 */
	@JsonProperty("Tracking") 
	private MetaTracking Tracking;

	@JsonIgnore
	public MetaAttachment() {
		AttachmentId = 0;
		FileName = null;
		SecurityEnvelope = null;
		Size = null;
		Tracking = null;
	}

	@JsonIgnore
	public MetaAttachment(int attachmentId, String fileName, com.datamotion.Models.SecurityEnvelope securityEnvelope,
			com.datamotion.Models.Size size, MetaTracking tracking) {
		AttachmentId = attachmentId;
		FileName = fileName;
		SecurityEnvelope = securityEnvelope;
		Size = size;
		Tracking = tracking;
	}

	@JsonIgnore
	public int getAttachmentId() {
		return AttachmentId;
	}

	@JsonIgnore
	public void setAttachmentId(int attachmentId) {
		AttachmentId = attachmentId;
	}

	@JsonIgnore
	public String getFileName() {
		return FileName;
	}

	@JsonIgnore
	public void setFileName(String fileName) {
		FileName = fileName;
	}

	@JsonIgnore
	public SecurityEnvelope getSecurityEnvelope() {
		return SecurityEnvelope;
	}

	@JsonIgnore
	public void setSecurityEnvelope(SecurityEnvelope securityEnvelope) {
		SecurityEnvelope = securityEnvelope;
	}

	@JsonIgnore
	public Size getSize() {
		return Size;
	}

	@JsonIgnore
	public void setSize(Size size) {
		Size = size;
	}

	@JsonIgnore
	public MetaTracking getTracking() {
		return Tracking;
	}

	@JsonIgnore
	public void setTracking(MetaTracking tracking) {
		Tracking = tracking;
	}
}
