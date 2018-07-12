package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Move Message Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class MoveMessage {
	/**
	 * The destination folder's unique identifier	
	 */
	@JsonProperty("DestinationFolderId") @Getter @Setter
	private int DestinationFolderId;
}
