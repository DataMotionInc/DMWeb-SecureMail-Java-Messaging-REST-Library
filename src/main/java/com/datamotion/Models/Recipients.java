package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Recipients Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class Recipients {
	/**
	 * One of the following: 0(Invalid), 1(Valid), 2(NotApplied)	
	 */
	@JsonProperty("ChecksumValidated") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int ChecksumValidated;
	
	/**
	 * Indicates whether or not the message has been delivered	
	 */
	@JsonProperty("Delivered") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private boolean Delivered;
	
	/**
	 * The DateTime string representing when the message was delivered	
	 */
	@JsonProperty("DeliveredDate") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String DeliveredDate;
	
	/**
	 * Indicates whether or not the attachment has been downloaded	
	 */
	@JsonProperty("Downloaded") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private boolean Downloaded;
	
	/**
	 * The DateTime string representing when the attachment was downloaded	
	 */
	@JsonProperty("DownloadedDate") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String DownloadedDate;
	
	/**
	 * The email address of the recipient	
	 */
	@JsonProperty("Email") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Email;
}
