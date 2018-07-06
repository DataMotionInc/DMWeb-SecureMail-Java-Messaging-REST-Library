package com.datamotion;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Summary {
	@JsonProperty("AttachmentCount") @Getter @Setter
	private int AttachmentCount;
	
	@JsonProperty("createTimeString") @Getter @Setter
	private String createTimeString;
	
	@JsonProperty("FolderId") @Getter @Setter
	private int FolderId;
	
	@JsonProperty("MessageId") @Getter @Setter
	private int MessageId;
	
	@JsonProperty("MessageSize") @Getter @Setter
	private int MessageSize;
	
	@JsonProperty("Read") @Getter @Setter
	private boolean Read;
	
	@JsonProperty("MessageStatus") @Getter @Setter
	private int MessageStatus;
	
	@JsonProperty("SenderAddress") @Getter @Setter
	private String SenderAddress;
	
	@JsonProperty("Subject") @Getter @Setter
	private String Subject;	
}
