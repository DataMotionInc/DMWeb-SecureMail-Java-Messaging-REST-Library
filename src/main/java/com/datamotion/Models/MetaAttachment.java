package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * MetaAttachment Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MetaAttachment {
	/**
	 * Attachment unique identifier	
	 */
	@JsonProperty("AttachmentId") @Getter @Setter
	private int AttachmentId;
	
	/**
	 * Attachment file name	
	 */
	@JsonProperty("FileName") @Getter @Setter
	private String FileName;
	
	/**
	 * Security Envelope Object
	 * See SecurityEnvelope Model Class
	 */
	@JsonProperty("SecurityEnvelope") @Getter @Setter
	private SecurityEnvelope SecurityEnvelope;
	
	/**
	 * Attachment size (b)	
	 */
	@JsonProperty("Size") @Getter @Setter
	private Size Size;
	
	/**
	 * Array of Recipient objects
	 * See Recipient model class
	 */
	@JsonProperty("Tracking") @Getter @Setter
	private MetaTracking Tracking;
}
