package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * New Folder Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class NewFolder {
	/**
	 * The name of the folder	
	 */
	@JsonProperty("FolderName") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String FolderName;
	
	/**
	 * The integer type of folder. Default is 0.	
	 */
	@JsonProperty("FolderType") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int FolderType;	
}
