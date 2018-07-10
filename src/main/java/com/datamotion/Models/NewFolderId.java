package com.datamotion;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
public class NewFolderId {
	@JsonProperty("FolderId") @Getter @Setter
	private int FolderId;
}
