package com.mavenMessaging;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Details {
	@JsonProperty ("EmailAddress") @Getter @Setter
	private String EmailAddress;
	
	@JsonProperty("FirstName") @Getter @Setter
	private String FirstName;
	
	@JsonProperty("LastName") @Getter @Setter
	private String LastName;
	
	@JsonProperty("Statistics") @Getter @Setter
	private Statistics Statistics;	
}