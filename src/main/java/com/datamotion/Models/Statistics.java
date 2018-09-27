package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Account Statistics Model Class
 */
public class Statistics {
	/**
	 * Total disk space (kb) allocated to the user's Outbox
	 */
	@JsonProperty("AccountSize") 
	private int AccountSize;
	
	/**
	 * Available disk space (kb) for the user's Outbox
	 */
	@JsonProperty("AvailableAccountSize") 
	private int AvailableAccountSize;
	
	/**
	 * Date and time the mailbox was created
	 */
	@JsonProperty("DateCreated") 
	private String DateCreated;
	
	/**
	 * Date and time the user was last sent a message notification
	 */
	@JsonProperty("DateOfLastNotice") 
	private String DateOfLastNotice;
	
	/**
	 * Date and time the user last logged into the account
	 */
	@JsonProperty("DateOfLastVisit") 
	private String DateOfLastVisit;
	
	/**
	 * Date that the user's password will expire
	 */
	@JsonProperty("DatePasswordExpires") 
	private String DatePasswordExpires;
	
	/**
	 * Total number of files in the outbox	
	 */
	@JsonProperty("TotalFilesInOutbox") 
	private int TotalFilesInOutbox;
	
	/**
	 * Total number of files sent	
	 */
	@JsonProperty("TotalFilesSent") 
	private int TotalFilesSent;
	
	/**
	 * Total number of messages in the Inbox	
	 */
	@JsonProperty("TotalMessagesInInbox") 
	private int TotalMessagesInInbox;
	
	/**
	 * Total number of messages in the Outbox	
	 */
	@JsonProperty("TotalMessagesInOutbox") 
	private int TotalMessagesInOutbox;
	
	/**
	 * Total number of messages received for the lifetime of the mailbox	
	 */
	@JsonProperty("TotalMessagesReceived") 
	private int TotalMessagesReceived;
	
	/**
	 * Total number of messages sent for the lifetime of the mailbox	
	 */
	@JsonProperty("TotalMessagesSent") 
	private int TotalMessagesSent;
	
	/**
	 * Total number of unread messages in the Inbox	
	 */
	@JsonProperty("TotalUnreadMessagesInInbox") 
	private int TotalUnreadMessagesInInbox;
	
	/**
	 * Total number of times a mailbox was ever visited	
	 */
	@JsonProperty("TotalVisits") 
	private int TotalVisits;
	
	/**
	 * Total disk space (kb) consumed by the user's Outbox	
	 */
	@JsonProperty("UsedAccountSize") 
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

	@JsonIgnore
	public Statistics() {
		AccountSize = 0;
		AvailableAccountSize = 0;
		DateCreated = null;
		DateOfLastNotice = null;
		DateOfLastVisit = null;
		DatePasswordExpires = null;
		TotalFilesInOutbox = 0;
		TotalFilesSent = 0;
		TotalMessagesInInbox = 0;
		TotalMessagesInOutbox = 0;
		TotalMessagesReceived = 0;
		TotalMessagesSent = 0;
		TotalUnreadMessagesInInbox = 0;
		TotalVisits = 0;
		UsedAccountSize = 0;
	}

	@JsonIgnore
	public Statistics(int accountSize, int availableAccountSize, String dateCreated, String dateOfLastNotice,
			String dateOfLastVisit, String datePasswordExpires, int totalFilesInOutbox, int totalFilesSent,
			int totalMessagesInInbox, int totalMessagesInOutbox, int totalMessagesReceived, int totalMessagesSent,
			int totalUnreadMessagesInInbox, int totalVisits, int usedAccountSize) {
		AccountSize = accountSize;
		AvailableAccountSize = availableAccountSize;
		DateCreated = dateCreated;
		DateOfLastNotice = dateOfLastNotice;
		DateOfLastVisit = dateOfLastVisit;
		DatePasswordExpires = datePasswordExpires;
		TotalFilesInOutbox = totalFilesInOutbox;
		TotalFilesSent = totalFilesSent;
		TotalMessagesInInbox = totalMessagesInInbox;
		TotalMessagesInOutbox = totalMessagesInOutbox;
		TotalMessagesReceived = totalMessagesReceived;
		TotalMessagesSent = totalMessagesSent;
		TotalUnreadMessagesInInbox = totalUnreadMessagesInInbox;
		TotalVisits = totalVisits;
		UsedAccountSize = usedAccountSize;
	}

