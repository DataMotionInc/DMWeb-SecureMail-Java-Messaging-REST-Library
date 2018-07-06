package com.datamotion;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class SecurityEnvelope {
	@JsonProperty("Checksum") @Getter @Setter
	private String Checksum;
	
	@JsonProperty("HashAlgorithm") @Getter @Setter
	private String HashAlgorithm;
	
	@JsonProperty("Status") @Getter @Setter
	private int Status;
	
	@JsonProperty("StatusDescription") @Getter @Setter
	private String StatusDescription;
}
