package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Tracking {
	@JsonProperty("DateOpened") @Getter @Setter
	private String DateOpened;
	
	@JsonProperty("Email") @Getter @Setter
	private String Email;
	
	@JsonProperty("MessageStatusDescription") @Getter @Setter
	private String MessageStatusDescription;
	
	@JsonProperty("MessageStatusId") @Getter @Setter
	private int MessageStatusId;
	
	@JsonProperty("ReceiverField") @Getter @Setter
	private String ReceiverField;
}
