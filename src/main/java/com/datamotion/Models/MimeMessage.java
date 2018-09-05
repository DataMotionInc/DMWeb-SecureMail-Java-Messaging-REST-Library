package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * MimeMessage Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MimeMessage {
	/**
	 * MIME message string, must be properly formatted 
	 */
	@JsonProperty("MimeMessage") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String MimeMessage;
}
