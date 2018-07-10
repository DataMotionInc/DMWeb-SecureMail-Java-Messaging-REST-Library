package com.datamotion;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class NewFolder {
	@JsonProperty("FolderName") @Getter @Setter
	private String FolderName;
	
	@JsonProperty("FolderType") @Getter @Setter
	private int FolderType;	
}
