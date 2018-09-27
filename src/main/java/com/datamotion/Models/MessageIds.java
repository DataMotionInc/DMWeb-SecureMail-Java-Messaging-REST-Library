package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Message Ids Model Class
 */
public class MessageIds {
	/**
	 * Array of message ID integers
	 */
	@JsonProperty("MessageIds") 
	private ArrayList<Integer> MessageIds;

	
	public MessageIds() {
		MessageIds = null;
	}

	
	public MessageIds(ArrayList<Integer> messageIds) {
		MessageIds = messageIds;
	}

	@JsonIgnore
	public ArrayList<Integer> getMessageIds() {
		return MessageIds;
	}

	@JsonIgnore
	public void setMessageIds(ArrayList<Integer> messageIds) {
		MessageIds = messageIds;
	}
}
