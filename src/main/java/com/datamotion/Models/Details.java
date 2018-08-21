package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty ("EmailAddress")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String EmailAddress;
	
	/**
	 * Account First Name
	 */
	@JsonProperty("FirstName")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String FirstName;
	
	/**
	 * Account Last Name
	 */
	@JsonProperty("LastName")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String LastName;
	
	/**
	 * Account Statistics
	 * (See <code>Statistics</code> model)
	 */
	@JsonProperty("Statistics")
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private Statistics Statistics;

	@Override
	public String toString() {
		return "Details [\nEmailAddress= " + EmailAddress + "\nFirstName= " + FirstName + "\nLastName= " + LastName
				+ "\nStatistics=\n" + Statistics.toString() + "]";
	}	
	
	
}