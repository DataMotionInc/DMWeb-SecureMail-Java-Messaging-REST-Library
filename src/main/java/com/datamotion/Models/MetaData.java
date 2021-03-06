package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * MetaData Model Class
 */
public class MetaData {
	/**
	 * Array of MetaData Attachment objects
	 * See MetaAttachment model class
	 */
	@JsonProperty ("Attachments") 
	private ArrayList<MetaAttachment> Attachments;
	
	/**
	 * Date/time string for message expiration	
	 */
	@JsonProperty("ExpirationDate") 
	private String ExpirationDate;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") 
	private int MessageId;
	
	/**
	 * Size in bytes of message	
	 */
	@JsonProperty("MessageSize") 
	private int MessageSize;
	
	/**
	 * Security Envelope Object
	 * See SecurityEnvelope Model Class
	 */
	@JsonProperty("SecurityEnvelope") 
	private SecurityEnvelope SecurityEnvelope;
	
	/**
	 * Array of Tracking objects
	 * See Tracking Model Class
	 */
	@JsonProperty("Tracking") 
	private ArrayList<Tracking> Tracking;
	
	public MetaData() {
		Attachments = null;
		ExpirationDate = null;
		MessageId = 0;
		MessageSize = 0;
		SecurityEnvelope = null;
		Tracking = null;
	}

	
	public MetaData(ArrayList<com.datamotion.Models.MetaAttachment> metaAttachment, String expirationDate,
			int messageId, int messageSize, com.datamotion.Models.SecurityEnvelope securityEnvelope,
			ArrayList<com.datamotion.Models.Tracking> tracking) {
		Attachments = metaAttachment;
		ExpirationDate = expirationDate;
		MessageId = messageId;
		MessageSize = messageSize;
		SecurityEnvelope = securityEnvelope;
		Tracking = tracking;
	}

	@JsonIgnore
	public ArrayList<MetaAttachment> getAttachments() {
		return Attachments;
	}

	@JsonIgnore
	public void setAttachments(ArrayList<MetaAttachment> metaAttachment) {
		Attachments = metaAttachment;
	}

	@JsonIgnore
	public String getExpirationDate() {
		return ExpirationDate;
	}

	@JsonIgnore
	public void setExpirationDate(String expirationDate) {
		ExpirationDate = expirationDate;
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
	public SecurityEnvelope getSecurityEnvelope() {
		return SecurityEnvelope;
	}

	@JsonIgnore
	public void setSecurityEnvelope(SecurityEnvelope securityEnvelope) {
		SecurityEnvelope = securityEnvelope;
	}

	@JsonIgnore
	public ArrayList<Tracking> getTracking() {
		return Tracking;
	}

	@JsonIgnore
	public void setTracking(ArrayList<Tracking> tracking) {
		Tracking = tracking;
	}
	
	
}
