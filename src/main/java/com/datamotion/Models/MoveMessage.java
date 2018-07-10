package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class MoveMessage {
	@JsonProperty("DestinationFolderId") @Getter @Setter
	private int DestinationFolderId;
}
