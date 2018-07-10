package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class MessageIDget {
	@JsonProperty("FolderID") @Getter @Setter
	private int FolderID;
	
	@JsonProperty("MessageListFilter") @Getter @Setter
	private int MessageListFilter;
	
	@JsonProperty("MustHaveAttachments") @Getter @Setter
	private boolean MustHaveAttachments;	
}
