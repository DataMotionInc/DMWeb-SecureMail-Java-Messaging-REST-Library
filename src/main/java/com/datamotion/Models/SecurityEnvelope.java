package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Security Envelope Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class SecurityEnvelope {
	/**
	 * Used to verify the integrity of the message, it is returned for reference only	
	 */
	@JsonProperty("Checksum") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Checksum;
	
	/**
	 * Used to generate the CheckSum. If not present, assume MD5	
	 */
	@JsonProperty("HashAlgorithm") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String HashAlgorithm;
	
	/**
	 * Numeric indicator of the validation status	
	 */
	@JsonProperty("Status") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int Status;
	
	/**
	 * Status represented as string description	
	 */
	@JsonProperty("StatusDescription") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String StatusDescription;
}
