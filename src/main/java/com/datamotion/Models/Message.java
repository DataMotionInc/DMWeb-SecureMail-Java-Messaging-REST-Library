package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	@JsonProperty("To") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<String> To;
	
	/**
	 * An array of recipients of the email message	
	 */
	@JsonProperty("From") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String From;
	
	/**
	 * An array of recipients carbon copied on the email message	
	 */
	@JsonProperty("Cc") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<String> Cc;
	
	/**
	 * An array of recipients blind carbon copied on the email message	
	 */
	@JsonProperty("Bcc") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<String> Bcc;
	
	/**
	 * The subject line of the email message	
	 */
	@JsonProperty ("Subject") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String Subject;
	
	/**
	 * Date/Time string for when message is created	
	 */
	@JsonProperty("CreateTime") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String CreateTime;
	
	/**
	 * Array of attachments
	 * see Attachment Model class
	 */
	@JsonProperty("Attachments") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private ArrayList<Attachment> Attachments;
	
	/**
	 * The HTML body of the email message	
	 */
	@JsonProperty("HtmlBody") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String HtmlBody;
	
	/**
	 * The text body of the email message	
	 */
	@JsonProperty("TextBody") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String TextBody;	
}
