package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Message ID Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MessageId {
	/**
	 * The unique message identifier for the newly created message	
	 */
	@JsonProperty("MessageId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageId;
}
