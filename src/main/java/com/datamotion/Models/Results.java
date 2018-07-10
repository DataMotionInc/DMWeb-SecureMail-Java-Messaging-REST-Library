package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Results {
	@JsonProperty("CreateTime") @Getter @Setter
	private String CreateTime;
	
	@JsonProperty ("LastAction") @Getter @Setter
	private int LastAction;
	
	@JsonProperty("MessageId") @Getter @Setter
	private int MessageId;
	
	@JsonProperty("MessageSize") @Getter @Setter
	private int MessageSize;
	
	@JsonProperty("MessageStatusId") @Getter @Setter
	private int MessageStatusId;
	
	@JsonProperty("PasswordHint") @Getter @Setter
	private String PasswordHint;
	
	@JsonProperty("Read") @Getter @Setter
	private boolean Read;
	
	@JsonProperty("MessageStatus") @Getter @Setter
	private int MessageStatus;
	
	@JsonProperty("ReadConfirmation") @Getter @Setter
	private boolean ReadConfirmation;
	
	@JsonProperty("SenderEmail") @Getter @Setter
	private String SenderEmail;
	
	@JsonProperty("SenderId") @Getter @Setter
	private int SenderId;
	
	@JsonProperty("Subject") @Getter @Setter
	private String Subject;
}
