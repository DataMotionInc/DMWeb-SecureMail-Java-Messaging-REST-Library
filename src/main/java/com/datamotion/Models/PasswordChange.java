package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Password Change Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class PasswordChange {
	/**
	 * Account's old password, must be correct
	 */
	@JsonProperty("OldPassword") @Getter @Setter
	private String OldPassword;
	
	/**
	 * new password, must meet complexity requirements
	 */
	@JsonProperty ("NewPassword") @Getter @Setter
	private String NewPassword;	
}
