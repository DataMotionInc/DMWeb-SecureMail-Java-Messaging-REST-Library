package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * MetaData Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MetaData {
	/**
	 * Array of MetaData Attachment objects
	 * See MetaAttachment model class
	 */
	@JsonProperty ("Attachments") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<MetaAttachment> MetaAttachment;
	
	/**
	 * Date/time string for message expiration	
	 */
	@JsonProperty("ExpirationDate") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String ExpirationDate;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageId;
	
	/**
	 * Size in bytes of message	
	 */
	@JsonProperty("MessageSize") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageSize;
	
	/**
	 * Security Envelope Object
	 * See SecurityEnvelope Model Class
	 */
	@JsonProperty("SecurityEnvelope") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private SecurityEnvelope SecurityEnvelope;
	
	/**
	 * Array of Tracking objects
	 * See Tracking Model Class
	 */
	@JsonProperty("Tracking") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<Tracking> Tracking;

	@Override
	public String toString() {
		return "MetaData [MetaAttachment=" + MetaAttachment + ", ExpirationDate=" + ExpirationDate + ", MessageId="
				+ MessageId + ", MessageSize=" + MessageSize + ", SecurityEnvelope=" + SecurityEnvelope + ", Tracking="
				+ Tracking + "]";
	}
	
	
}
