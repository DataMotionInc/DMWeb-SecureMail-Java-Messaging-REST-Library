package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Tracking Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class Tracking {
	/**
	 * The date/time string that the message was opened. Note: If year = 1900, then there is no DateOpened associated with the current message status.	
	 */
	@JsonProperty("DateOpened") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String DateOpened;
	
	/**
	 * The email address of the recipient	
	 */
	@JsonProperty("Email") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Email;
	
	/**
	 * Status represented as string description	
	 */
	@JsonProperty("MessageStatusDescription") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String MessageStatusDescription;
	
	/**
	 * Numeric indicator of the status of the individual recipient	
	 */
	@JsonProperty("MessageStatusId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageStatusId;
	
	/**
	 * Indicates whether this recipient was the TO, CC, or BCC of the message	
	 */
	@JsonProperty("ReceiverField") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String ReceiverField;
}
