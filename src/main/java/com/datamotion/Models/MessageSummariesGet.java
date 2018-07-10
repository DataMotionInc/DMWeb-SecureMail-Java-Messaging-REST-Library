package com.datamotion.Models;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
public class MessageSummariesGet {
	@JsonProperty ("FolderId") @Getter @Setter
	private int FolderId;
	
	@JsonProperty("LastMessageIDReceived") @Getter @Setter
	private int LastMessageIDReceived;	
}
