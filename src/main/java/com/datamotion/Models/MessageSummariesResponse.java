package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Message Summaries Response Model Class
 */
public class MessageSummariesResponse {
	/**
	 * Indicates whether there are more messages available	
	 */
	@JsonProperty("MoreMessagesAvailable") 
	private boolean MoreMessagesAvailable;
	
	/**
	 * Array of Summaries objects
	 * See Summary model class
	 */
	@JsonProperty("Summaries") 
	private ArrayList<Summary> Summaries;

	@Override
	public String toString() {
		return "MessageSummariesResponse [\nMoreMessagesAvailable= " + MoreMessagesAvailable + "\nSummaries=\n" + Summaries
				+ "\n]";
	}

	
	public MessageSummariesResponse() {
		MoreMessagesAvailable = false;
		Summaries = null;
	}

	
	public MessageSummariesResponse(boolean moreMessagesAvailable, ArrayList<Summary> summaries) {
		MoreMessagesAvailable = moreMessagesAvailable;
		Summaries = summaries;
	}

	@JsonIgnore
	public boolean isMoreMessagesAvailable() {
		return MoreMessagesAvailable;
	}

	@JsonIgnore
	public void setMoreMessagesAvailable(boolean moreMessagesAvailable) {
		MoreMessagesAvailable = moreMessagesAvailable;
	}

	@JsonIgnore
	public ArrayList<Summary> getSummaries() {
		return Summaries;
	}

	@JsonIgnore
	public void setSummaries(ArrayList<Summary> summaries) {
		Summaries = summaries;
	}
}
