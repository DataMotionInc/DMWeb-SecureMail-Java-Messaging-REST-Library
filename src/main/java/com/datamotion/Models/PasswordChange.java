package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PasswordChange {
	@JsonProperty("OldPassword") @Getter @Setter
	private String OldPassword;
	
	@JsonProperty ("NewPassword") @Getter @Setter
	private String NewPassword;	
}
