package com.datamotion.Models;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * HttpHeader class with fields for key and value
 */
@AllArgsConstructor
@NoArgsConstructor
public class HttpHeader {
	/**
	 * Http header key field
	 */
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Key;
	
	/**
	 * Http header value field
	 */
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Value;	
}
