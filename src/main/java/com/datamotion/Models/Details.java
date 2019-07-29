package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Account Details Model Class
 */

public class Details {
	/**
	 * Account email address
	 */
	@JsonProperty ("EmailAddress")
	private String EmailAddress;
	
	/**
	 * Account First Name
	 */
	@JsonProperty("FirstName")
	private String FirstName;
	
	/**
	 * Account Last Name
	 */
	@JsonProperty("LastName")
	private String LastName;
	
	/**
	 * Account Statistics
	 * (See <code>Statistics</code> model)
	 */
	@JsonProperty("Statistics")
	private Statistics Statistics;
	
	/**
	 * Account Uid
	 */
	@JsonProperty("Uid")
	private Integer Uid;

	/**
	 * Account UserId
	 */
	@JsonProperty("UserId")
	private String UserId;

	public Details() {
		EmailAddress = null;
		FirstName = null;
		LastName = null;
		Statistics = null;
		Uid = null;
		UserId = null;
	}

	
	public Details(String emailAddress, String firstName, String lastName,
			com.datamotion.Models.Statistics statistics, Integer uid, String userId) {
		EmailAddress = emailAddress;
		FirstName = firstName;
		LastName = lastName;
		Statistics = statistics;
		Uid = uid;
		UserId = userId;
	}

	@JsonIgnore
	public String getEmailAddress() {
		return EmailAddress;
	}

	@JsonIgnore
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}

	@JsonIgnore
	public String getFirstName() {
		return FirstName;
	}

	@JsonIgnore
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	@JsonIgnore
	public String getLastName() {
		return LastName;
	}

	@JsonIgnore
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@JsonIgnore
	public Statistics getStatistics() {
		return Statistics;
	}

	@JsonIgnore
	public void setStatistics(Statistics statistics) {
		Statistics = statistics;
	}
	
	@JsonIgnore
	public Integer getUid(){
		return Uid;
	}

	@JsonIgnore
	public void setUid(Integer uid){
		Uid = uid;
	}

	@JsonIgnore
	public String getUserId(){
		return UserId;
	}

	@JsonIgnore
	public void setUserId(String userId){
		UserId = userId;
	}

	
}