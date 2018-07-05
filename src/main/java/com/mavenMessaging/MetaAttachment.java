package com.mavenMessaging;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class MetaAttachment {
	@JsonProperty("AttachmentId") @Getter @Setter
	private int AttachmentId;
	
	@JsonProperty("FileName") @Getter @Setter
	private String FileName;
	
	@JsonProperty("SecurityEnvelope") @Getter @Setter
	private SecurityEnvelope SecurityEnvelope;
	
	@JsonProperty("Size") @Getter @Setter
	private Size Size;
	
	@JsonProperty("Tracking") @Getter @Setter
	private ArrayList<Recipients> Tracking;
}
