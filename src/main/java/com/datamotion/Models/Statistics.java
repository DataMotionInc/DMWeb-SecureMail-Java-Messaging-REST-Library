package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
	@JsonProperty("AccountSize") @Getter @Setter
	private int AccountSize;
	
	@JsonProperty("AvailableAccountSize") @Getter @Setter
	private int AvailableAccountSize;
	
	@JsonProperty("DateCreated") @Getter @Setter
	private String DateCreated;
	
	@JsonProperty("DateOfLastNotice") @Getter @Setter
	private String DateOfLastNotice;
	
	@JsonProperty("DateOfLastVisit") @Getter @Setter
	private String DateOfLastVisit;
	
	@JsonProperty("DatePasswordExpires") @Getter @Setter
	private String DatePasswordExpires;
	
	@JsonProperty("TotalFilesInOutbox") @Getter @Setter
	private int TotalFilesInOutbox;
	
	@JsonProperty("TotalFilesSent") @Getter @Setter
	private int TotalFilesSent;
	
	@JsonProperty("TotalMessagesInInbox") @Getter @Setter
	private int TotalMessagesInInbox;
	
	@JsonProperty("TotalMessagesInOutbox") @Getter @Setter
	private int TotalMessagesInOutbox;
	
	@JsonProperty("TotalMessagesReceived") @Getter @Setter
	private int TotalMessagesReceived;
	
	@JsonProperty("TotalMessagesSent") @Getter @Setter
	private int TotalMessagesSent;
	
	@JsonProperty("TotalUnreadMessagesInInbox") @Getter @Setter
	private int TotalUnreadMessagesInInbox;
	
	@JsonProperty("TotalVisits") @Getter @Setter
	private int TotalVisits;
	
	@JsonProperty("UsedAccountSize") @Getter @Setter
	private int UsedAccountSize;	
}
