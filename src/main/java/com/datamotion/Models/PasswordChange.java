package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty("OldPassword") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String OldPassword;
	
	/**
	 * new password, must meet complexity requirements
	 */
	@JsonProperty ("NewPassword") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String NewPassword;	
}
