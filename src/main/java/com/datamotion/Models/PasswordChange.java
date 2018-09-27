package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Password Change Model Class
 */
public class PasswordChange {
	/**
	 * Account's old password, must be correct
	 */
	@JsonProperty("OldPassword") 
	private String OldPassword;
	
	/**
	 * new password, must meet complexity requirements
	 */
	@JsonProperty ("NewPassword") 
	private String NewPassword;

	
	public PasswordChange() {
		OldPassword = null;
		NewPassword = null;
	}

	
	public PasswordChange(String oldPassword, String newPassword) {
		OldPassword = oldPassword;
		NewPassword = newPassword;
	}

	@JsonIgnore
	public String getOldPassword() {
		return OldPassword;
	}

	@JsonIgnore
	public void setOldPassword(String oldPassword) {
		OldPassword = oldPassword;
	}

	@JsonIgnore
	public String getNewPassword() {
		return NewPassword;
	}

	@JsonIgnore
	public void setNewPassword(String newPassword) {
		NewPassword = newPassword;
	}	
}
