package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty("AttachmentCount") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int AttachmentCount;
	
	/**
	 * Date/time the message was created	
	 */
	@JsonProperty("createTimeString") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String createTimeString;
	
	/**
	 * Unique folder identifier	
	 */
	@JsonProperty("FolderId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int FolderId;
	
	/**
	 * Unique message identifier	
	 */
	@JsonProperty("MessageId") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageId;
	
	/**
	 * Size of message (bytes)	
	 */
	@JsonProperty("MessageSize") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageSize;
	
	/**
	 * True/False if message was opened	
	 */
	@JsonProperty("Read") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private boolean Read;
	
	/**
	 * Numeric indicator of the status of the message	
	 */
	@JsonProperty("MessageStatus") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int MessageStatus;
	
	/**
	 * Sender's email address
	 */
	@JsonProperty("SenderAddress") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String SenderAddress;
	
	/**
	 * Subject of the message
	 */
	@JsonProperty("Subject") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Subject;

	@Override
	public String toString() {
		return "\nSummary [\nAttachmentCount= " + AttachmentCount + "\ncreateTimeString= " + createTimeString + "\nFolderId= "
				+ FolderId + "\nMessageId= " + MessageId + "\nMessageSize= " + MessageSize + "\nRead= " + Read
				+ "\nMessageStatus= " + MessageStatus + "\nSenderAddress= " + SenderAddress + "\nSubject= " + Subject
				+ "]";
	}	
}
