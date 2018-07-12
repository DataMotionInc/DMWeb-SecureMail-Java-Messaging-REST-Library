package com.datamotion.Models;

import lombok.AllArgsConstructor;
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
	@Getter @Setter
	private String Key;
	
	/**
	 * Http header value field
	 */
	@Getter @Setter
	private String Value;	
}
