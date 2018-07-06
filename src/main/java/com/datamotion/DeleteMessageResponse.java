package com.datamotion;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class DeleteMessageResponse {
	@JsonProperty("NewFolderId") @Getter @Setter
	private int NewFolderId;
	
	@JsonProperty("Result") @Getter @Setter
	private String Result;
}
