package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonProperty("AccountSize") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int AccountSize;
	
	/**
	 * Available disk space (kb) for the user's Outbox
	 */
	@JsonProperty("AvailableAccountSize") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int AvailableAccountSize;
	
	/**
	 * Date and time the mailbox was created
	 */
	@JsonProperty("DateCreated") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String DateCreated;
	
	/**
	 * Date and time the user was last sent a message notification
	 */
	@JsonProperty("DateOfLastNotice") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String DateOfLastNotice;
	
	/**
	 * Date and time the user last logged into the account
	 */
	@JsonProperty("DateOfLastVisit") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String DateOfLastVisit;
	
	/**
	 * Date that the user's password will expire
	 */
	@JsonProperty("DatePasswordExpires") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private String DatePasswordExpires;
	
	/**
	 * Total number of files in the outbox	
	 */
	@JsonProperty("TotalFilesInOutbox") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalFilesInOutbox;
	
	/**
	 * Total number of files sent	
	 */
	@JsonProperty("TotalFilesSent") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalFilesSent;
	
	/**
	 * Total number of messages in the Inbox	
	 */
	@JsonProperty("TotalMessagesInInbox") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalMessagesInInbox;
	
	/**
	 * Total number of messages in the Outbox	
	 */
	@JsonProperty("TotalMessagesInOutbox") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalMessagesInOutbox;
	
	/**
	 * Total number of messages received for the lifetime of the mailbox	
	 */
	@JsonProperty("TotalMessagesReceived") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalMessagesReceived;
	
	/**
	 * Total number of messages sent for the lifetime of the mailbox	
	 */
	@JsonProperty("TotalMessagesSent") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalMessagesSent;
	
	/**
	 * Total number of unread messages in the Inbox	
	 */
	@JsonProperty("TotalUnreadMessagesInInbox") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalUnreadMessagesInInbox;
	
	/**
	 * Total number of times a mailbox was ever visited	
	 */
	@JsonProperty("TotalVisits") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
	private int TotalVisits;
	
	/**
	 * Total disk space (kb) consumed by the user's Outbox	
	 */
	@JsonProperty("UsedAccountSize") 
	@Getter (onMethod_=@JsonIgnore)
	@Setter (onMethod_=@JsonIgnore)
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
