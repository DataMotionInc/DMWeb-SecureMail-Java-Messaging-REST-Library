package com.datamotion.Models;

import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Message Model Class
 */
public class Message {
	/**
	 * An array of recipients of the email message	
	 */
	@JsonProperty("To") 
	private ArrayList<String> To;
	
	/**
	 * An array of recipients of the email message	
	 */
	@JsonProperty("From") 
	private String From;
	
	/**
	 * An array of recipients carbon copied on the email message	
	 */
	@JsonProperty("Cc") 
	private ArrayList<String> Cc;
	
	/**
	 * An array of recipients blind carbon copied on the email message	
	 */
	@JsonProperty("Bcc") 
	private ArrayList<String> Bcc;
	
	/**
	 * The subject line of the email message	
	 */
	@JsonProperty ("Subject") 
	private String Subject;
	
	/**
	 * Date/Time string for when message is created	
	 */
	@JsonProperty("CreateTime") 
	private String CreateTime;
	
	/**
	 * Array of attachments
	 * see Attachment Model class
	 */
	@JsonProperty("Attachments") 
	private ArrayList<Attachment> Attachments;
	
	/**
	 * The HTML body of the email message	
	 */
	@JsonProperty("HtmlBody") 
	private String HtmlBody;
	
	/**
	 * The text body of the email message	
	 */
	@JsonProperty("TextBody") 
	private String TextBody;

	
	public Message() {
		To = null;
		From = null;
		Cc = null;
		Bcc = null;
		Subject = null;
		CreateTime = null;
		Attachments = null;
		HtmlBody = null;
		TextBody = null;
	}

	
	public Message(ArrayList<String> to, String from, ArrayList<String> cc, ArrayList<String> bcc, String subject,
			String createTime, ArrayList<Attachment> attachments, String htmlBody, String textBody) {
		To = to;
		From = from;
		Cc = cc;
		Bcc = bcc;
		Subject = subject;
		CreateTime = createTime;
		Attachments = attachments;
		HtmlBody = htmlBody;
		TextBody = textBody;
	}

	@JsonIgnore
	public ArrayList<String> getTo() {
		return To;
	}

	@JsonIgnore
	public void setTo(ArrayList<String> to) {
		To = to;
	}

	@JsonIgnore
	public String getFrom() {
		return From;
	}

	@JsonIgnore
	public void setFrom(String from) {
		From = from;
	}

	@JsonIgnore
	public ArrayList<String> getCc() {
		return Cc;
	}

	@JsonIgnore
	public void setCc(ArrayList<String> cc) {
		Cc = cc;
	}

	@JsonIgnore
	public ArrayList<String> getBcc() {
		return Bcc;
	}

	@JsonIgnore
	public void setBcc(ArrayList<String> bcc) {
		Bcc = bcc;
	}

	@JsonIgnore
	public String getSubject() {
		return Subject;
	}

	@JsonIgnore
	public void setSubject(String subject) {
		Subject = subject;
	}

	@JsonIgnore
	public String getCreateTime() {
		return CreateTime;
	}

	@JsonIgnore
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	@JsonIgnore
	public ArrayList<Attachment> getAttachments() {
		return Attachments;
	}

	@JsonIgnore
	public void setAttachments(ArrayList<Attachment> attachments) {
		Attachments = attachments;
	}

	@JsonIgnore
	public String getHtmlBody() {
		return HtmlBody;
	}

	@JsonIgnore
	public void setHtmlBody(String htmlBody) {
		HtmlBody = htmlBody;
	}

	@JsonIgnore
	public String getTextBody() {
		return TextBody;
	}

	@JsonIgnore
	public void setTextBody(String textBody) {
		TextBody = textBody;
	}	
}
