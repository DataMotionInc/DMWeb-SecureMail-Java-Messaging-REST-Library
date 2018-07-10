package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("ChecksumValidated") @Getter @Setter
	private int ChecksumValidated;
	
	/**
	 * Indicates whether or not the message has been delivered	
	 */
	@JsonProperty("Delivered") @Getter @Setter
	private boolean Delivered;
	
	/**
	 * The DateTime string representing when the message was delivered	
	 */
	@JsonProperty("DeliveredDate") @Getter @Setter
	private String DeliveredDate;
	
	/**
	 * Indicates whether or not the attachment has been downloaded	
	 */
	@JsonProperty("Downloaded") @Getter @Setter
	private boolean Downloaded;
	
	/**
	 * The DateTime string representing when the attachment was downloaded	
	 */
	@JsonProperty("DownloadedDate") @Getter @Setter
	private String DownloadedDate;
	
	/**
	 * The email address of the recipient	
	 */
	@JsonProperty("Email") @Getter @Setter
	private String Email;
}
