package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Credentials Model Class
 * Valid credentials are required to retrieve a session key
 */
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
	/**
	 * login username or email address
	 */
	@JsonProperty("UserIdOrEmail")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String useridoremail;
	
	/**
	 * login password
	 */
	@JsonProperty("Password")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String password;
}
