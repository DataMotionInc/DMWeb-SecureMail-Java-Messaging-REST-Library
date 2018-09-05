package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Size Model Class
 * @author TylerB
 *
 */
@AllArgsConstructor
@NoArgsConstructor
public class Size {
	/**
	 * Size represented as StdString
	 */
	@JsonProperty("StdString") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String StdString;
}
