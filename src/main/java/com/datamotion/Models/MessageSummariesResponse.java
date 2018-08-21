package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty("MoreMessagesAvailable") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private boolean MoreMessagesAvailable;
	
	/**
	 * Array of Summaries objects
	 * See Summary model class
	 */
	@JsonProperty("Summaries") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<Summary> Summaries;

	@Override
	public String toString() {
		return "MessageSummariesResponse [\nMoreMessagesAvailable= " + MoreMessagesAvailable + "\nSummaries=\n" + Summaries
				+ "\n]";
	}
}
