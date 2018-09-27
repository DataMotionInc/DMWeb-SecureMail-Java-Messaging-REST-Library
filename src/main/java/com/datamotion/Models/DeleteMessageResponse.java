package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Delete Message Response Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class DeleteMessageResponse {
	/**
	 * New trash folder's ID
	 */
	@JsonProperty("NewFolderId")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int NewFolderId;
	
	/**
	 * Message regarding delete request results
	 */
	@JsonProperty("Result")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Result;
}
