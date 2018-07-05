package com.mavenMessaging;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class MessageId {
	@JsonProperty("MessageId") @Getter @Setter
	private int MessageId;
}
