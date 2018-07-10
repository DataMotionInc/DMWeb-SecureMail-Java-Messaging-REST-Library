package com.datamotion.Models;

import com.datamotion.DMWeb;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Attachment {	
	@Getter @Setter
	private String AttachmentBase64;
	
	@Getter @Setter
	private String ContentType;
	
	@Getter @Setter
	private String FileName;
	
	@Getter @Setter
	private byte[] Bytes;
	
	@JsonCreator
	public Attachment(@JsonProperty("AttachmentBase64") String AB64,
			@JsonProperty("ContentType") String CT,
			@JsonProperty("FileName") String FN) {
		AttachmentBase64 = AB64;
		ContentType = CT;
		FN = FileName;
		DMWeb dmweb = new DMWeb();
		Bytes = dmweb.decodeBase64ToByteArray(AB64);
	}
}
