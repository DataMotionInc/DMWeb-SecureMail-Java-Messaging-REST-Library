package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Message Summaries Response Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MessageSummariesResponse {
	/**
	 * Indicates whether there are more messages available	
	 */
	@JsonProperty("MoreMessagesAvailable") @Getter @Setter
	private boolean MoreMessagesAvailable;
	
	/**
	 * Array of Summaries objects
	 * See Summary model class
	 */
	@JsonProperty("Summaries") @Getter @Setter
	private ArrayList<Summary> Summaries;
	
}
