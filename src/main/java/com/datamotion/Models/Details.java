package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Account Details Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class Details {
	/**
	 * Account email address
	 */
	@JsonProperty ("EmailAddress") @Getter @Setter
	private String EmailAddress;
	
	/**
	 * Account First Name
	 */
	@JsonProperty("FirstName") @Getter @Setter
	private String FirstName;
	
	/**
	 * Account Last Name
	 */
	@JsonProperty("LastName") @Getter @Setter
	private String LastName;
	
	/**
	 * Account Statistics
	 * (See <code>Statistics</code> model)
	 */
	@JsonProperty("Statistics") @Getter @Setter
	private Statistics Statistics;

	@Override
	public String toString() {
		return "Details [\nEmailAddress= " + EmailAddress + "\nFirstName= " + FirstName + "\nLastName= " + LastName
				+ "\nStatistics=\n" + Statistics.toString() + "]";
	}	
	
	
}