	@JsonIgnore
	public int getAccountSize() {
		return AccountSize;
	}

	@JsonIgnore
	public void setAccountSize(int accountSize) {
		AccountSize = accountSize;
	}

	@JsonIgnore
	public int getAvailableAccountSize() {
		return AvailableAccountSize;
	}

	@JsonIgnore
	public void setAvailableAccountSize(int availableAccountSize) {
		AvailableAccountSize = availableAccountSize;
	}

	@JsonIgnore
	public String getDateCreated() {
		return DateCreated;
	}

	@JsonIgnore
	public void setDateCreated(String dateCreated) {
		DateCreated = dateCreated;
	}

	@JsonIgnore
	public String getDateOfLastNotice() {
		return DateOfLastNotice;
	}

	@JsonIgnore
	public void setDateOfLastNotice(String dateOfLastNotice) {
		DateOfLastNotice = dateOfLastNotice;
	}

	@JsonIgnore
	public String getDateOfLastVisit() {
		return DateOfLastVisit;
	}

	@JsonIgnore
	public void setDateOfLastVisit(String dateOfLastVisit) {
		DateOfLastVisit = dateOfLastVisit;
	}

	@JsonIgnore
	public String getDatePasswordExpires() {
		return DatePasswordExpires;
	}

	@JsonIgnore
	public void setDatePasswordExpires(String datePasswordExpires) {
		DatePasswordExpires = datePasswordExpires;
	}

	@JsonIgnore
	public int getTotalFilesInOutbox() {
		return TotalFilesInOutbox;
	}

	@JsonIgnore
	public void setTotalFilesInOutbox(int totalFilesInOutbox) {
		TotalFilesInOutbox = totalFilesInOutbox;
	}

	@JsonIgnore
	public int getTotalFilesSent() {
		return TotalFilesSent;
	}

	@JsonIgnore
	public void setTotalFilesSent(int totalFilesSent) {
		TotalFilesSent = totalFilesSent;
	}

	@JsonIgnore
	public int getTotalMessagesInInbox() {
		return TotalMessagesInInbox;
	}

	@JsonIgnore
	public void setTotalMessagesInInbox(int totalMessagesInInbox) {
		TotalMessagesInInbox = totalMessagesInInbox;
	}

	@JsonIgnore
	public int getTotalMessagesInOutbox() {
		return TotalMessagesInOutbox;
	}

	@JsonIgnore
	public void setTotalMessagesInOutbox(int totalMessagesInOutbox) {
		TotalMessagesInOutbox = totalMessagesInOutbox;
	}

	@JsonIgnore
	public int getTotalMessagesReceived() {
		return TotalMessagesReceived;
	}

	@JsonIgnore
	public void setTotalMessagesReceived(int totalMessagesReceived) {
		TotalMessagesReceived = totalMessagesReceived;
	}

	@JsonIgnore
	public int getTotalMessagesSent() {
		return TotalMessagesSent;
	}

	@JsonIgnore
	public void setTotalMessagesSent(int totalMessagesSent) {
		TotalMessagesSent = totalMessagesSent;
	}

	@JsonIgnore
	public int getTotalUnreadMessagesInInbox() {
		return TotalUnreadMessagesInInbox;
	}

	@JsonIgnore
	public void setTotalUnreadMessagesInInbox(int totalUnreadMessagesInInbox) {
		TotalUnreadMessagesInInbox = totalUnreadMessagesInInbox;
	}

	@JsonIgnore
	public int getTotalVisits() {
		return TotalVisits;
	}

	@JsonIgnore
	public void setTotalVisits(int totalVisits) {
		TotalVisits = totalVisits;
	}

	@JsonIgnore
	public int getUsedAccountSize() {
		return UsedAccountSize;
	}

	@JsonIgnore
	public void setUsedAccountSize(int usedAccountSize) {
		UsedAccountSize = usedAccountSize;
	}
	
	
}
