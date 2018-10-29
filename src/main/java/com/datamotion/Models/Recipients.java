package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Recipients Model Class
 */
public class Recipients {
	/**
	 * One of the following: 0(Invalid), 1(Valid), 2(NotApplied)	
	 */
	@JsonProperty("ChecksumValidated") 
	private int ChecksumValidated;
	
	/**
	 * Indicates whether or not the message has been delivered	
	 */
	@JsonProperty("Delivered") 
	private boolean Delivered;
	
	/**
	 * The DateTime string representing when the message was delivered	
	 */
	@JsonProperty("DeliveredDate") 
	private String DeliveredDate;
	
	/**
	 * Indicates whether or not the attachment has been downloaded	
	 */
	@JsonProperty("Downloaded") 
	private boolean Downloaded;
	
	/**
	 * The DateTime string representing when the attachment was downloaded	
	 */
	@JsonProperty("DownloadedDate") 
	private String DownloadedDate;
	
	/**
	 * The email address of the recipient	
	 */
	@JsonProperty("Email") 
	private String Email;

	
	public Recipients() {
		ChecksumValidated =0;
		Delivered = false;
		DeliveredDate = null;
		Downloaded = false;
		DownloadedDate = null;
		Email = null;
	}

	
	public Recipients(int checksumValidated, boolean delivered, String deliveredDate, boolean downloaded,
			String downloadedDate, String email) {
		ChecksumValidated = checksumValidated;
		Delivered = delivered;
		DeliveredDate = deliveredDate;
		Downloaded = downloaded;
		DownloadedDate = downloadedDate;
		Email = email;
	}

	@JsonIgnore
	public int getChecksumValidated() {
		return ChecksumValidated;
	}

	@JsonIgnore
	public void setChecksumValidated(int checksumValidated) {
		ChecksumValidated = checksumValidated;
	}

	@JsonIgnore
	public boolean getDelivered() {
		return Delivered;
	}

	@JsonIgnore
	public void setDelivered(boolean delivered) {
		Delivered = delivered;
	}

	@JsonIgnore
	public String getDeliveredDate() {
		return DeliveredDate;
	}

	@JsonIgnore
	public void setDeliveredDate(String deliveredDate) {
		DeliveredDate = deliveredDate;
	}

	@JsonIgnore
	public boolean getDownloaded() {
		return Downloaded;
	}

	@JsonIgnore
	public void setDownloaded(boolean downloaded) {
		Downloaded = downloaded;
	}

	@JsonIgnore
	public String getDownloadedDate() {
		return DownloadedDate;
	}

	@JsonIgnore
	public void setDownloadedDate(String downloadedDate) {
		DownloadedDate = downloadedDate;
	}

	@JsonIgnore
	public String getEmail() {
		return Email;
	}

	@JsonIgnore
	public void setEmail(String email) {
		Email = email;
	}
}
