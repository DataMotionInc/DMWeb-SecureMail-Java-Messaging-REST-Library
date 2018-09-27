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

	@Override
	public String toString() {
		return "Details [\nEmailAddress= " + EmailAddress + "\nFirstName= " + FirstName + "\nLastName= " + LastName
				+ "\nStatistics=\n" + Statistics.toString() + "]";
	}

	@JsonIgnore
	public Details() {
		EmailAddress = null;
		FirstName = null;
		LastName = null;
		Statistics = null;
	}

	@JsonIgnore
	public Details(String emailAddress, String firstName, String lastName,
			com.datamotion.Models.Statistics statistics) {
		EmailAddress = emailAddress;
		FirstName = firstName;
		LastName = lastName;
		Statistics = statistics;
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
	
}