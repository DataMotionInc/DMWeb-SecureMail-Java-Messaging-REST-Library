package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Account Statistics Model Class
 */
@AllArgsConstructor
@NoArgsConstructor
public class Statistics {
	/**
	 * Total disk space (kb) allocated to the user's Outbox
	 */
	@JsonProperty("AccountSize") @Getter @Setter
	private int AccountSize;
	
	/**
	 * Available disk space (kb) for the user's Outbox
	 */
	@JsonProperty("AvailableAccountSize") @Getter @Setter
	private int AvailableAccountSize;
	
	/**
	 * Date and time the mailbox was created
	 */
	@JsonProperty("DateCreated") @Getter @Setter
	private String DateCreated;
	
	/**
	 * Date and time the user was last sent a message notification
	 */
	@JsonProperty("DateOfLastNotice") @Getter @Setter
	private String DateOfLastNotice;
	
	/**
	 * Date and time the user last logged into the account
	 */
	@JsonProperty("DateOfLastVisit") @Getter @Setter
	private String DateOfLastVisit;
	
	/**
	 * Date that the user's password will expire
	 */
	@JsonProperty("DatePasswordExpires") @Getter @Setter
	private String DatePasswordExpires;
	
	/**
	 * Total number of files in the outbox	
	 */
	@JsonProperty("TotalFilesInOutbox") @Getter @Setter
	private int TotalFilesInOutbox;
	
	/**
	 * Total number of files sent	
	 */
	@JsonProperty("TotalFilesSent") @Getter @Setter
	private int TotalFilesSent;
	
	/**
	 * Total number of messages in the Inbox	
	 */
	@JsonProperty("TotalMessagesInInbox") @Getter @Setter
	private int TotalMessagesInInbox;
	
	/**
	 * Total number of messages in the Outbox	
	 */
	@JsonProperty("TotalMessagesInOutbox") @Getter @Setter
	private int TotalMessagesInOutbox;
	
	/**
	 * Total number of messages received for the lifetime of the mailbox	
	 */
	@JsonProperty("TotalMessagesReceived") @Getter @Setter
	private int TotalMessagesReceived;
	
	/**
	 * Total number of messages sent for the lifetime of the mailbox	
	 */
	@JsonProperty("TotalMessagesSent") @Getter @Setter
	private int TotalMessagesSent;
	
	/**
	 * Total number of unread messages in the Inbox	
	 */
	@JsonProperty("TotalUnreadMessagesInInbox") @Getter @Setter
	private int TotalUnreadMessagesInInbox;
	
	/**
	 * Total number of times a mailbox was ever visited	
	 */
	@JsonProperty("TotalVisits") @Getter @Setter
	private int TotalVisits;
	
	/**
	 * Total disk space (kb) consumed by the user's Outbox	
	 */
	@JsonProperty("UsedAccountSize") @Getter @Setter
	private int UsedAccountSize;

	@Override
	public String toString() {
		return "Statistics [\nAccountSize = " + AccountSize + "\nAvailableAccountSize= " + AvailableAccountSize
				+ "\nDateCreated= " + DateCreated + "\nDateOfLastNotice= " + DateOfLastNotice + "\nDateOfLastVisit= "
				+ DateOfLastVisit + "\nDatePasswordExpires= " + DatePasswordExpires + "\nTotalFilesInOutbox= "
				+ TotalFilesInOutbox + "\nTotalFilesSent= " + TotalFilesSent + "\nTotalMessagesInInbox= "
				+ TotalMessagesInInbox + "\nTotalMessagesInOutbox= " + TotalMessagesInOutbox + "\nTotalMessagesReceived= "
				+ TotalMessagesReceived + "\nTotalMessagesSent= " + TotalMessagesSent + "\nTotalUnreadMessagesInInbox= "
				+ TotalUnreadMessagesInInbox + "\nTotalVisits= " + TotalVisits + "\nUsedAccountSize= " + UsedAccountSize
				+ "]";
	}
	
	
}
