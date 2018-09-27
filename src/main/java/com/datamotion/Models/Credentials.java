package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Credentials Model Class
 * Valid credentials are required to retrieve a session key
 */
public class Credentials {
	/**
	 * login username or email address
	 */
	@JsonProperty("UserIdOrEmail")
	private String useridoremail;
	
	/**
	 * login password
	 */
	@JsonProperty("Password")
	private String password;
	
	@JsonIgnore
	public Credentials() {
		this.useridoremail = null;
		this.password = null;
	}
	@JsonIgnore
	public Credentials(String useridoremail, String password) {
		this.useridoremail = useridoremail;
		this.password = password;
	}
	
	@JsonIgnore
	public String getUseridoremail() {
		return useridoremail;
	}
	
	@JsonIgnore
	public void setUseridoremail(String useridoremail) {
		this.useridoremail = useridoremail;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	//@JsonIgnore
}
