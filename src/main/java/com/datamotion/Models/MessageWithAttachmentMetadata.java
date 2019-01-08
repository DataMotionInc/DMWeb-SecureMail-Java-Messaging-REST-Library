package com.datamotion.Models;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MessageWithAttachmentMetadata {
	@JsonProperty("To")
	private ArrayList<String> To;
	
	@JsonProperty("From")
	private String From;
	
	@JsonProperty("Cc")
	private ArrayList<String> Cc;
	
	@JsonProperty("Bcc")
	private ArrayList<String> Bcc;
	
	@JsonProperty("Subject")
	private String Subject;
	
	@JsonProperty("CreateTime")
	private String CreateTime;
	
	@JsonProperty("HtmlBody")
	private String HtmlBody;
	
	@JsonProperty("TextBody")
	private String TextBody;
	
	@JsonProperty("Attachments")
	private ArrayList<AttachmentMetadata> Attachments;

	public MessageWithAttachmentMetadata() {
		// TODO Auto-generated constructor stub
	}

	public MessageWithAttachmentMetadata(ArrayList<String> to, String from, ArrayList<String> cc, ArrayList<String> bcc,
			String subject, String createTime, String htmlBody, String textBody,
			ArrayList<AttachmentMetadata> attachments) {
		To = to;
		From = from;
		Cc = cc;
		Bcc = bcc;
		Subject = subject;
		CreateTime = createTime;
		HtmlBody = htmlBody;
		TextBody = textBody;
		Attachments = attachments;
	}

	public ArrayList<String> getTo() {
		return To;
	}

	public void setTo(ArrayList<String> to) {
		To = to;
	}

	public String getFrom() {
		return From;
	}

	public void setFrom(String from) {
		From = from;
	}

	public ArrayList<String> getCc() {
		return Cc;
	}

	public void setCc(ArrayList<String> cc) {
		Cc = cc;
	}

	public ArrayList<String> getBcc() {
		return Bcc;
	}

	public void setBcc(ArrayList<String> bcc) {
		Bcc = bcc;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	public String getHtmlBody() {
		return HtmlBody;
	}

	public void setHtmlBody(String htmlBody) {
		HtmlBody = htmlBody;
	}

	public String getTextBody() {
		return TextBody;
	}

	public void setTextBody(String textBody) {
		TextBody = textBody;
	}

	public ArrayList<AttachmentMetadata> getAttachments() {
		return Attachments;
	}

	public void setAttachments(ArrayList<AttachmentMetadata> attachments) {
		Attachments = attachments;
	}
}
