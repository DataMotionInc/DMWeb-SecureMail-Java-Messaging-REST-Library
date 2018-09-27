package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * MimeMessage Model Class
 */
public class MimeMessage {
	/**
	 * MIME message string, must be properly formatted 
	 */
	@JsonProperty("MimeMessage") 
	private String MimeMessage;

	
	public MimeMessage() {
		MimeMessage = null;
	}

	
	public MimeMessage(String mimeMessage) {
		MimeMessage = mimeMessage;
	}

	@JsonIgnore
	public String getMimeMessage() {
		return MimeMessage;
	}

	@JsonIgnore
	public void setMimeMessage(String mimeMessage) {
		MimeMessage = mimeMessage;
	}
}
