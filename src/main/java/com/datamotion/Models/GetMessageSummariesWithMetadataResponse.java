package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetMessageSummariesWithMetadataResponse {
	@JsonProperty("Summaries")
	private ArrayList<MessageSummariesWithMetadaSummary> Summaries;

	public GetMessageSummariesWithMetadataResponse() {
		// TODO Auto-generated constructor stub
	}

	public GetMessageSummariesWithMetadataResponse(ArrayList<MessageSummariesWithMetadaSummary> summaries) {
		Summaries = summaries;
	}

	public ArrayList<MessageSummariesWithMetadaSummary> getSummaries() {
		return Summaries;
	}

	public void setSummaries(ArrayList<MessageSummariesWithMetadaSummary> summaries) {
		Summaries = summaries;
	}
}
