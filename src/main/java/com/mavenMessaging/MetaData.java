package com.mavenMessaging;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class MetaData {
	@JsonProperty ("Attachments") @Getter @Setter
	private ArrayList<MetaAttachment> MetaAttachment;
	
	@JsonProperty("ExpirationDate") @Getter @Setter
	private String ExpirationDate;
	
	@JsonProperty("MessageId") @Getter @Setter
	private int MessageId;
	
	@JsonProperty("MessageSize") @Getter @Setter
	private int MessageSize;
	
	@JsonProperty("SecurityEnvelope") @Getter @Setter
	private SecurityEnvelope SecurityEnvelope;
	
	@JsonProperty("Tracking") @Getter @Setter
	private ArrayList<Tracking> Tracking;
}
