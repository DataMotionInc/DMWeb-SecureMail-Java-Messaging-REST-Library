package com.mavenMessaging;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class MessageSummariesResponse {
	@JsonProperty("MoreMessagesAvailable") @Getter @Setter
	private boolean MoreMessagesAvailable;
	
	@JsonProperty("Summaries") @Getter @Setter
	private ArrayList<Summary> Summaries;
	
}
