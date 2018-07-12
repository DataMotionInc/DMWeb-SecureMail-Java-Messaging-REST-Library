package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Message Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class Message {
	/**
	 * An array of recipients of the email message	
	 */
	@JsonProperty("To") @Getter @Setter
	private ArrayList<String> To;
	
	/**
	 * An array of recipients of the email message	
	 */
	@JsonProperty("From") @Getter @Setter
	private String From;
	
	/**
	 * An array of recipients carbon copied on the email message	
	 */
	@JsonProperty("Cc") @Getter @Setter
	private ArrayList<String> Cc;
	
	/**
	 * An array of recipients blind carbon copied on the email message	
	 */
	@JsonProperty("Bcc") @Getter @Setter
	private ArrayList<String> Bcc;
	
	/**
	 * The subject line of the email message	
	 */
	@JsonProperty ("Subject") @Getter @Setter
	private String Subject;
	
	/**
	 * Date/Time string for when message is created	
	 */
	@JsonProperty("CreateTime") @Getter @Setter
	private String CreateTime;
	
	/**
	 * Array of attachments
	 * see Attachment Model class
	 */
	@JsonProperty("Attachments") @Getter @Setter
	private ArrayList<Attachment> Attachments;
	
	/**
	 * The HTML body of the email message	
	 */
	@JsonProperty("HtmlBody") @Getter @Setter
	private String HtmlBody;
	
	/**
	 * The text body of the email message	
	 */
	@JsonProperty("TextBody") @Getter @Setter
	private String TextBody;	
}
