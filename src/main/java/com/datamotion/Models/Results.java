package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty("CreateTime") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String CreateTime;
	
	/**
	 * Last action taken by user. (0) None, (1) Replied, (2) Forwarded	
	 */
	@JsonProperty ("LastAction") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int LastAction;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageId;
	
	/**
	 * Total size (bytes) of messages contained in folder	
	 */
	@JsonProperty("MessageSize") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageSize;
	
	/**
	 * Numeric indicator of the status of the message	
	 */
	@JsonProperty("MessageStatusId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageStatusId;
	
	/**
	 * Hint in the form of a question that the recipient has to answer in order to access the message	
	 */
	@JsonProperty("PasswordHint") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String PasswordHint;
	
	/**
	 * True/False if message was opened	
	 */
	@JsonProperty("Read") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private boolean Read;
	
	/**
	 * Integer referring to status of message	
	 */
	@JsonProperty("MessageStatus") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageStatus;
	
	/**
	 * In a plain text delivery environment, this indicator forces the recipient to access the web interface to retrieve a message, so the sender receives absolute read confirmation and detailed tracking information	
	 */
	@JsonProperty("ReadConfirmation") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private boolean ReadConfirmation;
	
	/**
	 * Sender's email address	
	 */
	@JsonProperty("SenderEmail") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String SenderEmail;
	
	/**
	 * Unique user identifier for the sender	
	 */
	@JsonProperty("SenderId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int SenderId;
	
	/**
	 * Subject line of the message	
	 */
	@JsonProperty("Subject") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Subject;
}
