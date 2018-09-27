package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Security Envelope Model Class
 */
public class SecurityEnvelope {
	/**
	 * Used to verify the integrity of the message, it is returned for reference only	
	 */
	@JsonProperty("Checksum") 
	private String Checksum;
	
	/**
	 * Used to generate the CheckSum. If not present, assume MD5	
	 */
	@JsonProperty("HashAlgorithm") 
	private String HashAlgorithm;
	
	/**
	 * Numeric indicator of the validation status	
	 */
	@JsonProperty("Status") 
	private int Status;
	
	/**
	 * Status represented as string description	
	 */
	@JsonProperty("StatusDescription") 
	private String StatusDescription;

	@JsonIgnore
	public SecurityEnvelope() {
		Checksum = null;
		HashAlgorithm = null;
		Status = 0;
		StatusDescription = null;
	}

	@JsonIgnore
	public SecurityEnvelope(String checksum, String hashAlgorithm, int status, String statusDescription) {
		Checksum = checksum;
		HashAlgorithm = hashAlgorithm;
		Status = status;
		StatusDescription = statusDescription;
	}

	@JsonIgnore
	public String getChecksum() {
		return Checksum;
	}

	@JsonIgnore
	public void setChecksum(String checksum) {
		Checksum = checksum;
	}

	@JsonIgnore
	public String getHashAlgorithm() {
		return HashAlgorithm;
	}

	@JsonIgnore
	public void setHashAlgorithm(String hashAlgorithm) {
		HashAlgorithm = hashAlgorithm;
	}

	@JsonIgnore
	public int getStatus() {
		return Status;
	}

	@JsonIgnore
	public void setStatus(int status) {
		Status = status;
	}

	@JsonIgnore
	public String getStatusDescription() {
		return StatusDescription;
	}

	@JsonIgnore
	public void setStatusDescription(String statusDescription) {
		StatusDescription = statusDescription;
	}
}
