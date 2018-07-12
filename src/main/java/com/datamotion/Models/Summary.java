package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Summary Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class Summary {
	/**
	 * The number of attachments sent with the message	
	 */
	@JsonProperty("AttachmentCount") @Getter @Setter
	private int AttachmentCount;
	
	/**
	 * Date/time the message was created	
	 */
	@JsonProperty("createTimeString") @Getter @Setter
	private String createTimeString;
	
	/**
	 * Unique folder identifier	
	 */
	@JsonProperty("FolderId") @Getter @Setter
	private int FolderId;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") @Getter @Setter
	private int MessageId;
	
	/**
	 * Size of message (bytes)	
	 */
	@JsonProperty("MessageSize") @Getter @Setter
	private int MessageSize;
	
	/**
	 * True/False if message was opened	
	 */
	@JsonProperty("Read") @Getter @Setter
	private boolean Read;
	
	/**
	 * Numeric indicator of the status of the message	
	 */
	@JsonProperty("MessageStatus") @Getter @Setter
	private int MessageStatus;
	
	/**
	 * Sender's email address
	 */
	@JsonProperty("SenderAddress") @Getter @Setter
	private String SenderAddress;
	
	/**
	 * Subject of the message
	 */
	@JsonProperty("Subject") @Getter @Setter
	private String Subject;	
}
