package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Message Ids Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MessageIds {
	/**
	 * Array of message ID integers
	 */
	@JsonProperty("MessageIds") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<Integer> MessageIds;
}
