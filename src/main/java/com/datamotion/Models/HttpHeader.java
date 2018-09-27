package com.datamotion.Models;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

	public HttpHeader() {
		this.Key = null;
		this.Value = null;
	}	
	
	public HttpHeader(String key, String value) {
		this.Key = key;
		this.Value = value;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public String getValue() {
		return Value;
	}

	public void setValue(String value) {
		Value = value;
	}
	
}
