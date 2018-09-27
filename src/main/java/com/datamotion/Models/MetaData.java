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
	private ArrayList<MetaAttachment> MetaAttachment;
	
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

	@Override
	public String toString() {
		return "MetaData [MetaAttachment=" + MetaAttachment + ", ExpirationDate=" + ExpirationDate + ", MessageId="
				+ MessageId + ", MessageSize=" + MessageSize + ", SecurityEnvelope=" + SecurityEnvelope + ", Tracking="
				+ Tracking + "]";
	}

	@JsonIgnore
	public MetaData() {
		MetaAttachment = null;
		ExpirationDate = null;
		MessageId = 0;
		MessageSize = 0;
		SecurityEnvelope = null;
		Tracking = null;
	}

	@JsonIgnore
	public MetaData(ArrayList<com.datamotion.Models.MetaAttachment> metaAttachment, String expirationDate,
			int messageId, int messageSize, com.datamotion.Models.SecurityEnvelope securityEnvelope,
			ArrayList<com.datamotion.Models.Tracking> tracking) {
		MetaAttachment = metaAttachment;
		ExpirationDate = expirationDate;
		MessageId = messageId;
		MessageSize = messageSize;
		SecurityEnvelope = securityEnvelope;
		Tracking = tracking;
	}

	@JsonIgnore
	public ArrayList<MetaAttachment> getMetaAttachment() {
		return MetaAttachment;
	}

	@JsonIgnore
	public void setMetaAttachment(ArrayList<MetaAttachment> metaAttachment) {
		MetaAttachment = metaAttachment;
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
