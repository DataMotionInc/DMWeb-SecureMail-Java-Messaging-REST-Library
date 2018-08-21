package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty("AttachmentId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int AttachmentId;
	
	/**
	 * Attachment file name	
	 */
	@JsonProperty("FileName") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String FileName;
	
	/**
	 * Security Envelope Object
	 * See SecurityEnvelope Model Class
	 */
	@JsonProperty("SecurityEnvelope") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private SecurityEnvelope SecurityEnvelope;
	
	/**
	 * Attachment size (b)	
	 */
	@JsonProperty("Size") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private Size Size;
	
	/**
	 * Array of Recipient objects
	 * See Recipient model class
	 */
	@JsonProperty("Tracking") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private MetaTracking Tracking;
}
