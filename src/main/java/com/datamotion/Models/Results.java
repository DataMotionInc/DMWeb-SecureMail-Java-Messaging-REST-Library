package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Results Model Class
 */
@NoArgsConstructor
@AllArgsConstructor
public class Results {
	/**
	 * Date/time the message was created	
	 */
	@JsonProperty("CreateTime") @Getter @Setter
	private String CreateTime;
	
	/**
	 * Last action taken by user. (0) None, (1) Replied, (2) Forwarded	
	 */
	@JsonProperty ("LastAction") @Getter @Setter
	private int LastAction;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") @Getter @Setter
	private int MessageId;
	
	/**
	 * Total size (bytes) of messages contained in folder	
	 */
	@JsonProperty("MessageSize") @Getter @Setter
	private int MessageSize;
	
	/**
	 * Numeric indicator of the status of the message	
	 */
	@JsonProperty("MessageStatusId") @Getter @Setter
	private int MessageStatusId;
	
	/**
	 * Hint in the form of a question that the recipient has to answer in order to access the message	
	 */
	@JsonProperty("PasswordHint") @Getter @Setter
	private String PasswordHint;
	
	/**
	 * True/False if message was opened	
	 */
	@JsonProperty("Read") @Getter @Setter
	private boolean Read;
	
	/**
	 * Integer referring to status of message	
	 */
	@JsonProperty("MessageStatus") @Getter @Setter
	private int MessageStatus;
	
	/**
	 * In a plain text delivery environment, this indicator forces the recipient to access the web interface to retrieve a message, so the sender receives absolute read confirmation and detailed tracking information	
	 */
	@JsonProperty("ReadConfirmation") @Getter @Setter
	private boolean ReadConfirmation;
	
	/**
	 * Sender's email address	
	 */
	@JsonProperty("SenderEmail") @Getter @Setter
	private String SenderEmail;
	
	/**
	 * Unique user identifier for the sender	
	 */
	@JsonProperty("SenderId") @Getter @Setter
	private int SenderId;
	
	/**
	 * Subject line of the message	
	 */
	@JsonProperty("Subject") @Getter @Setter
	private String Subject;
}
