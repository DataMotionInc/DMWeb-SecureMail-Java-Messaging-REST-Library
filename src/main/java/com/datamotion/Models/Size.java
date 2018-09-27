package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Size Model Class
 * @author TylerB
 *
 */
public class Size {
	/**
	 * Size represented as StdString
	 */
	@JsonProperty("StdString") 
	private String StdString;

	
	public Size() {
		StdString = null;
	}

	
	public Size(String stdString) {
		StdString = stdString;
	}

	@JsonIgnore
	public String getStdString() {
		return StdString;
	}

	@JsonIgnore
	public void setStdString(String stdString) {
		StdString = stdString;
	}
}
