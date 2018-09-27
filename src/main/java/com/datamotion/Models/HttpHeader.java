package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * HttpHeader class with fields for key and value
 */
public class HttpHeader {
	/**
	 * Http header key field
	 */
	private String Key;
	
	/**
	 * Http header value field
	 */
	private String Value;

	@JsonIgnore
	public HttpHeader() {
		Key = null;
		Value = null;
	}

	@JsonIgnore
	public HttpHeader(String key, String value) {
		Key = key;
		Value = value;
	}

	@JsonIgnore
	public String getKey() {
		return Key;
	}

	@JsonIgnore
	public void setKey(String key) {
		Key = key;
	}

	@JsonIgnore
	public String getValue() {
		return Value;
	}

	@JsonIgnore
	public void setValue(String value) {
		Value = value;
	}	
}
