package com.datamotion.Models;

import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * New Folder Id model class
 */
@AllArgsConstructor
@NoArgsConstructor
public class NewFolderId {
	/**
	 * The unique ID of the newly created folder	
	 */
	@JsonProperty("FolderId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int FolderId;
}
