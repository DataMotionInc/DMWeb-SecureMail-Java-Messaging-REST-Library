package com.datamotion.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Folder {
	@JsonProperty ("FolderId") @Getter @Setter
	private int FolderId;
	
	@JsonProperty ("FolderName") @Getter @Setter
	private String FolderName;
	
	@JsonProperty("FolderType") @Getter @Setter
	private int FolderType;
	
	@JsonProperty("FolderTypeDescription") @Getter @Setter
	private String FolderTypeDescription;
	
	@JsonProperty("IsSystemFolder") @Getter @Setter
	private boolean IsSystemFolder;
	
	@JsonProperty("TotalMessages") @Getter @Setter
	private int TotalMessages;
	
	@JsonProperty("TotalSize") @Getter @Setter
	private int TotalSize;
}
