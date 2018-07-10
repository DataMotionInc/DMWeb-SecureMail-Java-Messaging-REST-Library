package com.datamotion;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Message {
	@JsonProperty("To") @Getter @Setter
	private ArrayList<String> To;
	
	@JsonProperty("From") @Getter @Setter
	private String From;
	
	@JsonProperty("Cc") @Getter @Setter
	private ArrayList<String> Cc;
	
	@JsonProperty("Bcc") @Getter @Setter
	private ArrayList<String> Bcc;
	
	@JsonProperty ("Subject") @Getter @Setter
	private String Subject;
	
	@JsonProperty("CreateTime") @Getter @Setter
	private String CreateTime;
	
	@JsonProperty("Attachments") @Getter @Setter
	private ArrayList<Attachment> Attachments;
	
	@JsonProperty("HtmlBody") @Getter @Setter
	private String HtmlBody;
	
	@JsonProperty("TextBody") @Getter @Setter
	private String TextBody;	
}
