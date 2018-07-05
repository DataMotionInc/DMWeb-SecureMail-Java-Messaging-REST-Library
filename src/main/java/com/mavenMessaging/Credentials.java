package com.mavenMessaging;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
	@JsonProperty("UserIdOrEmail") @Getter @Setter
	private String useridoremail;
	
	@JsonProperty("Password") @Getter @Setter
	private String password;
}
