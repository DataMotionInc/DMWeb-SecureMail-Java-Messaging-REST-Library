package com.datamotion;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

@AllArgsConstructor
@NoArgsConstructor
public class Folders {
	@JsonProperty("Folders") @Getter @Setter
	private ArrayList<Folder> Folders;
}
