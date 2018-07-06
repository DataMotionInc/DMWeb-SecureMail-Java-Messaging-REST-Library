package com.datamotion;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Attachment {	
	@JsonProperty ("AttachmentBase64") @Getter @Setter
	private String AttachmentBase64;
	
	@JsonProperty ("ContentType") @Getter @Setter
	private String ContentType;
	
	@JsonProperty ("FileName") @Getter @Setter
	private String FileName;
}
