package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	@JsonProperty("MimeMessage") @Getter @Setter
	private String MimeMessage;
}
