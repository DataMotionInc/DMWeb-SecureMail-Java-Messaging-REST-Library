package com.datamotion.Models;

import java.util.ArrayList;

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
	@JsonProperty ("Attachments") @Getter @Setter
	private ArrayList<MetaAttachment> MetaAttachment;
	
	/**
	 * Date/time string for message expiration	
	 */
	@JsonProperty("ExpirationDate") @Getter @Setter
	private String ExpirationDate;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") @Getter @Setter
	private int MessageId;
	
	/**
	 * Size in bytes of message	
	 */
	@JsonProperty("MessageSize") @Getter @Setter
	private int MessageSize;
	
	/**
	 * Security Envelope Object
	 * See SecurityEnvelope Model Class
	 */
	@JsonProperty("SecurityEnvelope") @Getter @Setter
	private SecurityEnvelope SecurityEnvelope;
	
	/**
	 * Array of Tracking objects
	 * See Tracking Model Class
	 */
	@JsonProperty("Tracking") @Getter @Setter
	private ArrayList<Tracking> Tracking;
}
