package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Recipients {
	@JsonProperty("ChecksumValidated") @Getter @Setter
	private int ChecksumValidated;
	
	@JsonProperty("Delivered") @Getter @Setter
	private boolean Delivered;
	
	@JsonProperty("DeliveredDate") @Getter @Setter
	private String DeliveredDate;
	
	@JsonProperty("Downloaded") @Getter @Setter
	private boolean Downloaded;
	
	@JsonProperty("DownloadedDate") @Getter @Setter
	private String DownloadedDate;
	
	@JsonProperty("Email") @Getter @Setter
	private String Email;
}
